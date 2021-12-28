package com.pink.forum.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private String code;
    private String msg;
    private Object data;

    public static Result ok() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("OK");
        result.setData("");
        return result;
    }

    public static Result bad() {
        Result result = new Result();
        result.setCode("400");
        result.setMsg("Bad Request");
        result.setData("");
        return result;
    }
}
