package com.pink.freecoffee.controller;

import com.pink.freecoffee.entity.TechnologyStack;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.TechService;
import com.pink.freecoffee.service.UTRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "技术栈管理")
public class TechController {

    final TechService techService;
    final UTRService utrService;

    @ApiOperation("查看所有技术栈")
    @GetMapping("/techs")
    public Result selectAll() {
        List<TechnologyStack> technologyStacks = techService.selectAll();
        return Result.ok(technologyStacks);
    }

    @ApiOperation("查看指定用户的技术栈")
    @GetMapping("/techs/{id}")
    public Result selectByUserId(@PathVariable("id") int id) {
        List<TechnologyStack> technologyStacks = utrService.selectByUserId(id);
        return Result.ok(technologyStacks);
    }

    @ApiOperation("添加一个技术栈")
    @PostMapping("/techs")
    public Result createTec(@RequestBody TechnologyStack technologyStack) {
        int res = techService.createTec(technologyStack);
        if (res == 1) {
            return Result.ok(technologyStack);
        } else {
            return Result.bad("添加失败");
        }
    }

    @ApiOperation("删除一个技术栈")
    @DeleteMapping("/techs")
    public Result deleteTec(@RequestBody TechnologyStack technologyStack) {
        int res = techService.deleteTec(technologyStack.getId());
        if (res == 1) {
            return Result.ok(technologyStack);
        } else {
            return Result.bad("删除失败");
        }
    }

    @ApiOperation("修改一个技术栈")
    @PutMapping("/techs")
    public Result updateTec(@RequestBody TechnologyStack technologyStack) {
        int res = techService.updateTec(technologyStack);
        if (res == 1) {
            return Result.ok(technologyStack);
        } else {
            return Result.bad("修改失败");
        }
    }

    @ApiOperation("新建用户的一个技术栈")
    @PostMapping("/techs/{id}")
    public Result createUTR(@PathVariable("id") int userId, @RequestBody int tecId) {
        int res = utrService.createUTR(userId, tecId);
        if (res == 1) {
            return Result.ok();
        } else {
            return Result.bad("添加失败");
        }
    }

    @ApiOperation("删除用户的一个技术栈")
    @DeleteMapping("/techs/{id}")
    public Result DeleteUTR(@PathVariable("id") int userId, @RequestBody int tecId) {
        int res = utrService.deleteUTR(userId, tecId);
        if (res == 1) {
            return Result.ok();
        } else {
            return Result.bad("删除失败");
        }
    }
}
