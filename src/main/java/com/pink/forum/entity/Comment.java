package com.pink.forum.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel("评论")
public class Comment {
    private Integer id;

    private String contents;

    private Date time;

    @ApiModelProperty(value = "状态 0表示没被删除 1表示已被删除")
    private Integer status;

    private Integer approve;

    private Integer responseNumber;

    private Integer post_id;

    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    public Integer getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(Integer responseNumber) {
        this.responseNumber = responseNumber;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}