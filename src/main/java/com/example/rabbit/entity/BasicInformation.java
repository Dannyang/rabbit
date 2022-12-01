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
public class BasicInformation {
    // 所在地区
    private String userLocation = "东莞";
    // 最后登录时间
    private Long lastLoginTimeStart = 1367121060000L;
    private Long lastLoginTimeEnd = 1367121109638L;
    // 用户类型
    private Integer userType = 2;

}
