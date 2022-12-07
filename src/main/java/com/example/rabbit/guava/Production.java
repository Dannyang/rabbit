package com.example.rabbit.guava;

import com.example.rabbit.util.TreeDot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Production extends TreeDot {
    private String id;
    private String pageName;
    private String parentId;
    private Integer pageType;
    private Boolean pageShow;
    private Integer pageTag;
    private String description;
    private Integer priority;
    private Integer buriedId;
    private Boolean homePage;
    private String logo;
}
