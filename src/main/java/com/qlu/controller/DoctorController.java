package com.qlu.controller;

import com.qlu.bean.Doctor;
import com.qlu.bean.RespBean;
import com.qlu.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/doctor/{id}")
    public RespBean selectById(@PathVariable("id") Integer id) {
        Doctor doctor = doctorService.selectById(id);
        return RespBean.ok("查询成功", doctor);
    }

    @GetMapping("/doctor")
    public RespBean selectAll() {
        List<Doctor> doctorList = doctorService.selectAll();
        return RespBean.ok("查询成功", doctorList);
    }
}
