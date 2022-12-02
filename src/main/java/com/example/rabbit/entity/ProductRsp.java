package com.example.rabbit.entity;

import lombok.Data;

import java.util.List;


@Data
public class ProductRsp  {

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

    private Integer sort;

    private String parentUuid;

    private String level;

    private List<ProductRsp> subList;
}

