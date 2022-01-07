package com.pink.forum.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pink.forum.message.Result;
import com.pink.forum.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengpengfei
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(tags = "Github登录")
public class GithubLoginController {
    @Autowired
    RestTemplate restTemplate;

    final UserService userService;

    @GetMapping("github.html")
    public String index(){
        return "github";
    }

    @ApiOperation("创建github用户")
    @GetMapping("main.html")
    public Result authorizationCode(@RequestParam("code")String code, @RequestParam("state") String state) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", "da8c28bcfd991b5b2774");
        map.put("client_secret", "bb5e4ba3f6737e60d37e76c4a5d59841697ba7c7");
        map.put("state", state);
        map.put("code", code);
        map.put("redirect_uri", "http://localhost:8080/api/v1/main.html");
        Map<String,String> resp = restTemplate.postForObject("https://github.com/login/oauth/access_token", map, Map.class);
        System.out.println(resp);
        HttpHeaders httpheaders = new HttpHeaders();
        assert resp != null;
        httpheaders.add("Authorization", "token " + resp.get("access_token"));
        HttpEntity<?> httpEntity = new HttpEntity<>(httpheaders);
        ResponseEntity<Map> exchange = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, httpEntity, Map.class);
        String username = new ObjectMapper().writeValueAsString(exchange.getBody().get("login"));
        String userId = new ObjectMapper().writeValueAsString(exchange.getBody().get("node_id"));
        String userAvatar = new ObjectMapper().writeValueAsString(exchange.getBody().get("avatar_url"));

        System.out.println("exchange.getBody() = " + new ObjectMapper().writeValueAsString(exchange.getBody()  ));
        System.out.println("exchange.getBody() = " + username.substring(1, username.length()-1));
        System.out.println("exchange.getBody() = " + userId.substring(1, userId.length()-1));
        System.out.println("exchange.getBody() = " + userAvatar.substring(1, userAvatar.length()-1));

        if (userService.githubRegister(username.substring(1, username.length()-1), userId.substring(1, userId.length()-1), userAvatar.substring(1, userAvatar.length()-1)) == 1) {
            return Result.ok();
        } else {
            return Result.bad("登录失败");
        }
    }
}