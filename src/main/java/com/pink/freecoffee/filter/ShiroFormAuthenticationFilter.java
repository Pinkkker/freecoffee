package com.pink.freecoffee.filter;

import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pink.freecoffee.message.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 重新onAccessDenied 实现shiro对未认证的页直接返回json 而不是重定向
 * @author sirm
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(Result.bad("未登录"));
        out.write(json); // 返回自己的json
        out.flush();
        out.close();
        return false;
    }
}