package com.pink.forum.service;

import com.pink.forum.message.Result;

import java.util.HashMap;

public interface CommentService {

    Result selectAll(int pageSize, int pageNum, int postId);
}
