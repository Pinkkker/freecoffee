package com.pink.forum.controller;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import com.pink.forum.message.Result;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program Gitforum
 * @description 用户接口
 * @author DengPengfei
 * @create 2021-12-29 14:17
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    final UserMapper userMapper;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody Map<String, String> data) {
        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(data.get("username"), data.get("password"));
            subject.login(token);
            return Result.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException e){
            return Result.bad("用户名密码错误");
        }
    }

    /**
     * @description 用户登出
     */
    @PostMapping("/logout")
    public Result userLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        System.out.println("登出");
        return Result.ok();
    }

    /**
     * @description 更新个人信息
     */
    @PutMapping("/me")
    public Result updatePersonalInformation(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        User cur = (User) subject.getPrincipal();
        user.setId(cur.getId());
        userMapper.updateByPrimaryKeySelective(user);

        return Result.ok(user);
    }

    /**
     * @description 获取当前登录状态
     */
    @GetMapping("/me")
    public Result loginStatus() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return Result.ok(user);
    }
}
