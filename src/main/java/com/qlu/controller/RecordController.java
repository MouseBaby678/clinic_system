package com.qlu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qlu.bean.Record;
import com.qlu.bean.RespBean;
import com.qlu.mapper.RecordMapper;
import com.qlu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor/rec")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @GetMapping
    public RespBean selectByPage(Integer pageNum, Integer pageSize) {
        //1. 设置分页信息（页码，每页条数）
        PageHelper.startPage(pageNum, pageSize);
        //2. 查询
        List<Record> recordtList = recordService.selectAll();
        //3. 创建保存分页信息的对象
        PageInfo<Record> pageInfo = new PageInfo<>(recordtList);
        return RespBean.ok("查询成功", pageInfo);
    }
    @GetMapping("/{id}")
    public RespBean selectById(@PathVariable("id") Integer record_id) {
        Record record = recordService.selectById(record_id);

        return RespBean.ok("查询成功", record);
    }
    @PostMapping
    public RespBean add(Record record) throws Exception {
        recordService.add(record);

        return RespBean.ok("添加成功");
    }

    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable("id") Integer record_id) throws Exception {
        recordService.del(record_id);

        return RespBean.ok("删除成功");
    }

    @PutMapping
    public RespBean update(Record record) throws Exception {
       recordService.update(record);

        return RespBean.ok("修改成功");
    }
//    @GetMapping("/{patient_id}")
//    public RespBean selectByPid(@PathVariable("patient_id") Integer patient_id) {
//        List<Map<String, Object>> mapList = recordService.selectByPid(patient_id);
//
//        return RespBean.ok("查询成功", mapList);
//    }
}
