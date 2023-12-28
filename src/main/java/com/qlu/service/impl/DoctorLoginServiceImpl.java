package com.qlu.service.impl;

import com.qlu.bean.Doctor;
import com.qlu.mapper.DoctorMapper;
import com.qlu.service.DoctorLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorLoginServiceImpl implements DoctorLoginService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public Doctor login(String doctor_name, String doctor_password) {
        return doctorMapper.selectByUsernameAndPassword(doctor_name,doctor_password);
    }

}
