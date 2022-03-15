package com.pink.freecoffee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pink.freecoffee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengpengfei
 */

@SuppressWarnings("unchecked")
@Controller
@RequiredArgsConstructor
@Api(tags = "Github登录")
public class GithubLoginController {
    @Autowired
    RestTemplate restTemplate;

    final UserService userService;

    @ApiOperation("创建github用户")
    @GetMapping("/success.html")
    public String authorizationCode(@RequestParam("code")String code, @RequestParam("state") String state) throws JsonProcessingException {
        Subject subject = SecurityUtils.getSubject();

        Map<String, String> map = new HashMap<>();
        map.put("client_id", "da8c28bcfd991b5b2774");
        map.put("client_secret", "bb5e4ba3f6737e60d37e76c4a5d59841697ba7c7");
        map.put("state", state);
        map.put("code", code);
        map.put("redirect_uri", "http://localhost:8080/success.html");
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

        username = username.substring(1, username.length()-1);
        userId = userId.substring(1, userId.length()-1);
        userAvatar = userAvatar.substring(1, userAvatar.length()-1);

        System.out.println("exchange.getBody() = " + new ObjectMapper().writeValueAsString(exchange.getBody()  ));
        System.out.println("exchange.getBody() = " + username);
        System.out.println("exchange.getBody() = " + userId);
        System.out.println("exchange.getBody() = " + userAvatar);

        if (userService.githubRegister(username, userId, userAvatar) != 1) {
            return "fail";
        }

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, "123456");
            subject.login(token);
            return "success";
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return "fail";
        }
    }
}