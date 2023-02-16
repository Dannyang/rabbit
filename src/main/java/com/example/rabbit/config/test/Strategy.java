package com.example.rabbit.config.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Strategy {
    static Map<Integer, TestInterface> map = new HashMap<>();
    static Map<Integer, Function<String, String>> map1 = new HashMap<>();

    static TestInterface t1() {
        return (s1, s2) -> s1.concat("+1+").concat(s2);
    }

    static Function<String, String> f1() {
        return s1 -> s1.concat("f1");
    }

    static Function<String, String> f2() {
        return s -> s.concat("f2");
    }

    static Function<String, String> f3() {
        return s -> s.concat("f3");
    }

    static TestInterface t2() {
        return (s1, s2) -> s1.concat("+2+").concat(s2);
    }

    static TestInterface t3() {
        return (s1, s2) -> s1.concat("+3+").concat(s2);
    }

    static {
        map.put(1, t1());
        map.put(2, t2());
        map.put(3, t3());
        map1.put(1, f1());
        map1.put(2, f2());
        map1.put(3, f3());
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("12.000000000000000000001");
        BigDecimal bigDecimal2 = new BigDecimal("12.000000000000000000000002");
        BigDecimal add = bigDecimal1.add(bigDecimal2);
        System.out.println(add.abs());
//        String nima = map.get(3).test("nima1", "nima2");
//        String nima1 = map1.get(2).apply("nima");
//        System.out.println(nima);
//        System.out.println(nima1);
    }

}
