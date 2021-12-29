package com.pink.forum.controller;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.message.Result;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    final UserMapper userMapper;

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
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        HashMap<String, String> data = new HashMap<>(){{
            put("username", user.getName());
        }};
        return Result.ok(data);
    }

    @GetMapping("/notLogin")
    public Result notLogin() {
        return Result.bad("未授权");
    }

}
