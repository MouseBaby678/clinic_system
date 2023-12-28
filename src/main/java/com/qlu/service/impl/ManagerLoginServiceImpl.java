package com.qlu.service.impl;

import com.qlu.bean.Manager;
import com.qlu.mapper.ManagerMapper;
import com.qlu.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager login(String manager_name, String manager_password) {
        return managerMapper.selectByUsernameAndPassword(manager_name,manager_password);
    }
}
