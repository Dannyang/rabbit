package com.example.rabbit.config.test;

import com.example.rabbit.entity.BehaviorCharacteristics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<BehaviorCharacteristics> list1 = new ArrayList<>();
        List<BehaviorCharacteristics> list2 = new ArrayList<>();
        List<BehaviorCharacteristics> list3 = new ArrayList<>();
        List<List<BehaviorCharacteristics>> r = new ArrayList<>();
        BehaviorCharacteristics behaviorCharacteristic = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics1 = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics001 = new BehaviorCharacteristics();
        behaviorCharacteristic.setMinAttendTimes(1);
        behaviorCharacteristics1.setMinAttendTimes(2);
        behaviorCharacteristics001.setMinAttendTimes(11);
        list1.add(behaviorCharacteristic);
        list1.add(behaviorCharacteristics1);
        list1.add(behaviorCharacteristics001);

        BehaviorCharacteristics behaviorCharacteristic3 = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics4 = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics002 = new BehaviorCharacteristics();
        behaviorCharacteristic3.setMinAttendTimes(1);
        behaviorCharacteristics4.setMinAttendTimes(3);
        behaviorCharacteristics002.setMinAttendTimes(11);
        list2.add(behaviorCharacteristic3);
        list2.add(behaviorCharacteristics4);
        list2.add(behaviorCharacteristics002);


        BehaviorCharacteristics behaviorCharacteristic4 = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics5 = new BehaviorCharacteristics();
        BehaviorCharacteristics behaviorCharacteristics003 = new BehaviorCharacteristics();
        behaviorCharacteristic4.setMinAttendTimes(1);
        behaviorCharacteristics5.setMinAttendTimes(4);
        behaviorCharacteristics003.setMinAttendTimes(11);
        list3.add(behaviorCharacteristic4);
        list3.add(behaviorCharacteristics5);
        list3.add(behaviorCharacteristics003);
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
        r.add(list1);
        r.add(list2);
        r.add(list3);
        List<BehaviorCharacteristics> intersection = getIntersection(list1, list2);
        List<BehaviorCharacteristics> intersection1 = getIntersection(intersection, list3);
        List<BehaviorCharacteristics> behaviorCharacteristics = r.stream().reduce(Test1::getIntersection).orElse(new ArrayList<>());
        System.out.println(behaviorCharacteristics.size());
        System.out.println("添加完成");
        long t = System.currentTimeMillis();

        System.out.println(r.size());
        System.out.println(System.currentTimeMillis() - t);
    }

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
}
