package com.deer.ljy.config;

import org.apache.http.HttpStatus;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class CORSFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if(req.getMethod().equals(RequestMethod.OPTIONS.name())){
            res.setHeader("Access-control-Allow-Origin",req.getHeader("Origin"));
            res.setHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
            // 响应首部 Access-Control-Allow-Headers 用于 preflight request （预检请求）中，列出了将会在正式请求的 Access-Control-Expose-Headers 字段中出现的首部信息。修改为请求首部
            res.setHeader("Access-Control-Allow-Headers",req.getHeader("Access-Control-Request-Headers"));
            //给option请求直接返回正常状态
            res.setStatus(HttpStatus.SC_OK);
            return false;
        }
        return super.preHandle(request, response);
    }

}
