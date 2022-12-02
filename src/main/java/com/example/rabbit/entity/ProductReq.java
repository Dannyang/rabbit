package com.example.rabbit.entity;


import lombok.Data;


@Data
public class ProductReq {

    /**
     *
     */
    private Long id;
    /**
     *
     */
    private String uuid;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父亲 无父级为-1
     */
    private String parentUuid;
    /**
     * 产品层级
     */
    private String level;
}


