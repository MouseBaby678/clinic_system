package com.qlu.service;

import com.qlu.bean.Patient;

import java.util.List;

public interface PatientService {
    int add(Patient p) throws Exception;
    int del(Integer patient_id) throws Exception;
    int update(Patient p) throws Exception;
    List<Patient> selectAll();
    Patient selectById(Integer patient_id);
}
