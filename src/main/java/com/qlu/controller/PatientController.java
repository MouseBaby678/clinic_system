package com.qlu.controller;

import com.qlu.bean.Doctor;
import com.qlu.bean.Patient;
import com.qlu.bean.RespBean;
import com.qlu.mapper.PatientMapper;
import com.qlu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/pat")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping
    public RespBean add(Patient p)throws Exception{
        patientService.add(p);
        return RespBean.ok("添加成功");

    }
    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable("id") Integer patient_id)throws Exception{
        patientService.del(patient_id);
        return RespBean.ok("删除成功");
    }
    @PutMapping
    public RespBean update(Patient p)throws Exception{
        patientService.update(p);
        return RespBean.ok("更新成功");


    }
    @GetMapping
    public RespBean selectAll(){
        List<Patient> patientList = patientService.selectAll();
        System.out.println(patientList);
        return RespBean.ok("全体病人查询成功",patientList);
    }

    @GetMapping("/{id}")
    public RespBean selectById(@PathVariable("id")Integer patient_id){
       Patient p = patientService.selectById(patient_id);
        return RespBean.ok("chaxunchenggong",p);
    }
    @GetMapping("/name/{name}")
    public RespBean selectByPname(@PathVariable("name") String name) {
        List<Patient> p = patientService.selectByPname(name);
        return RespBean.ok("查询成功", p);
    }

}
