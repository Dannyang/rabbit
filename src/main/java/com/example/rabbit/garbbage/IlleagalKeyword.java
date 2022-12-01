package com.example.rabbit.garbbage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.rabbit.entity.CheckResponseVo;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class IlleagalKeyword {
    private static final String ARTICLE_ILLEGAL_KEYWORD_REDIS_KEY = "BNJZ_ARTICLE_ILLEGAL_KEYWORD_%S";

    public static void main(String[] args) {
//        String s = UUID.randomUUID().toString();
//        System.out.println(String.format(ARTICLE_ILLEGAL_KEYWORD_REDIS_KEY, s)); ;

//         final Map<Integer, String> taskStatusMap = ImmutableMap.<Integer, String>builder()
//                .put(0, "待审核")
//                .put(1, "已通过")
//                .put(2, "已拒绝")
//                .build();
//        System.out.println(taskStatusMap.get(1));
//        String data = "发布";
//
//        if (data.indexOf("禁止发布") != -1) {
//            System.out.println("禁止发布");
//        } else if (!"".equals(data)){
//            System.out.println("发布");
//        } else {
//            System.out.println("!!");
//        }
//        String string = "{serialId=da7d5ece3c88196c06b14654c214b9be, action=2, actionMsg=不通过, label=400, labelMsg=违禁," +
//                " level=2, levelMsg=确定}";
//
//        CheckResponseVo checkResponseVo = JSON.parseObject(string, CheckResponseVo.class);
//        System.out.println(checkResponseVo);
        System.out.println(queryForYiDunWords());
    }


    private static String queryForYiDunWords() {
        try {
            int i = 1/0;
           return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }

}
