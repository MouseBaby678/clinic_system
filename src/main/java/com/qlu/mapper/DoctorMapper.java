package com.qlu.mapper;

import com.qlu.bean.Doctor;

import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    Doctor selectByUsernameAndPassword(@Param("doctor_name") String docotor_name, @Param("doctor_password") String doctor_password);
}
