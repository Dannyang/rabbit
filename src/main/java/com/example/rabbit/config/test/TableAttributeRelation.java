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
        attributeColumnMap.put("userClassifying", "????????????");
        attributeColumnMap.put("attendVariety", "????????????");
        attributeColumnMap.put("minAccumulatedShared", "???????????????");
        attributeColumnMap.put("maxAccumulatedShared", "???????????????");
        attributeColumnMap.put("minAttendTimes", "???????????????");
        attributeColumnMap.put("maxAttendTimes", "???????????????");
        attributeColumnMap.put("memberIntention", "????????????");
        attributeColumnMap.put("minConsumptionTimes", "??????????????????");
        attributeColumnMap.put("maxConsumptionTimes", "??????????????????");
        attributeColumnMap.put("attentionVariety", "????????????");
        attributeColumnMap.put("attentionColumn", "????????????");
        attributeColumnMap.put("attentionCity", "????????????-??????");
        attributeColumnMap.put("attentionProvince", "????????????-??????");
        attributeColumnMap.put("activityParticipation", "???????????????");
        attributeColumnMap.put("userCity", "????????????-??????");
        attributeColumnMap.put("userProvince", "????????????-??????");
        attributeColumnMap.put("lastLoginTimeStart", "??????????????????");
        attributeColumnMap.put("lastLoginTimeEnd", "??????????????????");
        attributeColumnMap.put("userType", "????????????");
        attributeColumnMap.put("businessType", "????????????");
        attributeColumnMap.put("authorityType", "????????????");
        attributeColumnMap.put("authorityStatus", "????????????");
        attributeColumnMap.put("customizationType", "????????????");
        attributeColumnMap.put("customizationColumn", "????????????");
        attributeColumnMap.put("registrySourceType", "??????????????????");
        attributeColumnMap.put("registryTimeStart", "????????????");
        attributeColumnMap.put("registryTimeEnd", "????????????");
    }

}
