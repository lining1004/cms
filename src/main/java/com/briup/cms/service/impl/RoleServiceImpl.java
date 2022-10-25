package com.briup.cms.service.impl;

import com.briup.cms.bean.Role;
import com.briup.cms.dao.RoleDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层实现类：是由项目经理提供的业务设计
 * @Author lining
 * @Date 2022/10/25
 */
@Service//创建service层bean对象，调用类的方法
public class RoleServiceImpl implements IRoleService {
    //使用jpa实现dao层的功能
    @Autowired
    private RoleDao dao;

    public Page<Role> findAll(Integer pageNum, Integer pageSize) throws ServiceException {
        //补充：使用dao对象调用方法实现功能

        return null;
    }

    public void saveOrUpdateRole(Role role) throws ServiceException {

    }

    public void deleteRoleInBatch(List<Integer> ids) throws ServiceException {

    }
}
