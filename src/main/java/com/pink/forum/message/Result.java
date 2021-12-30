package com.pink.forum.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@ApiModel("响应结果")
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    @ApiModelProperty("当前页数")
    private int pageNum;
    @ApiModelProperty("每一页条数")
    private int pageSize;
    @ApiModelProperty("总页数")
    private int totalPage;
    @ApiModelProperty("响应码 参考http状态码")
    private String code;
    @ApiModelProperty("响应消息")
    private String msg;
    @ApiModelProperty("响应数据")
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
