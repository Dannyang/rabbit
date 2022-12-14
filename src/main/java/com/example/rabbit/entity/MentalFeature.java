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
// 心理特征
public class MentalFeature {
    // 活动参与度
    private List<String> activityParticipation = Lists.newArrayList("1","2");
}
