package com.example.rabbit.guava;

import lombok.Data;

import java.util.List;

@Data
public class ProductionVo {
    private Integer id;
    private String pageName;
    private Integer parentId;
    private Integer pageType;
    private Boolean pageShow;
    private Integer pageTag;
    private String description;
    private Integer priority;
    private Integer buriedId;
    private Boolean homePage;
    private String logo;
    List<ProductionVo> productionVoList;
}
