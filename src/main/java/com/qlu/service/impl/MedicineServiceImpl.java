package com.qlu.service.impl;

import com.qlu.bean.Medicine;
import com.qlu.mapper.MedicineMapper;
import com.qlu.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;
    @Override
    public int add(Medicine m) throws Exception {
        if(medicineMapper.selectByName(m.getMedicine_name())!= null){
            throw new Exception("新添加的药品名称和已经存在的药品名称重复，无法添加");
        }
        return medicineMapper.add(m);
    }

    @Override
    public int del(Integer medicine_id) throws Exception {
        Medicine m = medicineMapper.selectById(medicine_id);
        if(m == null){
            throw new Exception("药品不存在，无法删除~~~");
        }
        return medicineMapper.del(medicine_id);
    }

    @Override
    public int update(Medicine m) throws Exception {
        if(medicineMapper.selectById(m.getMedicine_id()) == null){
            throw new Exception("被修改的药品不存在，无法修改~~~");
        }
        Medicine m1 = medicineMapper.selectByName(m.getMedicine_name());
        if (m1 != null & !m1.getMedicine_id().equals(m.getMedicine_id())){
            throw new Exception("修改之后的药品名称和其他药品的名称相同，不允许修改");
        }
        return medicineMapper.update(m);
    }

    @Override
    public List<Medicine> selectAll() {
        return medicineMapper.selectAll();
    }

    @Override
    public Medicine selectById(Integer medicine_id) {
        return medicineMapper.selectById(medicine_id);
    }

    @Override
    public Medicine selectByName(String medicine_name) {
        return medicineMapper.selectByName(medicine_name);
    }
}
