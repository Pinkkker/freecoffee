package com.pink.forum.entity;

public class UserTecRelation {
    private Integer id;

    private Integer user_id;

    private Integer tec_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTec_id() {
        return tec_id;
    }

    public void setTec_id(Integer tec_id) {
        this.tec_id = tec_id;
    }
}