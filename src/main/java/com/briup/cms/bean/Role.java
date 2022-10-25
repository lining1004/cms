package com.briup.cms.bean;

import javax.persistence.*;

/**
 * jpa 实体类对应的数据库表cms_role
 * @Author lining
 * @Date 2022/10/25
 */
@Entity
@Table(name = "cms_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;
}
