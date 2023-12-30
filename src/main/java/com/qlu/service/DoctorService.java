package com.qlu.service;

import com.qlu.bean.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DoctorService {
    Doctor selectById(Integer id);
    List<Doctor> selectByName(String name);

    List<Doctor> selectAll();

    int add(Doctor doctor) throws Exception;
    //根据ID删除
    int del(Integer id) throws Exception;
    //根据ID修改
    int update(Doctor doctor) throws Exception;
}
