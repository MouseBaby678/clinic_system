package com.qlu.controller;

import com.qlu.bean.Medicine;
import com.qlu.bean.RespBean;
import com.qlu.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/mdc") //Restful
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    //分页
    //@GetMapping
    //public RespBean selectByPage(Integer pageNum, Integer pageSize) {
    //    //1. 设置分页信息（页码，每页条数）
    //    PageHelper.startPage(pageNum, pageSize);
    //    //2. 查询
    //    List<Medicine> medicineList = medicineService.selectAll();
    //    //3. 创建保存分页信息的对象
    //    PageInfo<Medicine> pageInfo = new PageInfo<>(medicineList);
    //    return RespBean.ok("查询成功", pageInfo);
    //}
//添加
    @PostMapping
    public RespBean add(Medicine m) throws Exception {
        medicineService.add(m);
        return RespBean.ok("添加成功");
    }
    //根据ID删除 @PathVariable作用：将路径的参数映射到方法的参数
    @DeleteMapping("/{medicine_id}")
    public RespBean del(@PathVariable("medicine_id") Integer medicine_id) throws Exception {
        medicineService.del(medicine_id);
        return RespBean.ok("删除成功");
    }
    //根据ID修改
    @PutMapping
    public RespBean update(Medicine m) throws Exception {
        medicineService.update(m);
        return RespBean.ok("修改成功");
    }
    //查询所有
    @GetMapping
    public RespBean selectAll() {
        List<Medicine> medicineList = medicineService.selectAll();

        return RespBean.ok("查询成功", medicineList);
    }
    //根据ID查询
    @GetMapping("/{medicine_id}")
    public RespBean selectById(@PathVariable("medicine_id") Integer medicine_id) {
        Medicine m = medicineService.selectById(medicine_id);

        return RespBean.ok("查询成功", m);
    }

}
