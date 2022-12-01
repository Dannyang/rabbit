package com.example.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 消费特征
public class ConsumptionCharacteristics {
    // 会员意向
    private Integer memberIntention = 1;
    // 消费总次数
    private Integer minConsumptionTimes = 10;
    private Integer maxConsumptionTimes = 15;
}
