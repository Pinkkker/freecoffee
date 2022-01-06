package com.pink.forum.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pink.forum.dao.PostMapper;
import com.pink.forum.dao.UserStarPostRelationMapper;
import com.pink.forum.entity.*;
import com.pink.forum.message.Result;
import com.pink.forum.service.PostService;
import com.pink.forum.service.UTRService;
import com.pink.forum.service.UserService;
import com.pink.forum.shiro.ShiroUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    final UTRService utrService;
    final UserStarPostRelationMapper userStarPostRelationMapper;
    final UserService userService;

    @Override
    public Result selectAll(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PostExample postExample = new PostExample();

        PostExample.Criteria criteria = postExample.createCriteria();
        criteria.andStatusEqualTo(0);

        PageInfo<Post> pageInfo = new PageInfo<>(postMapper.selectByExample(postExample));
        List<Post> posts = pageInfo.getList();
        List<Post> res = posts.stream().peek(post -> post.techMap = getTech(post)).collect(Collectors.toList());
        res = res.stream().peek(post -> post.user = userService.selectById(post.getUser_id())).collect(Collectors.toList());
        Result result = new Result();
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotalPage(pageInfo.getPages());
        result.setTotalNum(pageInfo.getTotal());
        result.setData(res);
        return result;
    }

    @Override
    public Result selectByUId(int userId) {
        PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();

        criteria.andUser_idEqualTo(userId);
        criteria.andStatusEqualTo(0);

        List<Post> posts = postMapper.selectByExample(postExample).getResult();
        List<Post> res = posts.stream().peek(post -> post.techMap = getTech(post)).collect(Collectors.toList());
        res = res.stream().peek(post -> post.user = userService.selectById(post.getUser_id())).collect(Collectors.toList());
        Result result = new Result();
        result.setData(res);
        return result;
    }

    private HashMap<String, Integer> getTech(Post post) {
        HashMap<String, Integer> map = new HashMap<>();
        UserStarPostRelationExample userStarPostRelationExample = new UserStarPostRelationExample();
        userStarPostRelationExample.createCriteria().andPost_idEqualTo(post.getId());
        List<Integer> idList = userStarPostRelationMapper.selectByExample(userStarPostRelationExample).stream().map(UserStarPostRelation::getUser_id)
                .collect(Collectors.toList());
        if (!idList.contains(post.getUser_id())) {
            idList.add(post.getUser_id());
        }
        List<List<TechnologyStack>> lists = idList.stream().map(utrService::selectByUserId).collect(Collectors.toList());
        for (List<TechnologyStack> list : lists) {
            for (TechnologyStack tec : list) {
                map.put(tec.getName(), map.getOrDefault(tec.getName(), 0) + 1);
            }
        }
        return map;
    }

    @Override
    public Result selectById(int id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null || post.getStatus() != 0) {
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

    @Override
    public Result selectByKeyWord(String ketWord) {
        List<Post> posts = postMapper.selectByKeyWord("%" + ketWord + "%");
        System.out.println(posts);
        if (posts == null) {
            Result result = new Result();
            result.setCode("404");
            result.setMsg("没有找到");
            return result;
        }else {
            List<Post> res = posts.stream().peek(post -> post.techMap = getTech(post)).collect(Collectors.toList());
            res = res.stream().peek(post -> post.user = userService.selectById(post.getUser_id())).collect(Collectors.toList());
            return Result.ok(res);
        }
    }

    @Override
    public void star(int postId) {
        Post post = postMapper.selectByPrimaryKey(postId);
        post.setStarred(post.getStarred() + 1);
        postMapper.updateByPrimaryKey(post);
    }

    @Override
    public void unStar(int postId) {
        Post post = postMapper.selectByPrimaryKey(postId);
        post.setStarred(post.getStarred() - 1);
        postMapper.updateByPrimaryKey(post);
    }

    private int curId() {
        return ShiroUtils.getUser().getId();
    }
}
