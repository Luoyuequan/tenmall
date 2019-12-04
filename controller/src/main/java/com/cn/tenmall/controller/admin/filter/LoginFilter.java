/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginFilter
 * Author:   Administrator
 * Date:     2019/11/21 17:22
 * Description: 是否登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.admin.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈是否登录〉
 *
 * @author Administrator
 * @create 2019/11/21
 * @since 1.0.0
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("CustomFilter doFilter before.");
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;
        response.setContentType("text/html");
//        if(req.getSession().getAttribute("ADMIN")==null){
//               resp.sendRedirect("/");
//        }
        filterChain.doFilter(request, response);
//        System.out.println("CustomFilter doFilter after.");
    }

    @Override
    public void destroy() {

//        System.out.println("destroy.");
    }
}
