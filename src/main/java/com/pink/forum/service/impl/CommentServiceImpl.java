package com.pink.forum.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pink.forum.dao.CommentMapper;
import com.pink.forum.entity.Comment;
import com.pink.forum.entity.CommentExample;
import com.pink.forum.entity.User;
import com.pink.forum.message.Result;
import com.pink.forum.service.CommentService;
import com.pink.forum.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    final CommentMapper commentMapper;


    @Override
    public Result selectAll(int pageSize, int pageNum, int postId) {
        PageHelper.startPage(pageNum, pageSize);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andPost_idEqualTo(postId);
        criteria.andStatusEqualTo(0);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentMapper.selectByExample(commentExample));
        Result result = new Result();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotalPage(pageInfo.getPages());
        result.setData(pageInfo.getList());
        return result;
    }

    @Override
    public Result selectById(int id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有这条评论");
            return result;
        } else {
            return Result.ok(comment);
        }
    }

    @Override
    public void insertSelective(Comment record) {
        commentMapper.insertSelective(record);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有这条评论");
            return result;
        }
        if (comment.getUser_id().equals(curId())) {
            comment.setStatus(1);
            commentMapper.updateByPrimaryKeySelective(comment);
            return Result.ok();
        } else {
            Result result = new Result();
            result.setCode("403");
            result.setMsg("不是你的评论");
            return result;
        }
    }

    @Override
    public Result updateByPrimaryKey(Comment record) {
        if (record.getUser_id().equals(curId())) {
            int i = commentMapper.updateByPrimaryKeySelective(record);
            if (i == 0) {
                Result result = new Result();
                result.setCode("404");
                result.setMsg("没有这条评论");
                return result;
            }
            return Result.ok(record);
        } else {
            Result result = new Result();
            result.setCode("403");
            result.setMsg("不是你的评论");
            return result;
        }
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
