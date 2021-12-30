package com.pink.forum.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pink.forum.dao.PostMapper;
import com.pink.forum.entity.Post;
import com.pink.forum.entity.PostExample;
import com.pink.forum.message.Result;
import com.pink.forum.service.PostService;
import com.pink.forum.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author DengPengfei
 * @program Gitforum
 * @description 帖子实现类
 * @create 2021-12-30 10:43
 **/

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    final PostMapper postMapper;

    @Override
    public Result selectAll(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PostExample postExample = new PostExample();

        PostExample.Criteria criteria = postExample.createCriteria();
        criteria.andStatusEqualTo(0);

        PageInfo<Post> pageInfo = new PageInfo<>(postMapper.selectByExample(postExample));

        Result result = new Result();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotalPage(pageInfo.getPages());
        result.setTotalNum(pageInfo.getTotal());
        result.setData(pageInfo.getList());

        return result;
    }

    @Override
    public Result selectIdAll(int pageSize, int pageNum, int userId) {
        PageHelper.startPage(pageNum, pageSize);

        PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();

        criteria.andUser_idEqualTo(userId);
        criteria.andStatusEqualTo(0);

        PageInfo<Post> pageInfo = new PageInfo<>(postMapper.selectByExample(postExample));

        Result result = new Result();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotalPage(pageInfo.getPages());
        result.setData(pageInfo.getList());

        return result;
    }

    @Override
    public Result selectById(int id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null) {
            Result result = new Result();
            result.setCode("404");
            result.setMsg("未找到此帖");
            return result;
        }else {
            return Result.ok(post);
        }
    }

    @Override
    public void insertSelective(Post record) {
        postMapper.insertSelective(record);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        Post post = postMapper.selectByPrimaryKey(id);

        if (post == null){
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有此帖");
            return result;
        }
        if (post.getUser_id().equals(curId())){
            post.setStatus(1);
            postMapper.updateByPrimaryKeySelective(post);
            return Result.ok();
        }else {
            Result result = new Result();
            result.setCode("403");
            result.setMsg("这不是你的帖子");
            return result;
        }
    }

    @Override
    public Result updateByPrimaryKey(Post record) {
        if (record.getUser_id().equals(curId())) {
            int i = postMapper.updateByPrimaryKeySelective(record);
            if (i == 0){
                Result result = new Result();
                result.setCode("404");
                result.setMsg("没有此帖");
                return result;
            }
            return Result.ok(record);
        }else {
            Result result = new Result();
            result.setCode("403");
            result.setMsg("这不是你的帖子");
            return result;
        }
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
