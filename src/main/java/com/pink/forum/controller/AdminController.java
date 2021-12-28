package com.pink.forum.controller;

import com.pink.forum.dao.AdminMapper;
import com.pink.forum.entity.Admin;
import com.pink.forum.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    final AdminMapper adminMapper;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> data) {
        Admin admin = adminMapper.selectByName(data.get("username"));
        if (admin != null && admin.getPassword().equals(data.get("password"))) {
            return Result.ok();
        } else {
            return Result.bad();
        }
    }

    @PostMapping("/logout")
    public Result logout() {
        System.out.println("登出");
        return Result.ok();
    }

    @GetMapping("/me")
    public Result getStatus() {
        return Result.ok();
    }

}
