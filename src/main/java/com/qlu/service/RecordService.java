package com.qlu.service;

import com.qlu.bean.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    int add(Record record) throws Exception;
    //删除
    int del(Integer id) throws Exception;
    //修改
    int update(Record record) throws Exception;
    //查询所有
    List<Record> selectAll();
    //根据ID查询
    Record selectById(Integer id);

}
