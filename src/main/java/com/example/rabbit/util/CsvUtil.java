package com.example.rabbit.util;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CsvUtil {
    public static void main(String[] args) {
        List<String> o = readFile("F:\\guava\\老爬虫.csv");
        List<String> n = readFile("F:\\guava\\新.csv");
        o.addAll(n);
        List<String> id = o.stream().filter(s -> !s.equals("'id'")).collect(Collectors.toList());
        System.out.println(id.size());
    }

    private static List<String> readFile(String filePath) {
        try {
            return Files.readLines(new File(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return Lists.newArrayList();
        }
    }

}
