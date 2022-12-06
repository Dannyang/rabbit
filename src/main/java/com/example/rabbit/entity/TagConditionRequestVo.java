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
    // 用户分类,多个用逗号分隔
    private String userClassifying = "1,2,3";
    // 参会品种，多个用逗号分隔
    private String attendVariety = "1,2,3";
    // 累计分享量
    private Integer minAccumulatedShared = 10;
    private Integer maxAccumulatedShared = 15;
    // 参会总次数
    private Integer minAttendTimes = 10;
    private Integer maxAttendTimes = 15;

    // 消费特征
    // 会员意向
    @ApiModelProperty(value = "会员意向")
    private Integer memberIntention;
    // 消费总次数
    @ApiModelProperty(value = "消费总次数下限", name = "minConsumptionTimes")
    private Integer minConsumptionTimes;
    @ApiModelProperty(value = "消费总次数上限", name = "maxConsumptionTimes")
    private Integer maxConsumptionTimes;


    // 兴趣偏好
    // 关注品种多个用逗号分隔
    @ApiModelProperty(value = "关注品种", name = "attentionVariety")
    private String attentionVariety;
    // 关注栏目多个用逗号分隔
    @ApiModelProperty(value = "关注栏目", name = "attentionColumn")
    private String attentionColumn;
    // 关注地区
    @ApiModelProperty(value = "关注地区", name = "attentionArea")
    private String attentionArea;

    // 心理特征
    // 活动参与度
    @ApiModelProperty(value = "活动参与度", name = "activityParticipation")
    private Integer activityParticipation;

    // 基本信息
    // 所在地区
    @ApiModelProperty(value = "所在地区", name = "userLocation")
    private String userLocation;
    // 最后登录时间
    @ApiModelProperty(value = "最后登录时间下限", name = "lastLoginTimeStart")
    private Long lastLoginTimeStart;
    @ApiModelProperty(value = "最后登录时间上限", name = "lastLoginTimeEnd")
    private Long lastLoginTimeEnd;
    // 用户类型
    @ApiModelProperty(value = "用户类型", name = "userType")
    private Integer userType;


    // 权限信息
    // 业务类型
    @ApiModelProperty(value = "业务类型", name = "businessType")
    private String businessType;
    // 权限类型
    @ApiModelProperty(value = "权限类型", name = "authorityType")
    private Integer authorityType;
    @ApiModelProperty(value = "权限状态", name = "authorityStatus")
    private Integer authorityStatus;



    // 用户定制
    // 定制品种
    @ApiModelProperty(value = "定制品种", name = "customizationType")
    private String customizationType;
    // 定制栏目
    @ApiModelProperty(value = "定制栏目", name = "customizationColumn")
    private String customizationColumn ;


    // 注册信息
    // 注册来源类型多个用逗号分开
    @ApiModelProperty(value = "注册来源类型", name = "registrySourceType")
    private String registrySourceType ;
    // 注册时间
    @ApiModelProperty(value = "注册时间下限", name = "registryTimeStart")
    private Long registryTimeStart ;
    @ApiModelProperty(value = "注册时间上限", name = "registryTimeEnd")
    private Long registryTimeEnd ;
}
