package com.qlu.service.impl;

import com.qlu.bean.Doctor;
import com.qlu.mapper.DoctorMapper;
import com.qlu.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> selectAll() {
        return doctorMapper.selectAll();
    }

    @Override
    public int add(Doctor doctor) throws Exception {
        return doctorMapper.add(doctor);
    }

    @Override
    public int del(Integer id) throws Exception {
        Doctor doctor = doctorMapper.selectById(id);
        if(doctor == null) {
            throw new Exception("医生不存在，无法删除~~~");
        }
        return doctorMapper.del(id);
    }

    @Override
    public int update(Doctor doctor) throws Exception {
        //判断被修改的班级是否存在
        if(doctorMapper.selectById(doctor.getDoctor_id()) == null) {
            throw new Exception("被修改的医生不存在，无法修改~~~");
        }


        return doctorMapper.update(doctor);
    }

    @Override
    public Doctor selectById(Integer id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public List<Doctor> selectByName(String name) {
        return doctorMapper.selectByName(name);
    }
}
