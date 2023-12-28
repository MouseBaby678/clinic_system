package com.qlu.service;

import com.qlu.bean.Manager;

public interface ManagerLoginService {
    Manager login(String manager_name,String manager_password);
}
