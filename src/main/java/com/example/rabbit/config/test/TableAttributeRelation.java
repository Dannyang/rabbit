package com.example.rabbit.config.test;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TableAttributeRelation {
    public static  ConcurrentHashMap<String, String> attributeColumnMap = new ConcurrentHashMap<>();
    public static List<String> inQueryList = new ArrayList<>();
    public static List<Pair<String, String>> betweenList= new ArrayList<>(0);
    public static List<String> littleThanQueryList = new ArrayList<>();
    public static List<String> lagerThanQueryList = new ArrayList<>();
    static {
        inQueryList.add("userClassifying");
        inQueryList.add("attendVariety");
        inQueryList.add("memberIntention");
        inQueryList.add("attentionVariety");
        inQueryList.add("attentionColumn");
        inQueryList.add("attentionArea");
        inQueryList.add("userLocation");
        inQueryList.add("userType");
        inQueryList.add("businessType");
        inQueryList.add("authorityType");
        inQueryList.add("authorityStatus");
        inQueryList.add("customizationType");
        inQueryList.add("customizationColumn");
        inQueryList.add("registrySourceType");
        inQueryList.add("activityParticipation");
    }
    static {
        betweenList.add(Pair.of("minAttendTimes","maxAttendTimes"));
        betweenList.add(Pair.of("minAccumulatedShared","maxAccumulatedShared"));
        betweenList.add(Pair.of("minConsumptionTimes","maxConsumptionTimes"));
        betweenList.add(Pair.of("lastLoginTimeStart","lastLoginTimeEnd"));
        betweenList.add(Pair.of("registryTimeStart","registryTimeEnd"));
    }
    static {
        littleThanQueryList.add("maxAttendTimes");
        littleThanQueryList.add("maxAccumulatedShared");
        littleThanQueryList.add("maxConsumptionTimes");
        littleThanQueryList.add("lastLoginTimeEnd");
        littleThanQueryList.add("registryTimeEnd");
    }
    static {
        lagerThanQueryList.add("minAccumulatedShared");
        lagerThanQueryList.add("minAttendTimes");
        lagerThanQueryList.add("minConsumptionTimes");
        lagerThanQueryList.add("lastLoginTimeStart");
        lagerThanQueryList.add("registryTimeStart");
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
        attributeColumnMap.put("attentionArea", "关注地区");
        attributeColumnMap.put("activityParticipation", "活动参与度");
        attributeColumnMap.put("userLocation", "所在地区");
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
