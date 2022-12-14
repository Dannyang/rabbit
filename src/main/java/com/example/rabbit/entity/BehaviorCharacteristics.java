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
public class BehaviorCharacteristics {
    // 用户分类,多个用逗号分隔
    private List<String> userClassifying = Lists.newArrayList("1","2","3");
    // 参会品种，多个用逗号分隔
    private List<String> attendVariety = Lists.newArrayList("1","2","3");
    // 累计分享量
    private Integer minAccumulatedShared = 10;
    private Integer maxAccumulatedShared = 15;
    // 参会总次数
    private Integer minAttendTimes = 10;
    private Integer maxAttendTimes = 15;
}
