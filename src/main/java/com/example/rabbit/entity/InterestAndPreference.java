package com.example.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 行为特征
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestAndPreference {
    // 关注品种多个用逗号分隔
    private String attentionVariety = "1,2,3";
    // 关注栏目多个用逗号分隔
    private String attentionColumn = "2,3,4";
    // 关注地区
    private String attentionArea = "东莞";
}
