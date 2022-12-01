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
public class RegistryInformation {
    // 注册来源类型多个用逗号分开
    private String registrySourceType = "f,u,c,k";
    // 注册时间
    private Long registryTimeStart = 1479454654561L;
    private Long registryTimeEnd = 54894984L;

}
