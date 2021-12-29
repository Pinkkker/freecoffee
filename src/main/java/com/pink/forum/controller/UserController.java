package com.pink.forum.controller;

import com.pink.forum.dao.UserMapper;
import com.pink.forum.entity.User;
import com.pink.forum.entity.UserExample;
import com.pink.forum.message.Result;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @program: Gitforum
 * @description: 用户接口
 * @author: DengPengfei
 * @create: 2021-12-29 14:17
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    final UserMapper userMapper;

    /**
     * @description: 用户登录
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody Map<String, String> data) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andNameEqualTo(data.get("username")).andPasswordEqualTo(data.get("password"));
        List<User> list = userMapper.selectByExample(userExample);

        if (list == null || list.size() == 0) {
            return Result.bad();
        }else {
            return Result.ok();
        }
    }

    /**
     * @description: 用户登出
     */
    @PostMapping("/logout")
    public Result userLogout() {
        System.out.println("登出");
        return Result.ok();
    }

    /**
     * @description: 更新个人信息
     */
    @PutMapping("/me")
    public Result updatePersonalInformation(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            Integer id  = (Integer) subject.getSession().getAttribute("ID");
            User updateUser = userMapper.selectByPrimaryKey(id);

            updateUser.setName(user.getName());
            updateUser.setAge(user.getAge());
            updateUser.setPhoneNumber(user.getPhoneNumber());
            updateUser.setPassword(user.getPassword());

            userMapper.updateByPrimaryKeySelective(updateUser);

            return Result.ok();
        }else {
            return Result.bad();
        }
    }

    /**
     * @description: 获取当前登录状态
     */
//    @GetMapping("/me")
//    public Map<String, Object> loginStatus(HttpServletResponse response) {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//            response.setStatus(200);
//            int id =
//        }
//    }
}
