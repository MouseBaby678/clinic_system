package com.qlu.interceptor;

import com.qlu.bean.Doctor;
import com.qlu.bean.Manager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    //访问目标资源（想访问的资源）之前的处理
    //true - 方行
    //false - 拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 实现登录校验
         * 1. 已经登录 - 方行 true
         * 2. 未登录 - 拦截 false
         *
         * 如何判断用户是否已经登录？
         *      判断Session中是否有用户信息
         *      如何获取Session
         */
        //获取session
        HttpSession session = request.getSession();
        //获取session中存放的用户信息
        Manager manager = (Manager) session.getAttribute("manager");
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if(manager != null) {
            return true;
        }  else if (doctor != null) {
            return true;
        } else {
            //重定向到登录页
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
    }
}

