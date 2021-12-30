package com.pink.forum.controller;

import com.pink.forum.entity.Comment;
import com.pink.forum.entity.User;
import com.pink.forum.message.Result;
import com.pink.forum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {

    final CommentService commentService;

    @GetMapping("/comments")
    public Result selectAll(@RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum, @RequestParam("postId") String postId) {
        Result result = commentService.selectAll(Integer.parseInt(pageSize), Integer.parseInt(pageNum), Integer.parseInt(postId));
        result.setCode("200");
        result.setMsg("OK");
        return result;
    }

    @PostMapping("/comments")
    public Result createComment(@RequestBody Comment comment) {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = ((User) subject.getPrincipal()).getId();
        comment.setUser_id(userId);
        commentService.insertSelective(comment);
        return Result.ok(comment);
    }

    @DeleteMapping("/comments/{id}")
    public Result deleteComment(@PathVariable("id") int id) {
        return commentService.deleteByPrimaryKey(id);
    }

}
