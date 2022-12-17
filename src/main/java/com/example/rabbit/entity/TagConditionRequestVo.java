package com.example.rabbit.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "标签筛选集合")
public class TagConditionRequestVo {
    // 行为特征
    @ApiModelProperty(value = "行为特征", name = "registrySourceType")
    private BehaviorCharacteristics behaviorCharacteristics = new BehaviorCharacteristics();
    // 消费特征
    @ApiModelProperty(value = "消费特征", name = "registrySourceType")
    private ConsumptionCharacteristics consumptionCharacteristics = new ConsumptionCharacteristics();
    // 兴趣偏好
    @ApiModelProperty(value = "兴趣偏好", name = "registrySourceType")
    private InterestAndPreference interestAndPreference = new InterestAndPreference();
    // 心理特征
    @ApiModelProperty(value = "心理特征", name = "registrySourceType")
    private MentalFeature mentalFeature = new MentalFeature();
    // 基本信息
    @ApiModelProperty(value = "基本信息", name = "registrySourceType")
    private BasicInformation basicInformation = new BasicInformation();
    // 权限信息
    @ApiModelProperty(value = "权限信息", name = "registrySourceType")
    private AuthorityInformation authorityInformation = new AuthorityInformation();
    // 用户定制
    @ApiModelProperty(value = "用户定制", name = "registrySourceType")
    private UserCustomization userCustomization = new UserCustomization();
    // 注册信息
    @ApiModelProperty(value = "注册信息", name = "registrySourceType")
    private RegistryInformation registryInformation = new RegistryInformation();
}
