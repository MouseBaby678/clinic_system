package com.qlu.mapper;

import com.qlu.bean.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    Manager selectByUsernameAndPassword(@Param("manager_name") String manager_name,@Param("manager_password") String manager_password);
}
