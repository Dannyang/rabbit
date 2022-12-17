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
public class BasicInformation {
    // 所在地区城市
    private List<String> userCity = Lists.newArrayList("深圳","东莞","广州");
    // 所在地区省份
    private List<String> userProvince = Lists.newArrayList("广东","江西","山东");;
    // 最后登录时间
    private Long lastLoginTimeStart = 1367121060000L;
    private Long lastLoginTimeEnd = 1367121109638L;
    // 用户类型
    private List<String> userType = Lists.newArrayList("1","2","3");

}
