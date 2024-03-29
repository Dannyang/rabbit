package com.example.rabbit;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.entity.Entity;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Rubbish {
    public static String dateToStamp(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime());
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        }else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time);
        }
        return stamp;
    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time));
        return time_Date;

    }

    public static void main(String[] args) {
            String time1 = "2022-12-09 00:00:00";
//        Long time2 = 1669600187869L;
//        System.out.println("将时间转为时间戳："+dateToStamp(time1));
//        System.out.println("将时间戳转为时间："+stampToDate(1669611600000L));
        String str = "今天有新员工入职，请及时处理！<br>员工名单：新员工入职01、新员工入职03、新员工入职02";
        String[] split = str.split("<br>");
        System.out.println(split[1].contains("05"));
    }

//    public static void main(String[] args) {
////        IlleagalKeyword
////        StringBuilder stringBuilder = new StringBuilder("contractApprovalTask");
////        System.out.println(stringBuilder.toString());
////        System.out.println(StringUtils.EMPTY.equals(stringBuilder.toString()));
////        Entity contractApprovalTask = JSON.parseObject(stringBuilder.toString(), Entity.class);
////        System.out.println(contractApprovalTask);
//
//        Date date = new Date(1669615208719L);
//        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleFormatter.format(date);
//        System.out.println(format);
//
//
//
//
//    }
}
