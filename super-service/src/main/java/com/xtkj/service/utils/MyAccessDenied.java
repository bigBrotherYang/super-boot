package com.xtkj.service.utils;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class MyAccessDenied implements AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
//设置响应状态码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //设置响应数据格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //输入响应内容
        PrintWriter writer = httpServletResponse.getWriter();
        String json="{\"status\":\"403\",\"msg\":\"拒绝访问\"}";
        writer.write(json);
        writer.flush();
    }


}
