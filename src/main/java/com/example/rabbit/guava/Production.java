package com.example.rabbit.guava;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.lizhivscaomei.libs.tree.entity.TreeSourceNode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Production extends TreeSourceNode {
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

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.pageName;
    }

    @Override
    public String getParentId() {
        return this.parentId;
    }


}
