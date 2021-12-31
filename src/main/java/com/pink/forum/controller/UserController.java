package com.pink.forum.controller;

import com.pink.forum.entity.User;
import com.pink.forum.message.Request;
import com.pink.forum.message.Result;
import com.pink.forum.service.UserService;
import com.pink.forum.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author DengPengfei
 * @program Gitforum
 * @description 用户接口
 * @create 2021-12-29 14:17
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "用户登录管理")
public class UserController {

    final UserService userService;

    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result userLogin(@RequestBody Request request) {
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
            subject.login(token);
            return Result.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return Result.bad("用户名密码错误");
        }
    }

    /**
     * @description 用户登出
     */
    @ApiOperation("用户登出")
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
    @ApiOperation("更新用户信息")
    @PutMapping("/me")
    public Result updatePersonalInformation(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        User cur = (User) subject.getPrincipal();
        user.setId(cur.getId());
        User newUser = userService.updateByPrimaryKeySelective(user);
        ShiroUtils.setUser(newUser);
        return Result.ok(newUser);
    }

    /**
     * @description 获取当前登录状态
     */
    @ApiOperation("获取当前登录状态")
    @GetMapping("/me")
    public Result loginStatus() {
        return Result.ok(ShiroUtils.getUser());
    }

    /**
     * @description 注册
     */
    @ApiOperation("注册")
    @PostMapping("/me")
    public Result register(@RequestBody Request request) {
        if (userService.register(request.getUsername(), request.getPassword(), request.getNickName()) == 1) {
            return Result.ok();
        } else {
            return Result.bad("注册失败");
        }
    }
}
