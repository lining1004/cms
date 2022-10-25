package com.briup.cms.web.controller;

import com.briup.cms.bean.Role;
import com.briup.cms.service.IRoleService;
import com.briup.cms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限管理模块：基于RESTful风格设计的接口
 * 参考我们提供的设计文档： 接口文档
 * https://console-docs.apipost.cn/preview/23048934a4b367f3/bfb55bba8fbe497d
 *
 * 为了测试当前的接口是否能实现文档设计的功接口要求，利用swagger进行操作
 * 单独swagger
 * swagger+jwt
 *
 * @Author lining
 * @Date 2022/10/25
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController {
    @Autowired
    private IRoleService service;
    //新增或修改
    @PostMapping
    public Result addOrUpdateRole(@RequestBody Role role){
        //调用service层方式实现功能..
        service.saveOrUpdateRole(role);
        return Result.success();
    }
    //分页查询
    @GetMapping
    public Result findByPage(Integer pageNum,Integer pageSize){
        //补充代码
        return null;
    }
    //批量删除
    //根据接口文档定义的内容，创建对应的方法
}
