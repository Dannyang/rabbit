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
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Test test = new Test();
//        List<TagCountResultVo> count = test.getCount(new TagConditionRequestVo());
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(count.size());
        String parse1 = new PreDeal(new PostDeal1(new StringBuilder())).parse(new TagConditionRequestVo());
        System.out.println(parse1);
        String parse2 = new PreDeal(new PostDeal2(new StringBuilder())).parse(new TagConditionRequestVo());
        System.out.println(parse2);

    }
    public List<TagCountResultVo> getCount(TagConditionRequestVo tagConditionRequestVo) {
        List<TagCountResultVo> tagCountResultVos = Lists.newArrayList();
        if (tagConditionRequestVo == null) {
            return tagCountResultVos;
        }
        setBehaviorCharacteristics(tagConditionRequestVo.getBehaviorCharacteristics(), tagCountResultVos);
        setConsumptionCharacteristics(tagConditionRequestVo.getConsumptionCharacteristics(), tagCountResultVos);
        setInterestAndPreference(tagConditionRequestVo.getInterestAndPreference(), tagCountResultVos);
        setMentalFeature(tagConditionRequestVo.getMentalFeature(), tagCountResultVos);
        setBasicInformation(tagConditionRequestVo.getBasicInformation(), tagCountResultVos);
        setAuthorityInformation(tagConditionRequestVo.getAuthorityInformation(), tagCountResultVos);
        setUserCustomization(tagConditionRequestVo.getUserCustomization(), tagCountResultVos);
        setRegistryInformation(tagConditionRequestVo.getRegistryInformation(), tagCountResultVos);
        return tagCountResultVos;
    }

    private void addTagCountResult(List<TagCountResultVo> tagCountResultVos, String tagName, String tagContent,
                                   Long count, String tagKey) {
        TagCountResultVo tagCountResultVo = TagCountResultVo.builder()
                .tagName(tagName)
                .selectedContent(tagContent)
                .countOfContainedUser(count)
                .tagKey(tagKey)
                .build();
        tagCountResultVos.add(tagCountResultVo);
    }

    private <T> Long getRangeCount(T left, T right, String fieldName) {
        Long rangeCount = -1L;
        if (left != null && right != null) {
            rangeCount = getLong(String.valueOf(left), String.valueOf(right), fieldName);
        }
        if (left != null && right == null) {
            rangeCount = getLongWithoutEnd(String.valueOf(left), fieldName);
        }
        if (left == null && right != null) {
            rangeCount = getLongWithoutStart(String.valueOf(right), fieldName);
        }
        return rangeCount;
    }

    private void setBehaviorCharacteristics(BehaviorCharacteristics behaviorCharacteristics, List<TagCountResultVo> tagCountResultVos) {
        if (behaviorCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getUserClassifying())) {
            String listVal = getListVal(behaviorCharacteristics.getUserClassifying());
            Long classifying = getLong(listVal, "userClassifying");
            addTagCountResult(tagCountResultVos, "????????????", "", classifying, "userClassifying");
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getAttendVariety())) {
            String listVal = getListVal(behaviorCharacteristics.getAttendVariety());
            Long attendVariety = getLong(listVal, "attendVariety");
            addTagCountResult(tagCountResultVos, "????????????", "", attendVariety, "attendVariety");
        }
        // ????????????
        Long accumulatedShared = getRangeCount(behaviorCharacteristics.getMinAccumulatedShared(),
                behaviorCharacteristics.getMaxAccumulatedShared(), "minAccumulatedShared");
        if (accumulatedShared != -1L) {
            addTagCountResult(tagCountResultVos, "???????????????", "", accumulatedShared, "accumulatedShared");
        }
        // ????????????
        Long attendTimes = getRangeCount(behaviorCharacteristics.getMinAttendTimes(),
                behaviorCharacteristics.getMaxAttendTimes(), "minAttendTimes");
        if (attendTimes != -1L) {
            addTagCountResult(tagCountResultVos, "???????????????", "", attendTimes, "minAttendTimes");
        }
    }

    private void setConsumptionCharacteristics(ConsumptionCharacteristics consumptionCharacteristics, List<TagCountResultVo> tagCountResultVos) {
        if (consumptionCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(consumptionCharacteristics.getMemberIntention())) {
            String listVal = getListVal(consumptionCharacteristics.getMemberIntention());
            Long memberIntention = getLong(listVal, "memberIntention");
            addTagCountResult(tagCountResultVos, "????????????", "", memberIntention, "memberIntention");
        }
        // ??????????????????
        Long consumptionTimes = getRangeCount(consumptionCharacteristics.getMinConsumptionTimes(),
                consumptionCharacteristics.getMaxConsumptionTimes(), "minConsumptionTimes");
        if (consumptionTimes != -1L) {
            addTagCountResult(tagCountResultVos, "??????????????????", "", consumptionTimes, "minConsumptionTimes");
        }
    }

    private void setMentalFeature(MentalFeature mentalFeature, List<TagCountResultVo> tagCountResultVos) {
        if (mentalFeature == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(mentalFeature.getActivityParticipation())) {
            String listVal = getListVal(mentalFeature.getActivityParticipation());
            Long activityParticipation = getLong(listVal, "activityParticipation");
            addTagCountResult(tagCountResultVos, "???????????????", "", activityParticipation, "activityParticipation");
        }
    }


    private void setInterestAndPreference(InterestAndPreference interestAndPreference, List<TagCountResultVo> tagCountResultVos) {
        if (interestAndPreference == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionColumn())) {
            String listVal = getListVal(interestAndPreference.getAttentionColumn());
            Long attentionColumn = getLong(listVal, "attentionColumn");
            addTagCountResult(tagCountResultVos, "????????????", "", attentionColumn, "attentionColumn");
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionVariety())) {
            String listVal = getListVal(interestAndPreference.getAttentionVariety());
            Long attentionVariety = getLong(listVal, "attentionVariety");
            addTagCountResult(tagCountResultVos, "????????????", "", attentionVariety, "attentionVariety");
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionCity())) {
            String listVal = getListVal(interestAndPreference.getAttentionCity());
            Long attentionCity = getLong(listVal, "attentionCity");
            addTagCountResult(tagCountResultVos, "????????????", "", attentionCity, "attentionCity");
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionProvince())) {
            String listVal = getListVal(interestAndPreference.getAttentionProvince());
            Long attentionProvince = getLong(listVal, "attentionProvince");
            addTagCountResult(tagCountResultVos, "????????????", "", attentionProvince, "attentionProvince");
        }
    }

    private void setBasicInformation(BasicInformation basicInformation, List<TagCountResultVo> tagCountResultVos) {
        if (basicInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserCity())) {
            String listVal = getListVal(basicInformation.getUserCity());
            Long userCity = getLong(listVal, "userCity");
            addTagCountResult(tagCountResultVos, "????????????", "", userCity, "userCity");
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserType())) {
            String listVal = getListVal(basicInformation.getUserType());
            Long userType = getLong(listVal, "userType");
            addTagCountResult(tagCountResultVos, "????????????", "", userType, "userType");
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserProvince())) {
            String listVal = getListVal(basicInformation.getUserProvince());
            Long userProvince = getLong(listVal, "userProvince");
            addTagCountResult(tagCountResultVos, "????????????", "", userProvince, "userProvince");
        }
        // ??????????????????
        Long lastLoginTime = getRangeCount(basicInformation.getLastLoginTimeStart(),
                basicInformation.getLastLoginTimeEnd(), "lastLoginTimeEnd");
        if (lastLoginTime != -1L) {
            addTagCountResult(tagCountResultVos, "??????????????????", "", lastLoginTime, "lastLoginTime");
        }
    }

    private void setAuthorityInformation(AuthorityInformation authorityInformation, List<TagCountResultVo> tagCountResultVos) {
        if (authorityInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityStatus())) {
            String listVal = getListVal(authorityInformation.getAuthorityStatus());
            Long authorityStatus = getLong(listVal, "authorityStatus");
            addTagCountResult(tagCountResultVos, "????????????", "", authorityStatus, "authorityStatus");
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityType())) {
            String listVal = getListVal(authorityInformation.getAuthorityType());
            Long authorityType = getLong(listVal, "authorityType");
            addTagCountResult(tagCountResultVos, "????????????", "", authorityType, "authorityType");

        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getBusinessType())) {
            String listVal = getListVal(authorityInformation.getBusinessType());
            Long businessType = getLong(listVal, "businessType");
            addTagCountResult(tagCountResultVos, "????????????", "", businessType, "businessType");
        }
    }

    private void setUserCustomization(UserCustomization userCustomization, List<TagCountResultVo> tagCountResultVos) {
        if (userCustomization == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationColumn())) {
            String listVal = getListVal(userCustomization.getCustomizationColumn());
            Long customizationColumn = getLong(listVal, "customizationColumn");
            addTagCountResult(tagCountResultVos, "????????????", "", customizationColumn, "customizationColumn");
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationType())) {
            String listVal = getListVal(userCustomization.getCustomizationType());
            Long customizationType = getLong(listVal, "customizationType");
            addTagCountResult(tagCountResultVos, "????????????", "", customizationType, "customizationType");
        }
    }

    private void setRegistryInformation(RegistryInformation registryInformation, List<TagCountResultVo> tagCountResultVos) {
        if (registryInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(registryInformation.getRegistrySourceType())) {
            String listVal = getListVal(registryInformation.getRegistrySourceType());
            Long registrySourceType = getLong(listVal, "registrySourceType");
            addTagCountResult(tagCountResultVos, "??????????????????", "", registrySourceType, "registrySourceType");
        }
        // ????????????
        Long registryTime = getRangeCount(registryInformation.getRegistryTimeStart(),
                registryInformation.getRegistryTimeEnd(), "registryTimeStart");
        if (registryTime != -1L) {
            addTagCountResult(tagCountResultVos, "????????????", "", registryTime, "registryTime");
        }
    }

    public static final String inSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY WHERE label_type = '%s' " +
            "AND " +
            "label_info IN %s";
    public static final String betweenSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY WHERE " +
            "label_type = '%s' AND " +
            "labe_info >= '%s' AND labe_info <= '%s'";
    public static final String betweenWithoutEndSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE label_type " +
            "= '%s' AND labe_info >= '%s'";
    public static final String betweenWithoutStartSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE " +
            "label_type ='%s' AND labe_info <= '%s'";

    public Long getLong(String val, String fieldName) {
        String sql = String.format(inSql, TableAttributeRelation.attributeColumnMap.get(fieldName), val);
        System.out.println(sql);
        return 1L;
    }


    public Long getLongWithoutEnd(String start, String fieldName) {
        String sql = String.format(betweenWithoutEndSql, TableAttributeRelation.attributeColumnMap.get(fieldName),
                start);
        System.out.println(sql);
        return 1L;
    }

    public Long getLongWithoutStart(String end, String fieldName) {
        String sql = String.format(betweenWithoutStartSql, TableAttributeRelation.attributeColumnMap.get(fieldName),
                end);
        System.out.println(sql);
        return 1L;
    }

    public Long getLong(String start, String end, String fieldName) {
        String sql = String.format(betweenSql, TableAttributeRelation.attributeColumnMap.get(fieldName), start, end);
        System.out.println(sql);
        return 1L;
    }

    private String getListVal(List<String> listVal) {
        return "(".concat(listVal.stream().map(a -> "'".concat(a).concat("'")).collect(Collectors.joining(","))).concat(")");
    }
}
