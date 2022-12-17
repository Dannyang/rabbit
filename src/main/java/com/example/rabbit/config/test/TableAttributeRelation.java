package com.example.rabbit.config.test;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TableAttributeRelation {
    public static  ConcurrentHashMap<String, String> attributeColumnMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Pair<String, String>> tagKeyTableMap = new ConcurrentHashMap<>();
    public static List<String> betweenTag = new ArrayList<>();
    static {
        tagKeyTableMap.put("userClassifying", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "liveness_name"));
        tagKeyTableMap.put("minAccumulatedShared", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO","by_share_cnt"));
        tagKeyTableMap.put("maxAccumulatedShared", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO","by_share_cnt"));
        tagKeyTableMap.put("minAttendTimes", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "total_attend_cnt"));
        tagKeyTableMap.put("maxAttendTimes", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "total_attend_cnt"));
        tagKeyTableMap.put("minConsumptionTimes", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "by_consume_cnt"));
        tagKeyTableMap.put("maxConsumptionTimes", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "by_consume_cnt"));
        tagKeyTableMap.put("memberIntention", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "member_willness_name"));
        tagKeyTableMap.put("activityParticipation", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "activity_level_name"));
        tagKeyTableMap.put("userProvince", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "province_name"));
        tagKeyTableMap.put("userCity", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "city_name"));
        tagKeyTableMap.put("lastLoginTimeStart", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "last_login_date"));
        tagKeyTableMap.put("lastLoginTimeEnd", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "last_login_date"));
        tagKeyTableMap.put("userType", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "user_type"));
        tagKeyTableMap.put("registryTimeStart", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "create_date"));
        tagKeyTableMap.put("registryTimeEnd", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "create_date"));
        tagKeyTableMap.put("registrySourceType", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BASEINFO", "register_source"));

        tagKeyTableMap.put("attendVariety", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_BREED_FREQ_NAME", "breed_freq_name"));

        tagKeyTableMap.put("attentionVariety", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_FOLLOW_BREED", "follow_breed_name"));

        tagKeyTableMap.put("attentionColumn", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_FOLLOW_SECTION", "follow_section_name"));


        tagKeyTableMap.put("attentionProvince", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_REGION_NAME", "province_name"));
        tagKeyTableMap.put("attentionCity", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_REGION_NAME", "city_name"));

        tagKeyTableMap.put("businessType", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_RIGHTS", "business_type_id"));
        tagKeyTableMap.put("authorityType", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_RIGHTS", "rights_type"));
        tagKeyTableMap.put("authorityStatus", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_RIGHTS", "rights_status"));

        tagKeyTableMap.put("customizationType", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_CUSTOMIZED_BREED", "customized_breed_id"));

        tagKeyTableMap.put("customizationColumn", Pair.of("ADS.BACKPUSH_APPUSER_LABEL_CUSTOMIZED_SECTION",
                "customized_section_id"));

    }
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
        attributeColumnMap.put("attentionProvince", "关注地区-省份");
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
