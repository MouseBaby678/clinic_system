package com.qlu.mapper;

import com.qlu.bean.Doctor;
import com.qlu.bean.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {
    int add(Medicine m);
    //根据ID删除
    int del(Integer medicine_id);
    //根据ID修改
    int update(Medicine m);
    //查询所有班级
    List<Medicine> selectAll();
    //根据ID查询
    Medicine selectById(Integer medicine_id);
    //根据班级名称查询
    Medicine selectByName(String medicine_name);

}
