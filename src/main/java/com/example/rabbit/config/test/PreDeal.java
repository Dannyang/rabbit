package com.example.rabbit.config.test;


import com.example.rabbit.entity.AuthorityInformation;
import com.example.rabbit.entity.BasicInformation;
import com.example.rabbit.entity.BehaviorCharacteristics;
import com.example.rabbit.entity.ConsumptionCharacteristics;
import com.example.rabbit.entity.InterestAndPreference;
import com.example.rabbit.entity.MentalFeature;
import com.example.rabbit.entity.RegistryInformation;
import com.example.rabbit.entity.TagConditionRequestVo;
import com.example.rabbit.entity.UserCustomization;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PreDeal {
    private final PostDeal postDeal;

    public PreDeal(PostDeal postDeal) {
        this.postDeal = postDeal;
    }

    public String parse(TagConditionRequestVo tagConditionRequestVo) {
        if (tagConditionRequestVo == null) {
            return StringUtils.EMPTY;
        }
        postDeal.getSql().append("SELECT 'tagKey' as tagKey,SUM(user_cnt) as count from ADS" +
                ".BACKPUSH_APPUSER_LABEL_SUMMARY");
        setBehaviorCharacteristics(tagConditionRequestVo.getBehaviorCharacteristics());
        setConsumptionCharacteristics(tagConditionRequestVo.getConsumptionCharacteristics());
        setInterestAndPreference(tagConditionRequestVo.getInterestAndPreference());
        setMentalFeature(tagConditionRequestVo.getMentalFeature());
        setBasicInformation(tagConditionRequestVo.getBasicInformation());
        setAuthorityInformation(tagConditionRequestVo.getAuthorityInformation());
        setUserCustomization(tagConditionRequestVo.getUserCustomization());
        setRegistryInformation(tagConditionRequestVo.getRegistryInformation());
        return postDeal.getSql().toString();
    }


    private void setBehaviorCharacteristics(BehaviorCharacteristics behaviorCharacteristics) {
        if (behaviorCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getUserClassifying())) {
            String listVal = getListVal(behaviorCharacteristics.getUserClassifying());
            postDeal.postSet("userClassifying", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getAttendVariety())) {
            String listVal = getListVal(behaviorCharacteristics.getAttendVariety());
            postDeal.postSet("attendVariety", "????????????", listVal, null, null);
        }
        // ????????????
        postDeal.postSet("minAccumulatedShared", "???????????????", null, behaviorCharacteristics.getMinAccumulatedShared(),
                behaviorCharacteristics.getMaxAccumulatedShared());
        // ????????????
        postDeal.postSet("minAttendTimes", "???????????????", null, behaviorCharacteristics.getMinAttendTimes(),
                behaviorCharacteristics.getMaxAttendTimes());

    }

    private void setConsumptionCharacteristics(ConsumptionCharacteristics consumptionCharacteristics) {
        if (consumptionCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(consumptionCharacteristics.getMemberIntention())) {
            String listVal = getListVal(consumptionCharacteristics.getMemberIntention());
            postDeal.postSet("memberIntention", "????????????", listVal, null, null);
        }
        // ??????????????????
        postDeal.postSet("minConsumptionTimes", "??????????????????", null, consumptionCharacteristics.getMinConsumptionTimes(),
                consumptionCharacteristics.getMaxConsumptionTimes());
    }

    private void setMentalFeature(MentalFeature mentalFeature) {
        if (mentalFeature == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(mentalFeature.getActivityParticipation())) {
            String listVal = getListVal(mentalFeature.getActivityParticipation());
            postDeal.postSet("activityParticipation", "???????????????", listVal, null, null);
        }
    }


    private void setInterestAndPreference(InterestAndPreference interestAndPreference) {
        if (interestAndPreference == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionColumn())) {
            String listVal = getListVal(interestAndPreference.getAttentionColumn());
            postDeal.postSet("attentionColumn", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionVariety())) {
            String listVal = getListVal(interestAndPreference.getAttentionVariety());
            postDeal.postSet("attentionVariety", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionCity())) {
            String listVal = getListVal(interestAndPreference.getAttentionCity());
            postDeal.postSet("attentionCity", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionProvince())) {
            String listVal = getListVal(interestAndPreference.getAttentionProvince());
            postDeal.postSet("attentionProvince", "????????????", listVal, null, null);
        }
    }

    private void setBasicInformation(BasicInformation basicInformation) {
        if (basicInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserCity())) {
            String listVal = getListVal(basicInformation.getUserCity());
            postDeal.postSet("userCity", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserType())) {
            String listVal = getListVal(basicInformation.getUserType());
            postDeal.postSet("userType", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserProvince())) {
            String listVal = getListVal(basicInformation.getUserProvince());
            postDeal.postSet("userProvince", "????????????", listVal, null, null);
        }
        // ??????????????????
        postDeal.postSet("lastLoginTimeEnd", "??????????????????", "", basicInformation.getLastLoginTimeStart(),
                basicInformation.getLastLoginTimeEnd());

    }

    private void setAuthorityInformation(AuthorityInformation authorityInformation) {
        if (authorityInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityStatus())) {
            String listVal = getListVal(authorityInformation.getAuthorityStatus());
            postDeal.postSet("authorityStatus", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityType())) {
            String listVal = getListVal(authorityInformation.getAuthorityType());
            postDeal.postSet("authorityType", "????????????", listVal, null, null);

        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getBusinessType())) {
            String listVal = getListVal(authorityInformation.getBusinessType());
            postDeal.postSet("businessType", "????????????", listVal, null, null);
        }
    }

    private void setUserCustomization(UserCustomization userCustomization) {
        if (userCustomization == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationColumn())) {
            String listVal = getListVal(userCustomization.getCustomizationColumn());
            postDeal.postSet("customizationColumn", "????????????", listVal, null, null);
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationType())) {
            String listVal = getListVal(userCustomization.getCustomizationType());
            postDeal.postSet("customizationType", "????????????", listVal, null, null);
        }
    }

    private void setRegistryInformation(RegistryInformation registryInformation) {
        if (registryInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(registryInformation.getRegistrySourceType())) {
            String listVal = getListVal(registryInformation.getRegistrySourceType());
            postDeal.postSet("registrySourceType", "??????????????????", listVal, null, null);
        }
        // ????????????
        postDeal.postSet("registryTimeStart", "????????????", null, registryInformation.getRegistryTimeStart(),
                registryInformation.getRegistryTimeEnd());

    }


    private String getListVal(List<String> listVal) {
        return "(".concat(listVal.stream().map(a -> "'".concat(a).concat("'")).collect(Collectors.joining(","))).concat(")");
    }
}
