package com.briup.cms.bean;

import javax.persistence.*;

/**
 * jpa 实体类对应的数据库表cms_user
 * @Author lining
 * @Date 2022/10/25
 */
@Entity
@Table(name = "cms_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //剩下的列需要大家补充：实现1:1  1:N M:N
}
