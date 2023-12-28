package com.qlu.service;

import com.qlu.bean.Medicine;

import java.util.List;

public interface MedicineService {
    int add(Medicine m) throws Exception;
    //根据ID删除
    int del(Integer medicine_id) throws Exception;
    //根据ID修改
    int update(Medicine m) throws Exception;
    //查询所有
    List<Medicine> selectAll();
    //根据ID查询
    Medicine selectById(Integer medicine_id);
    //根据名称查询
    Medicine selectByName(String medicine_name);
}
