package com.qlu.mapper;

import com.qlu.bean.Patient;

import java.util.List;

public interface PatientMapper {
    int add(Patient p);
    int del(Integer id);
    int update(Patient p);
    List<Patient> selectAll();
    Patient selectById(Integer patient_id);

    Patient selectByPname(String patient_name);
}
