package com.example.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 基本信息
public class AuthorityInformation {
    // 业务类型
    private String businessType = "业务类型";
    // 权限类型
    private Integer authorityType = 2;
    private Integer authorityStatus = 3;

}
