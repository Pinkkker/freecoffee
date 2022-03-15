package com.pink.freecoffee.controller;

import com.pink.freecoffee.dao.PostMapper;
import com.pink.freecoffee.dao.TechnologyStackMapper;
import com.pink.freecoffee.entity.PostExample;
import com.pink.freecoffee.entity.TechnologyStackExample;
import com.pink.freecoffee.entity.User;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.UserService;
import com.pink.freecoffee.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@ApiIgnore
public class AdminController {

    final UserService userService;
    final TechnologyStackMapper technologyStackMapper;
    final PostMapper postMapper;

    @GetMapping("/login")
    public Result getAllUser() {
        List<User> users = userService.selectAll();
        return Result.ok(users);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> data) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        try {
            //封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(data.get("username"), data.get("password"));
            //执行登录
            subject.login(token);
            return Result.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return Result.bad("用户名密码错误");
        }
    }

    @PostMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("登出");
        return Result.ok();
    }

    @GetMapping("/me")
    public Result getStatus() {
        return Result.ok(ShiroUtils.getUser());
    }

    @PutMapping("/me")
    public Result updateInfo(@RequestBody Map<String, String> data) {
        User user = ShiroUtils.getUser();
        String flag = data.get("flag");
        if ("0".equals(flag)) {
            String username = data.get("username");
            user.setName(username);
            userService.updateByPrimaryKeySelective(user);
        } else {
            String oldP = data.get("oldP");
            String newP = data.get("newP");
            if (user.getPassword().equals(oldP)) {
                user.setPassword(newP);
                userService.updateByPrimaryKeySelective(user);
            } else {
                return Result.bad("密码错误");
            }
        }
        return Result.ok(user);
    }

    @GetMapping("/posts")
    public Result getPosts() {
        return Result.ok(postMapper.selectByExample(new PostExample()));
    }

    @GetMapping("/techs")
    public Result getTechs() {
        return Result.ok(technologyStackMapper.selectByExample(new TechnologyStackExample()));
    }

//    @CrossOrigin
//    @GetMapping("/notLogin")
//    public Result notLogin() {
//        return Result.bad("未授权");
//    }

}
