package com.pink.forum.controller;

import com.pink.forum.dao.PostMapper;
import com.pink.forum.entity.Post;
import com.pink.forum.entity.User;
import com.pink.forum.message.Result;
import com.pink.forum.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program Gitforum
 * @description 帖子接口
 * @author DengPengfei
 * @create 2021-12-30 09:23
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "铁汁管理")
public class PostController {
    final PostService postService;

    /**
     * @description 创建帖子
     */
    @ApiOperation("创建新帖")
    @PostMapping("/posts")
    public Result setPost(@RequestBody Map<String, String> data) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        Post post = new Post();
        post.setUser_id(user.getId());
        post.setTitle(data.get("title"));
        post.setContents(data.get("contents"));

        postService.insertSelective(post);
        return Result.ok(post);
    }

    @ApiOperation("删除帖子")
    @DeleteMapping("/posts/{id}")
    public Result deletePost(@PathVariable("id") int id){
        return postService.deleteByPrimaryKey(id);
    }

    @ApiOperation("修改帖子")
    @PutMapping("/posts/{id}")
    public Result updatePost(@PathVariable("id") int id, @RequestBody Post post){
        post.setId(id);
        return postService.updateByPrimaryKey(post);
    }

    @ApiOperation("查看所有帖子")
    @GetMapping("/posts")
    public Result allPost(@RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum){
        Result result = postService.selectAll(Integer.parseInt(pageSize), Integer.parseInt(pageNum));

        result.setCode("200");
        result.setMsg("OK");
        return result;
    }

    @ApiOperation("查看指定用户的帖子")
    @GetMapping("/posts/{id}")
    public Result postAll(@RequestParam("pageSize") String pageSize, @RequestParam("pageNum") String pageNum, @RequestParam("postId") String postId){
        Result result = postService.selectIdAll(Integer.parseInt(pageSize), Integer.parseInt(pageNum), Integer.parseInt(postId));

        result.setCode("200");
        result.setMsg("OK");
        return result;
    }
}
