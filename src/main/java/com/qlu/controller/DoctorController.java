package com.qlu.controller;

import com.qlu.bean.Doctor;
import com.qlu.bean.RespBean;
import com.qlu.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manger/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/{id}")
    public RespBean selectById(@PathVariable("id") Integer id) {
        Doctor doctor = doctorService.selectById(id);
        return RespBean.ok("查询成功", doctor);
    }

    @GetMapping()
    public RespBean selectAll() {
        List<Doctor> doctorList = doctorService.selectAll();
        return RespBean.ok("查询成功", doctorList);
    }

    //添加
    @PostMapping
    public RespBean add(Doctor doctor) throws Exception {
        doctorService.add(doctor);
        return RespBean.ok("添加成功");
    }
    //根据ID删除 @PathVariable作用：将路径的参数映射到方法的参数
    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable("id") Integer id) throws Exception {
        doctorService.del(id);
        return RespBean.ok("删除成功");
    }

    //根据ID修改
    @PutMapping
    public RespBean update(Doctor doctor) throws Exception {
        doctorService.update(doctor);

        return RespBean.ok("修改成功");
    }
}
