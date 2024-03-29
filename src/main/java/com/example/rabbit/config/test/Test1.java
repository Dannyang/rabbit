package com.example.rabbit.config.test;

import com.example.rabbit.aspect.Monitor;
import com.example.rabbit.entity.BehaviorCharacteristics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        date();
//        List<BehaviorCharacteristics> list1 = new ArrayList<>();
//        List<BehaviorCharacteristics> list2 = new ArrayList<>();
//        List<BehaviorCharacteristics> list3 = new ArrayList<>();
//        List<List<BehaviorCharacteristics>> r = new ArrayList<>();
//        BehaviorCharacteristics behaviorCharacteristic = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics1 = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics001 = new BehaviorCharacteristics();
//        behaviorCharacteristic.setMinAttendTimes(1);
//        behaviorCharacteristics1.setMinAttendTimes(2);
//        behaviorCharacteristics001.setMinAttendTimes(11);
//        list1.add(behaviorCharacteristic);
//        list1.add(behaviorCharacteristics1);
//        list1.add(behaviorCharacteristics001);
//
//        BehaviorCharacteristics behaviorCharacteristic3 = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics4 = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics002 = new BehaviorCharacteristics();
//        behaviorCharacteristic3.setMinAttendTimes(1);
//        behaviorCharacteristics4.setMinAttendTimes(3);
//        behaviorCharacteristics002.setMinAttendTimes(11);
//        list2.add(behaviorCharacteristic3);
//        list2.add(behaviorCharacteristics4);
//        list2.add(behaviorCharacteristics002);
//
//
//        BehaviorCharacteristics behaviorCharacteristic4 = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics5 = new BehaviorCharacteristics();
//        BehaviorCharacteristics behaviorCharacteristics003 = new BehaviorCharacteristics();
//        behaviorCharacteristic4.setMinAttendTimes(1);
//        behaviorCharacteristics5.setMinAttendTimes(4);
//        behaviorCharacteristics003.setMinAttendTimes(11);
//        list3.add(behaviorCharacteristic4);
//        list3.add(behaviorCharacteristics5);
//        list3.add(behaviorCharacteristics003);
//        for (int i = 0; i < 30000; i++) {
//            BehaviorCharacteristics behaviorCharacteristics0 = new BehaviorCharacteristics();
//            behaviorCharacteristics0.setMinAttendTimes(i);
//            list1.add(behaviorCharacteristics0);
//
//            BehaviorCharacteristics behaviorCharacteristics1 = new BehaviorCharacteristics();
//            behaviorCharacteristics0.setMinAttendTimes((i + 1));
//            list2.add(behaviorCharacteristics1);
//
//            BehaviorCharacteristics behaviorCharacteristics2 = new BehaviorCharacteristics();
//            behaviorCharacteristics0.setMinAttendTimes((i + 2));
//            list3.add(behaviorCharacteristics2);
//        }
//        r.add(list1);
//        r.add(list2);
//        r.add(list3);
//        List<BehaviorCharacteristics> intersection1 = getIntersection(intersection, list3);
//        StopWatch stopWatch = StopWatch.createStarted();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        List<BehaviorCharacteristics> behaviorCharacteristics = r.stream().reduce(Test1::getIntersection).orElse(new ArrayList<>());
//        stopWatch.stop();
//        System.out.println(behaviorCharacteristics.size());
//        System.out.println(behaviorCharacteristics.size());
//        System.out.println("添加完成");
//        System.out.println(r.size());
//        Pair<String, String> pair = new MutablePair<>("1","2");
//        System.out.println(pair.getRight());
//        pair.setValue("3");
//        System.out.println(pair.getRight());
    }

    @Monitor(tagKey = "haha")
    private static List<BehaviorCharacteristics> getIntersection(List<BehaviorCharacteristics> src,
                                                                 List<BehaviorCharacteristics> dest) {
        List<BehaviorCharacteristics> r = new ArrayList<>();
        Map<Integer, BehaviorCharacteristics> map1 =
                src.stream().collect(Collectors.toMap(BehaviorCharacteristics::getMinAttendTimes, Function.identity()
                        , (k1, k2) -> k1));
        dest.forEach(s -> {
            BehaviorCharacteristics ss = map1.get(s.getMinAttendTimes());
            if (ss != null) {
                r.add(ss);
            }
        });
        return r;
    }


    // distinct by property of element in a list
    public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static void date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse1 = simpleDateFormat.parse("2022-01-01 00:00:00");
            Date parse2 = simpleDateFormat.parse("2023-01-01 00:00:00");
            System.out.println(parse1.getTime());
            System.out.println(parse2.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
