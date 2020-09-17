package com.xtkj.service.utils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class JsonAuthenticationEntryPoint implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        //设置响应状态码
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //设置响应数据格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //输入响应内容
        PrintWriter writer = httpServletResponse.getWriter();
        String json="{\"status\":\"401\",\"msg\":\"未登录或者登录失效\"}";
        writer.write(json);
        writer.flush();
    }
}
