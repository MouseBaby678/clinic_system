package com.qlu.mapper;

import com.qlu.bean.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorMapper {
    Doctor selectByUsernameAndPassword(@Param("doctor_name") String doctor_name, @Param("doctor_password") String doctor_password);
    Doctor selectById(@Param("doctor_id") Integer doctor_id);

    List<Doctor> selectAll();

    int add(Doctor doctor);

    int del(@Param("doctor_id") Integer doctor_id);

    int update(Doctor doctor);

    Doctor selectByName(@Param("doctor_name") String doctor_name);
}
