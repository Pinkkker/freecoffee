package com.pink.forum.controller;

import com.pink.forum.message.Result;
import com.pink.forum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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

}
