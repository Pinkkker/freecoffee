package com.pink.forum.controller;

import com.pink.forum.entity.User;
import com.pink.forum.message.Result;
import com.pink.forum.service.UserService;
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

    final UserService userService;

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

    @PutMapping("/me")
    public Result updateInfo(@RequestBody Map<String, String> data) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String flag = data.get("flag");
        if (flag.equals("0")) {
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
        return Result.ok();
    }

    @GetMapping("/notLogin")
    public Result notLogin() {
        return Result.bad("未授权");
    }

}
