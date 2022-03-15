package com.pink.freecoffee.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户请求")
public class Request {
    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    private String username;
    @ApiModelProperty(value = "用户密码", example = "123", required = true)
    private String password;
    @ApiModelProperty(value = "昵称", example = "张三", required = true)
    private String nickName;
}
