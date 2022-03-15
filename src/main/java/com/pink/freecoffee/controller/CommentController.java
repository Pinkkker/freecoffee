package com.pink.freecoffee.controller;

import com.pink.freecoffee.entity.Comment;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.CommentService;
import com.pink.freecoffee.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(tags = "评论管理")
public class CommentController {

    final CommentService commentService;

    @ApiOperation("查看当前帖子所有评论")
    @GetMapping("/comments")
    public Result selectAll(@RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum, @RequestParam("postId") String postId) {
        Result result = commentService.selectAll(Integer.parseInt(pageSize), Integer.parseInt(pageNum), Integer.parseInt(postId));
        result.setCode("200");
        result.setMsg("OK");
        return result;
    }

    @ApiOperation("根据id查看一条评论")
    @GetMapping("/comments/{id}")
    public Result selectById(@PathVariable("id") int id) {
        return commentService.selectById(id);
    }

    @ApiOperation("发表新评论")
    @PostMapping("/comments")
    public Result createComment(@RequestBody Comment comment) {
        comment.setUser_id(curId());
        commentService.insertSelective(comment);
        return Result.ok(comment);
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/comments/{id}")
    public Result deleteComment(@PathVariable("id") int id) {
        return commentService.deleteByPrimaryKey(id);
    }

    @ApiOperation("修改评论")
    @PutMapping("/comments/{id}")
    public Result updateComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        comment.setId(id);
        return commentService.updateByPrimaryKey(comment);
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
