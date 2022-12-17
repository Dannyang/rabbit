package com.example.rabbit.config.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TableAttributeRelation {
    public static  ConcurrentHashMap<String, String> attributeColumnMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> tagKeySqlMap = new ConcurrentHashMap<>();
    public static List<String> betweenTag = new ArrayList<>();
    static {
        betweenTag.add("minAccumulatedShared");
        betweenTag.add("maxAccumulatedShared");
        betweenTag.add("minAttendTimes");
        betweenTag.add("maxAttendTimes");
        betweenTag.add("minConsumptionTimes");
        betweenTag.add("maxConsumptionTimes");
        betweenTag.add("lastLoginTimeStart");
        betweenTag.add("lastLoginTimeEnd");
        betweenTag.add("registryTimeStart");
        betweenTag.add("registryTimeEnd");
    }

    static {
        attributeColumnMap.put("userClassifying", "用户分类");
        attributeColumnMap.put("attendVariety", "参会品种");
        attributeColumnMap.put("minAccumulatedShared", "累计分享量");
        attributeColumnMap.put("maxAccumulatedShared", "累计分享量");
        attributeColumnMap.put("minAttendTimes", "参会总次数");
        attributeColumnMap.put("maxAttendTimes", "参会总次数");
        attributeColumnMap.put("memberIntention", "会员意向");
        attributeColumnMap.put("minConsumptionTimes", "累计消费次数");
        attributeColumnMap.put("maxConsumptionTimes", "累计消费次数");
        attributeColumnMap.put("attentionVariety", "关注品种");
        attributeColumnMap.put("attentionColumn", "关注栏目");
        attributeColumnMap.put("attentionCity", "关注地区-城市");
        attributeColumnMap.put("attentionProvince", "关注地区-城市");
        attributeColumnMap.put("activityParticipation", "活动参与度");
        attributeColumnMap.put("userCity", "所在地区-城市");
        attributeColumnMap.put("userProvince", "所在地区-省份");
        attributeColumnMap.put("lastLoginTimeStart", "最后登录时间");
        attributeColumnMap.put("lastLoginTimeEnd", "最后登录时间");
        attributeColumnMap.put("userType", "用户类型");
        attributeColumnMap.put("businessType", "业务类型");
        attributeColumnMap.put("authorityType", "权限类型");
        attributeColumnMap.put("authorityStatus", "权限状态");
        attributeColumnMap.put("customizationType", "定制品种");
        attributeColumnMap.put("customizationColumn", "定制栏目");
        attributeColumnMap.put("registrySourceType", "注册来源类型");
        attributeColumnMap.put("registryTimeStart", "注册时间");
        attributeColumnMap.put("registryTimeEnd", "注册时间");
    }

}
