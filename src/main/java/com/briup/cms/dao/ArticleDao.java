package com.briup.cms.dao;

import com.briup.cms.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lining
 * @Date 2022/11/1
 */
public interface ArticleDao extends JpaRepository<Article,Integer> {
}
