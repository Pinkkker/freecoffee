package com.pink.forum.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private int pageNum;
    private int pageSize;
    private int totalPage;
    private String code;
    private String msg;
    private Object data;

    public static Result ok() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("OK");
        return result;
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("OK");
        result.setData(data);
        return result;
    }

    public static Result bad() {
        Result result = new Result();
        result.setCode("400");
        result.setMsg("Bad Request");
        return result;
    }
    public static Result bad(String msg) {
        Result result = new Result();
        result.setCode("400");
        result.setMsg(msg);
        return result;
    }
}
