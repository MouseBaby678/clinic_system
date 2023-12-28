package com.qlu.service;

import com.qlu.bean.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DoctorService {
    Doctor selectById(Integer id);

    List<Doctor> selectAll();
}
