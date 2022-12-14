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
public class AuthorityInformation {
    // 业务类型
    private List<String> businessType = Lists.newArrayList("1","2","3");
    // 权限类型
    private List<String> authorityType = Lists.newArrayList("1","2","3");
    private List<String> authorityStatus = Lists.newArrayList("1","2","3");

}
