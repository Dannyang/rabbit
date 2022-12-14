package com.example.rabbit.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 用户定制
public class UserCustomization {
    // 定制品种
    private List<String> customizationType= Lists.newArrayList("定制品种");
    // 定制栏目
    private List<String> customizationColumn = Lists.newArrayList("定制栏目");
}
