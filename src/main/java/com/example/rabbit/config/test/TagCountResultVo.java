package com.example.rabbit.config.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "筛选统计结果")
public class TagCountResultVo {
    @ApiModelProperty(value = "标签名称", name = "tagName")
    private String tagName;
    @ApiModelProperty(value = "已选内容(多个用、分割)", name = "selectedContent")
    private String selectedContent;
    @ApiModelProperty(value = "根据所选条件筛选出来的用户数", name = "countOfContainedUser")
    private Long countOfContainedUser;
    @ApiModelProperty(value = "标签key", name = "tagKey")
    private String tagKey;
}
