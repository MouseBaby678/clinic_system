package com.qlu.mapper;

import com.qlu.bean.Record;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    int add(Record record);

    int del(Integer record_id);

    int update(Record record);

    List<Record> selectAll();

    Record selectById(Integer record_id);



    List<Map<String,Object>>selectByPid(Integer patient_id);



}
