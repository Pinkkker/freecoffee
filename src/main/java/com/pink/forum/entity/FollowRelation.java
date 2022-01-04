package com.pink.forum.entity;

public class FollowRelation {
    private Integer id;

    private Integer followers_id;

    private Integer following_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFollowers_id() {
        return followers_id;
    }

    public void setFollowers_id(Integer followers_id) {
        this.followers_id = followers_id;
    }

    public Integer getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(Integer following_id) {
        this.following_id = following_id;
    }
}