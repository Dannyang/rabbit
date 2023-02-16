package com.example.rabbit.config.test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CaffeineTest {
    public static void main(String[] args) {
        String a = "aaa";
        String str = "//mgr.mysteelcms.com/mgr-web/article/add.ms?channelId=4604&informationUnitId=501&selectTime=1675958400000";
        System.out.println(a +str.replace("//mgr.mysteelcms.com", StringUtils.EMPTY));
//        testSemaphore();
//        String s = "你shizhen特么牛逼";
//        try {
//            Files.write(Paths.get("D:\\software\\VistaNewPath.txt"), s.getBytes(StandardCharsets.UTF_8),
//                    StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Cache<String, String> build = Caffeine.newBuilder().build();
//        build.put("1","2");
//        CaffeineTest caffeineTest = new CaffeineTest();
//        try {
//            caffeineTest.testRateLimiter();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void testRateLimiter() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(3);
        for (int i = 0; i < 10; i++) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
            System.out.println(time + ":" + rateLimiter.tryAcquire());
            Thread.sleep(250);
        }
    }

    private static void testSemaphore() {
        String[] strings = new String[]{};
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());
        List<StringBuilder> list = Lists.newArrayList(new StringBuilder("1"), new StringBuilder("2"), new StringBuilder("3"));
        StopWatch started = StopWatch.createStarted();
        List<CompletableFuture<String>> collect1 = list.stream().map(s -> CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                s.append(s);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return s.toString();
        }, threadPoolExecutor)).collect(Collectors.toList());
        CompletableFuture[] completableFutures = collect1.toArray(new CompletableFuture[]{});
        CompletableFuture.allOf(completableFutures).join();
        String collect = list.stream().map(StringBuilder::toString).collect(Collectors.joining("\n"));
        System.out.println("costs " + started.getTime(TimeUnit.SECONDS));
        System.out.println(collect);
    }
}
