package com.pink.freecoffee.controller;

import com.pink.freecoffee.entity.User;
import com.pink.freecoffee.message.Request;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.UserService;
import com.pink.freecoffee.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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
        User newUser = userService.updateByPrimaryKeySelective(user);
        if (!"root".equals(ShiroUtils.getUser().getAuthorization())) {
            ShiroUtils.setUser(newUser);
        }
        return Result.ok(newUser);
    }

    /**
     * @description 删除用户
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/me/{id}")
    public Result deleteUser(@PathVariable int id) {
        int res = userService.deleteUser(id);
        if (res == 1) {
            return Result.ok();
        } else {
            return Result.bad("删除失败");
        }
    }

    /**
     * @description 获取当前登录状态
     */
    @ApiOperation("获取当前登录状态")
    @GetMapping("/me")
    @RequiresAuthentication
    public Result loginStatus() {
        User user = ShiroUtils.getUser();
        return Result.ok(user);
    }

    @ApiOperation("获取指定用户信息")
    @GetMapping("/me/{id}")
    public Result getInfo(@PathVariable("id") int id) {
        User user = userService.selectById(id);
        if (user != null) {
            return Result.ok(user);
        } else {
            return Result.bad("找不到这个用户");
        }
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
