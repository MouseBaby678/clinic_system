package com.qlu.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.qlu.bean.Doctor;
import com.qlu.bean.RespBean;
import com.qlu.service.DoctorLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class DoctorLoginController {
    @Autowired
    private DoctorLoginService doctorLoginService;
    @PostMapping("/doclogin")
    public RespBean login(String doctor_name, String doctor_password, String captchaInput, HttpSession session){
        String captcha = (String) session.getAttribute("captcha");
        if (!captcha.equalsIgnoreCase(captchaInput)){

            return RespBean.error("验证码错误，请重新输入");
        }
        Doctor doctor = doctorLoginService.login(doctor_name,doctor_password);
        System.out.println(doctor);
        if (doctor !=null){
            session.setAttribute("doctor",doctor);
            return RespBean.ok("登录成功");
        }else {
            return  RespBean.error("用户名或密码错误");
        }


    }

    @GetMapping("/doccaptcha")
    public void captcha(HttpServletResponse response, HttpSession session)throws IOException {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(120,38,4,10);
        session.setAttribute("captcha",captcha.getCode());
        captcha.write(response.getOutputStream());
    }

    @GetMapping("/docgetInfo")
    public RespBean getInfo(HttpSession session){
        Doctor doctor= (Doctor) session.getAttribute("doctor");
        return RespBean.ok("获取信息成功",doctor.getDoctor_name());

    }
    @GetMapping("/doclogout")
    public  RespBean logout(HttpSession session){
        session.invalidate();;
        return RespBean.ok("注销成功");
    }



}
