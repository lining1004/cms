package com.briup.cms.dao;

import com.briup.cms.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Author lining
 * @Date 2022/11/1
 */
public interface CommentDao extends JpaRepository<Comment,Integer> {

    @Transactional
    @Modifying
    @Query("update Comment set parent.id = null where parent.id = ?1")//HQL
    void updateParentId(Integer id);
}
