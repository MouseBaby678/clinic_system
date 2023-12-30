package com.qlu.service.impl;

import com.qlu.bean.Patient;
import com.qlu.mapper.PatientMapper;
import com.qlu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;


    @Override
    public int add(Patient p) throws Exception {

        return patientMapper.add(p);
    }

    @Override
    public int del(Integer patient_id) throws Exception {
        Patient p = patientMapper.selectById(patient_id);
        if (p == null){
            throw new Exception("病人不存在无法删除");
        }
        //TODO 判断病例
        return patientMapper.del(patient_id);
    }

    @Override
    public int update(Patient p) throws Exception {
        if (patientMapper.selectById(p.getPatient_id()) == null){
            throw new Exception("要修改的病人不存在");
        }

        return patientMapper.update(p);
    }

    @Override
    public List<Patient> selectAll() {

        return patientMapper.selectAll();
    }

    @Override
    public Patient selectById(Integer patient_id) {
        return patientMapper.selectById(patient_id);
    }

    @Override
    public List<Patient> selectByPname(String patient_name) {
        return patientMapper.selectByPname(patient_name);
    }


}
