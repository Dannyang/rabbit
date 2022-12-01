package com.example.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 用户定制
public class UserCustomization {
    // 定制品种
    private String customizationType= "定制品种";
    // 定制栏目
    private String customizationColumn = "定制栏目";
}
