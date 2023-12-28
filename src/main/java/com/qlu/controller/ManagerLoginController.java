package com.qlu.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.qlu.bean.Manager;
import com.qlu.bean.RespBean;
import com.qlu.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class ManagerLoginController {
    @Autowired
    private ManagerLoginService managerLoginService;
    @PostMapping("/login")
    public RespBean login(String manager_name, String manager_password, String captchaInput, HttpSession session){
        String captcha = (String) session.getAttribute("captcha");
        if (!captcha.equalsIgnoreCase(captchaInput)){
//           System.out.println(captchaInput);
//           System.out.println(captcha);
            return RespBean.error("验证码错误，请重新输入");
        }
        Manager manager = managerLoginService.login(manager_name,manager_password);
        System.out.println(manager);
        if (manager !=null){
            session.setAttribute("manager",manager);
            return RespBean.ok("登录成功");
        }else {
            return  RespBean.error("用户名或密码错误");
        }


    }

    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response, HttpSession session)throws IOException {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(120,38,4,10);
        session.setAttribute("captcha",captcha.getCode());
        captcha.write(response.getOutputStream());
    }

    @GetMapping("/getInfo")
    public RespBean getInfo(HttpSession session){
        Manager manager= (Manager) session.getAttribute("manager");
        return RespBean.ok("获取信息成功",manager.getManager_name());

    }
    @GetMapping("/logout")
    public  RespBean logout(HttpSession session){
        session.invalidate();;
        return RespBean.ok("注销成功");
    }

}
