package com.example.rabbit.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 行为特征
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestAndPreference {
    // 关注品种多个用逗号分隔
    private List<String> attentionVariety = Lists.newArrayList("1", "2", "3");
    // 关注栏目多个用逗号分隔
    private List<String> attentionColumn = Lists.newArrayList("1", "2", "3");
    // 关注地区城市
    private List<String> attentionCity = Lists.newArrayList("深圳","东莞","广州");
    // 关注地区省份
    private List<String> attentionProvince = Lists.newArrayList("广东","江西","山东");;
}
