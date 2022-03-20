package com.pink.freecoffee.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pink.freecoffee.message.Result;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 * 重新onAccessDenied 实现shiro对未授权的页直接返回json 而不是重定向
 * 
 * @author sirm
 */
public class ShiroRolesAuthorizationFilter extends RolesAuthorizationFilter {
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		Subject subject = getSubject(request, response);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		// 没有认证,先返回未认证的json
		if (subject.getPrincipal() == null) {
			ow.writeValueAsString(Result.bad("未登录"));
		} else {
			// 已认证但没有角色，返回为授权的json
			ow.writeValueAsString(Result.bad("没有此角色"));
		}
		out.write(json);
		out.flush();
		out.close();
		return false;
	}

}
