package com.qlu;

import com.qlu.bean.Manager;
import com.qlu.mapper.ManagerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicSystemApplicationTests {
@Autowired
private ManagerMapper managerMapper;
    @Test
    public void test1() {
        Manager manager = managerMapper.selectByUsernameAndPassword("admin","admin");
        System.out.println(manager);
    }

}
