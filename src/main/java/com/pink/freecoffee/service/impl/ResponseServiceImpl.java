package com.pink.freecoffee.service.impl;

import com.pink.freecoffee.dao.CommentMapper;
import com.pink.freecoffee.dao.ResponseMapper;
import com.pink.freecoffee.entity.Comment;
import com.pink.freecoffee.entity.Response;
import com.pink.freecoffee.message.Result;
import com.pink.freecoffee.service.ResponseService;
import com.pink.freecoffee.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author DengPengfei
 * @program Gitforum
 * @description 回复实现类
 * @create 2021-12-30 20:18
 **/

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {
    final ResponseMapper responseMapper;
    final CommentMapper commentMapper;

    @Override
    public Result selectById(int id) {
        Response response = responseMapper.selectByPrimaryKey(id);

        if (response == null){
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有这条回复");
            return result;
        }else{
            return Result.ok(response);
        }
    }

    @Override
    public void insertSelective(Response record) {
         Comment comment = commentMapper.selectByPrimaryKey(record.getCommit_id());
         comment.setResponseNumber(comment.getResponseNumber() + 1);
         commentMapper.updateByPrimaryKeySelective(comment);
         responseMapper.insertSelective(record);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        Response response = responseMapper.selectByPrimaryKey(id);

        if (response == null) {
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有这条回复");
            return result;
        }
        if (response.getUser_id().equals(curId())) {
            response.setStatus(1);
            responseMapper.updateByPrimaryKeySelective(response);

            Comment comment = commentMapper.selectByPrimaryKey(response.getCommit_id());
            comment.setResponseNumber(comment.getResponseNumber() - 1);
            commentMapper.updateByPrimaryKeySelective(comment);
            return Result.ok();
        } else {
            Result result = new Result();
            result.setCode("403");
            result.setMsg("不是你的回复");
            return result;
        }
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
