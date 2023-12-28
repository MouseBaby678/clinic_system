package com.qlu;

import com.qlu.bean.Doctor;
import com.qlu.bean.Manager;
import com.qlu.mapper.DoctorMapper;
import com.qlu.mapper.ManagerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicSystemApplicationTests {
@Autowired
private ManagerMapper managerMapper;
@Autowired
    private DoctorMapper doctorMapper;
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

}
