package com.pink.forum.controller;

import com.pink.forum.entity.Response;
import com.pink.forum.message.Result;
import com.pink.forum.service.ResponseService;
import com.pink.forum.shiro.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author DengPengfei
 * @program Gitforum
 * @description 评论的回复接口
 * @create 2021-12-30 20:17
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "回复管理")
public class ResponseController {
    final ResponseService responseService;

    @ApiOperation("查看回复")
    @GetMapping("/responses")
    public Result selectById(@RequestParam("commentId") String commentId) {
        Result result = responseService.selectById(Integer.parseInt(commentId));
        result.setCode("200");
        result.setMsg("OK");

        return result;
    }

    @ApiOperation("发布新回复")
    @PutMapping("/responses")
    public Result createResponse(@RequestBody Response response) {
        response.setUser_id(curId());
        responseService.insertSelective(response);

        return Result.ok(response);
    }

    @ApiOperation("删除回复")
    @DeleteMapping("/responses/{id}")
    public Result deleteResponse(@PathVariable("id") int id) {
        return responseService.deleteByPrimaryKey(id);
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
