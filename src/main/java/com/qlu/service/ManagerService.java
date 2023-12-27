package com.qlu.service;

import com.qlu.bean.Manager;

public interface ManagerService {
    Manager login(String manager_name,String manager_password);
}
