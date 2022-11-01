package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.exception.ServiceException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层对应的实现类
 * @Author lining
 * @Date 2022/10/31
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired  //获取ioc容器中bean对象
    private CategoryDao dao;//springboot自动创建对象

    public Page<Category> findAllSortbyNo(Integer pageNum, Integer pageSize) throws ServiceException {
       // return dao.findAll(PageRequest.of(pageNum-1,pageSize, Sort.by("no")));//提供分页信息及排序规则
       //通过自定义sql语句实现只显示一级目录及其下面所有的子目录。
        Page<Category> page = dao.findByParentIdIsNull(PageRequest.of(pageNum - 1, pageSize, Sort.by("no")));
        return page;
    }
    //新增或修改操作
    public void saveOrUpdateCategory(Category category) throws ServiceException {
        //注意：当主键值不存在，jpa将修改操作改成新增操作
        Category cate = dao.findById(category.getId()).orElse(null);
        if(category.getId() != 0 && cate == null){
            throw new ServiceException(ResultCode.DATA_NONE);
        }
        //新增或修改目录信息，保证目录名称是不重复的。

        // 扩展：设置相同层级(parent_id相同的目录)的序列号必须保证不重复
        dao.save(category);
    }

    public void deleteCategoryInBatch(List<Integer> ids) throws ServiceException {
        /*
           实现效果：
           利用jpa级联操作：当删除一个栏目时，对应的子栏目要求必须也删除。保留栏目对应咨询信息
         */
        ids.forEach(id -> dao.deleteById(id));
    }

    public void updateCategoryNo(Integer id, int no) throws ServiceException {
        //使用自定义的HQL语句实现操作 update
        dao.updateNoById(id,no);
    }
}
