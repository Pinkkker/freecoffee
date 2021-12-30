package com.pink.forum.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pink.forum.dao.CommentMapper;
import com.pink.forum.entity.Comment;
import com.pink.forum.entity.CommentExample;
import com.pink.forum.message.Result;
import com.pink.forum.service.CommentService;
import lombok.RequiredArgsConstructor;
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
        PageInfo<Comment> pageInfo = new PageInfo<>(commentMapper.selectByExample(commentExample));
        Result result = new Result();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotalPage(pageInfo.getPages());
        result.setData(pageInfo.getList());
        return result;
    }
}
