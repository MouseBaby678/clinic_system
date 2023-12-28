package com.qlu.service.impl;

import com.qlu.bean.Doctor;
import com.qlu.mapper.DoctorMapper;
import com.qlu.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> selectAll() {
        return doctorMapper.selectAll();
    }

    @Override
    public Doctor selectById(Integer id) {
        return doctorMapper.selectById(id);
    }
}
