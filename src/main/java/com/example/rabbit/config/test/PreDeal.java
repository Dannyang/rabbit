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

public class PreDeal {
    private final PostDeal postDeal;

    public PreDeal(PostDeal postDeal) {
        this.postDeal = postDeal;
    }

    public String parse(TagConditionRequestVo tagConditionRequestVo) {
        if (tagConditionRequestVo == null) {
            return StringUtils.EMPTY;
        }
        postDeal.getSqlBuilder().append("SELECT 'tagKey' as tagKey,SUM(user_cnt) as count from ADS" +
                ".BACKPUSH_APPUSER_LABEL_SUMMARY");
        setBehaviorCharacteristics(tagConditionRequestVo.getBehaviorCharacteristics());
        setConsumptionCharacteristics(tagConditionRequestVo.getConsumptionCharacteristics());
        setInterestAndPreference(tagConditionRequestVo.getInterestAndPreference());
        setMentalFeature(tagConditionRequestVo.getMentalFeature());
        setBasicInformation(tagConditionRequestVo.getBasicInformation());
        setAuthorityInformation(tagConditionRequestVo.getAuthorityInformation());
        setUserCustomization(tagConditionRequestVo.getUserCustomization());
        setRegistryInformation(tagConditionRequestVo.getRegistryInformation());
        return postDeal.getSqlBuilder().toString();
    }


    private void setBehaviorCharacteristics(BehaviorCharacteristics behaviorCharacteristics) {
        if (behaviorCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getUserClassifying())) {
            postDeal.postSet("userClassifying", "用户分类", behaviorCharacteristics.getUserClassifying(), null, null);
        }
        if (CollectionUtils.isNotEmpty(behaviorCharacteristics.getAttendVariety())) {
            postDeal.postSet("attendVariety", "参会品种", behaviorCharacteristics.getAttendVariety(), null, null);
        }
        // 分享次数
        postDeal.postSet("minAccumulatedShared", "累计分享量", null, behaviorCharacteristics.getMinAccumulatedShared(),
                behaviorCharacteristics.getMaxAccumulatedShared());
        // 参加次数
        postDeal.postSet("minAttendTimes", "参会总次数", null, behaviorCharacteristics.getMinAttendTimes(),
                behaviorCharacteristics.getMaxAttendTimes());

    }

    private void setConsumptionCharacteristics(ConsumptionCharacteristics consumptionCharacteristics) {
        if (consumptionCharacteristics == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(consumptionCharacteristics.getMemberIntention())) {
            postDeal.postSet("memberIntention", "会员意向", consumptionCharacteristics.getMemberIntention(), null, null);
        }
        // 累计消费次数
        postDeal.postSet("minConsumptionTimes", "累计消费次数", null, consumptionCharacteristics.getMinConsumptionTimes(),
                consumptionCharacteristics.getMaxConsumptionTimes());
    }

    private void setMentalFeature(MentalFeature mentalFeature) {
        if (mentalFeature == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(mentalFeature.getActivityParticipation())) {
            postDeal.postSet("activityParticipation", "活动参与度", mentalFeature.getActivityParticipation(), null, null);
        }
    }


    private void setInterestAndPreference(InterestAndPreference interestAndPreference) {
        if (interestAndPreference == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionColumn())) {
            postDeal.postSet("attentionColumn", "关注栏目", interestAndPreference.getAttentionColumn(), null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionVariety())) {
            postDeal.postSet("attentionVariety", "关注品种", interestAndPreference.getAttentionVariety(), null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionCity())) {
            postDeal.postSet("attentionCity", "关注地区", interestAndPreference.getAttentionCity(), null, null);
        }
        if (CollectionUtils.isNotEmpty(interestAndPreference.getAttentionProvince())) {
            postDeal.postSet("attentionProvince", "关注地区", interestAndPreference.getAttentionProvince(), null, null);
        }
    }

    private void setBasicInformation(BasicInformation basicInformation) {
        if (basicInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserCity())) {
            postDeal.postSet("userCity", "所在地区", basicInformation.getUserCity(), null, null);
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserType())) {
            postDeal.postSet("userType", "用户类型", basicInformation.getUserType(), null, null);
        }
        if (CollectionUtils.isNotEmpty(basicInformation.getUserProvince())) {
            postDeal.postSet("userProvince", "所在地区", basicInformation.getUserProvince(), null, null);
        }
        // 最后登录时间
        postDeal.postSet("lastLoginTimeEnd", "最后登录时间", null, basicInformation.getLastLoginTimeStart(),
                basicInformation.getLastLoginTimeEnd());

    }

    private void setAuthorityInformation(AuthorityInformation authorityInformation) {
        if (authorityInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityStatus())) {
            postDeal.postSet("authorityStatus", "权限状态", authorityInformation.getAuthorityStatus(), null, null);
        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getAuthorityType())) {
            postDeal.postSet("authorityType", "权限类型", authorityInformation.getAuthorityType(), null, null);

        }
        if (CollectionUtils.isNotEmpty(authorityInformation.getBusinessType())) {
            postDeal.postSet("businessType", "业务类型", authorityInformation.getBusinessType(), null, null);
        }
    }

    private void setUserCustomization(UserCustomization userCustomization) {
        if (userCustomization == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationColumn())) {
            postDeal.postSet("customizationColumn", "定制栏目", userCustomization.getCustomizationColumn(), null, null);
        }
        if (CollectionUtils.isNotEmpty(userCustomization.getCustomizationType())) {
            postDeal.postSet("customizationType", "定制品种", userCustomization.getCustomizationType(), null, null);
        }
    }

    private void setRegistryInformation(RegistryInformation registryInformation) {
        if (registryInformation == null) {
            return;
        }
        if (CollectionUtils.isNotEmpty(registryInformation.getRegistrySourceType())) {
            postDeal.postSet("registrySourceType", "注册来源类型", registryInformation.getRegistrySourceType(), null, null);
        }
        // 注册时间
        postDeal.postSet("registryTimeStart", "注册时间", null, registryInformation.getRegistryTimeStart(),
                registryInformation.getRegistryTimeEnd());

    }



}
