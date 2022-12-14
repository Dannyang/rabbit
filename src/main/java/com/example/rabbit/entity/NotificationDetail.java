package com.example.rabbit.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDetail {
    //    private String title = "title";
//    private String content = "content";
//    // Id/URL
//    private Integer boundedArticleType = 1;
//    private String boundedContent = "1234586";
//    // 推送类型全部推送/指定用户号码/通过标签推送
//    private Integer pushType = 1;
    // 行为特征
    private BehaviorCharacteristics behaviorCharacteristics ;
    // 消费特征
    private ConsumptionCharacteristics consumptionCharacteristics = new ConsumptionCharacteristics();
    // 兴趣偏好
    private InterestAndPreference interestAndPreference = new InterestAndPreference();
    // 心理特征
    private MentalFeature mentalFeature = new MentalFeature();
    // 基本信息
    private BasicInformation basicInformation = new BasicInformation();
    // 权限信息
    private AuthorityInformation authorityInformation = new AuthorityInformation();
    // 用户定制
    private UserCustomization userCustomization = new UserCustomization();
    // 注册信息
    private RegistryInformation registryInformation = new RegistryInformation();

    public static void main(String[] args) {
        System.out.println("SF".equalsIgnoreCase("sf"));
        NotificationDetail notificationDetail = new NotificationDetail();
        t(BehaviorCharacteristics.class);

        String string = JSON.toJSONString(notificationDetail);
        System.out.println(string);

    }

    public static <T> void t(Class<T> clazz) {
        BehaviorCharacteristics behaviorCharacteristics = new BehaviorCharacteristics();
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(clazz.getSimpleName());
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object o = field.get(behaviorCharacteristics);
                System.out.println(o.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        List<String> strings = Arrays.stream(declaredFields).map(Field::getName).collect(Collectors.toList());
        System.out.println(strings);
    }

//    public static void t2(){
//        Field[]
//    }
}
