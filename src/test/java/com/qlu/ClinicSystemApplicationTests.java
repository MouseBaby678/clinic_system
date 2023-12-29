package com.qlu;

import com.qlu.bean.Doctor;
import com.qlu.bean.Manager;
import com.qlu.bean.Patient;
import com.qlu.mapper.DoctorMapper;
import com.qlu.mapper.ManagerMapper;
import com.qlu.mapper.PatientMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ClinicSystemApplicationTests {
@Autowired
private ManagerMapper managerMapper;
@Autowired
private DoctorMapper doctorMapper;
@Autowired
private PatientMapper patientMapper;
    @Test
    public void test1() {
        Manager manager = managerMapper.selectByUsernameAndPassword("admin","admin");
        System.out.println(manager);
    }



    @Test
    public void test2() {
        Doctor doctor = doctorMapper.selectByUsernameAndPassword("张仲景","123");
        System.out.println(doctor);
    }
    @Test
    public void test3() {
        List<Patient> list = patientMapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void test4() {
    Patient patient = new Patient();
    patient.setPatient_name("杨帆");
    patient.setPatient_age("22");
    patient.setPatient_sex("m");
        System.out.println(patientMapper.add(patient));
    }

}
