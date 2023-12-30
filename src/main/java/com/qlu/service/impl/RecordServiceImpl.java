package com.qlu.service.impl;

import com.qlu.bean.Record;
import com.qlu.mapper.RecordMapper;
import com.qlu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public int add(Record record) throws Exception {


        return recordMapper.add(record);
    }

    @Override
    public int del(Integer record_id) throws Exception {
        if (recordMapper.selectById(record_id) == null) {
            throw new Exception("该病例不存在，无法删除");
        }

        return recordMapper.del(record_id);

    }

    @Override
    public int update(Record record) throws Exception {
        return recordMapper.update(record);
    }

    @Override
    public List<Record> selectAll() {
        return recordMapper.selectAll();
    }

    @Override
    public Record selectById(Integer record_id) {
        return recordMapper.selectById(record_id);
    }



}
