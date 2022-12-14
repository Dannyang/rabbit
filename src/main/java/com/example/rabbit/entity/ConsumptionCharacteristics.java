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
// 消费特征
public class ConsumptionCharacteristics {
    // 会员意向
    private List<String> memberIntention = Lists.newArrayList("1","2");
    // 消费总次数
    private Integer minConsumptionTimes = 10;
    private Integer maxConsumptionTimes = 15;
}
