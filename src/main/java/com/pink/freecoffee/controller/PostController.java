package com.pink.freecoffee.controller;

import com.pink.freecoffee.dao.UserStarPostRelationMapper;
import com.pink.freecoffee.entity.Post;
import com.pink.freecoffee.entity.UserStarPostRelation;
import com.pink.freecoffee.entity.UserStarPostRelationExample;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.PostService;
import com.pink.freecoffee.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    final UserStarPostRelationMapper userStarPostRelationMapper;

    /**
     * @description 创建帖子
     */
    @ApiOperation("创建新帖")
    @PostMapping("/posts")
    public Result setPost(@RequestBody Post post) {
        post.setUser_id(ShiroUtils.getUser().getId());
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

    @ApiOperation("查看帖子")
    @GetMapping("/posts")
    public Result allPost(@RequestParam(value = "pageSize", required = false) String pageSize, @RequestParam(value = "pageNum", required = false) String pageNum,
                          @RequestParam(value = "userId", required = false) String userId){
        Result result;
        if (userId == null) {
            result = postService.selectAll(Integer.parseInt(pageSize), Integer.parseInt(pageNum));
        } else {
            result = postService.selectByUId(Integer.parseInt(userId));
        }
        result.setCode("200");
        result.setMsg("OK");
        return result;
    }
    @ApiOperation("查看指定帖子")
    @GetMapping("posts/{id}")
    public Result selectPostById(@PathVariable("id") int id) {
        return postService.selectById(id);
    }
    @ApiOperation("搜索帖子")
    @GetMapping("/search")
    public Result searchPost(@RequestParam(value = "keyWord") String keyWord) {
        return postService.selectByKeyWord(keyWord);
    }
    @ApiOperation("点赞")
    @PostMapping("/star/{id}")
    public Result star(@PathVariable("id") int postId, @RequestBody int userId) {
        UserStarPostRelation userStarPostRelation = new UserStarPostRelation();
        userStarPostRelation.setPost_id(postId);
        userStarPostRelation.setUser_id(userId);
        int res = userStarPostRelationMapper.insertSelective(userStarPostRelation);
        if (res == 0) {
            return Result.bad("点赞失败");
        } else {
            postService.star(postId);
            return Result.ok();
        }
    }

    @ApiOperation("取消点赞")
    @DeleteMapping("/star/{id}")
    public Result unStar(@PathVariable("id") int postId, @RequestBody int userId) {
        UserStarPostRelationExample userStarPostRelationExample = new UserStarPostRelationExample();
        UserStarPostRelationExample.Criteria criteria = userStarPostRelationExample.createCriteria();
        criteria.andPost_idEqualTo(postId);
        criteria.andUser_idEqualTo(userId);
        int res = userStarPostRelationMapper.deleteByExample(userStarPostRelationExample);
        if (res == 0) {
            return Result.bad("取消点赞失败");
        } else {
            postService.unStar(postId);
            return Result.ok();
        }
    }
}
