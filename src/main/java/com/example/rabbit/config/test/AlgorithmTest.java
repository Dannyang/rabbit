package com.example.rabbit.config.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AlgorithmTest {
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100));
    private final BlockingDeque<List<String>> queue = new LinkedBlockingDeque<>();
    private final String[] strs = new String[]{"123", "456", "789", "987"};

    private boolean produceFlag = true;

    public static void main(String[] args) {
        AlgorithmTest algorithmTest = new AlgorithmTest();
        algorithmTest.produce();
        algorithmTest.consume();
    }

    public TestInterface getThreadPoolExecutor() {
        return System.out::println;
    }

    private void produce() {
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                queue.add(Lists.newArrayList(strs));
                System.out.println(queue.size());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 生产完成通知并更改
            produceFlag = false;
            System.out.println("production completed");
            // shutdown会释放interrupted信号并等待所有任务执行完成再关闭线程池
//            threadPoolExecutor.shutdown();
        });
    }

    private void consume() {
        threadPoolExecutor.execute(() -> {
            // 生产者已经生产完成并且消费队列不为空
            while (produceFlag) {
                while (!queue.isEmpty()) {
                    try {
                        Thread.sleep(1500L);
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            System.out.println("consumption completed");
        });
    }
}
