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
// 基本信息
public class RegistryInformation {
    // 注册来源类型多个用逗号分开
    private List<String> registrySourceType = Lists.newArrayList("s","2");
    // 注册时间
    private Long registryTimeStart = 1479454654561L;
//    private Long registryTimeStart;
    private Long registryTimeEnd;
//    private Long registryTimeEnd;
}
