package com.example.rabbit.config.test;

import com.example.rabbit.entity.NotificationDetail;
import com.example.rabbit.entity.RegistryInformation;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Strategy {
    public static void main(String[] args) {
        try {
            HashMap<String, String> map = new HashMap<>();
            NotificationDetail notificationDetail = new NotificationDetail();
            RegistryInformation registryInformation = notificationDetail.getRegistryInformation();
            System.out.println(String.valueOf(registryInformation.getRegistryTimeEnd()));
//            Field[] declaredFields = notificationDetail.getClass().getDeclaredFields();
//            for (Field field : declaredFields) {
//                field.setAccessible(true);
//                Object o = field.get(notificationDetail);
//                if (o == null) {
//                    continue;
//                }
//                HashMap<String, String> hashMap = t(o.getClass(), o);
//                System.out.println(hashMap);
//            }
//            if (notificationDetail.getMentalFeature() != null) {
//                map = t(MentalFeature.class, notificationDetail.getMentalFeature());
//            }
//            System.out.println(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static HashMap<String, String> t(Class<?> clazz, Object instance) {
//        if (instance == null) {
//            return Maps.newHashMap();
//        }
//        Field[] declaredFields = clazz.getDeclaredFields();
//        HashMap<String, String> resultMap = new HashMap<>();
//        for (Field field : declaredFields) {
//            field.setAccessible(true);
//            try {
//                Object paramVal = field.get(instance);
//                if (paramVal == null) {
//                    continue;
//                }
//                if (TableAttributeRelation.inQueryList.contains(field.getName())) {
//                    List<String> listVal = (List<String>) field.get(instance);
//                    String inVal = "(".concat(listVal.stream().map(a -> "'".concat(a).concat("'")).collect(Collectors.joining(","))).concat(")");
//                    String sql = String.format(inSql,
//                            TableAttributeRelation.attributeColumnMap.get(field.getName()), inVal);
//                    resultMap.put(clazz.getSimpleName().concat(".").concat(field.getName()), sql);
//                    continue;
//                }
//                resultMap.put(clazz.getSimpleName().concat(".").concat(field.getName()), buildRangeSql(field.getName(), instance));
//            } catch (IllegalAccessException | NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        }
//        return resultMap;
//    }
//
//    private static <T> String buildRangeSql(String fieldName, T instance) throws NoSuchFieldException,
//            IllegalAccessException {
//        if (TableAttributeRelation.littleThanQueryList.contains(fieldName) || TableAttributeRelation.lagerThanQueryList.contains(fieldName)) {
//            Optional<Pair<String, String>> optionalPair = TableAttributeRelation.betweenList.stream()
//                    .filter(pair -> pair.getLeft().equals(fieldName) || pair.getRight().equals(fieldName))
//                    .findFirst();
//            if (!optionalPair.isPresent()) {
//                return StringUtils.EMPTY;
//            }
//            Field leftField = instance.getClass().getDeclaredField(optionalPair.get().getLeft());
//            leftField.setAccessible(true);
//            Field rightField = instance.getClass().getDeclaredField(optionalPair.get().getRight());
//            rightField.setAccessible(true);
//            Object leftVal = leftField.get(instance);
//            Object rightVal = rightField.get(instance);
//            if (leftVal != null && rightVal != null) {
//                return String.format(betweenSql, TableAttributeRelation.attributeColumnMap.get(fieldName), leftVal, rightVal);
//            }
//            if (leftVal == null && rightVal != null) {
//                return String.format(betweenWithoutStartSql, TableAttributeRelation.attributeColumnMap.get(fieldName), rightVal);
//            }
//            if (leftVal != null) {
//                return String.format(betweenWithoutEndSql, TableAttributeRelation.attributeColumnMap.get(fieldName), leftVal);
//            }
//        }
//        return StringUtils.EMPTY;
//    }

    private static final String inSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY WHERE label_type = '%s' " +
            "AND " +
            "label_info IN %s";
    private static final String betweenSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY WHERE " +
            "label_type = '%s' AND " +
            "labe_info >= '%s' AND labe_info <= '%s'";
    private static final String betweenWithoutEndSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE label_type " +
            "= '%s' AND labe_info >= '%s'";
    private static final String betweenWithoutStartSql = "SELECT SUM(user_cnt) FROM BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE " +
            "label_type ='%s' AND labe_info <= '%s'";

}
