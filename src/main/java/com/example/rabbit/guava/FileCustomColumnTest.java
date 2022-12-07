//package com.example.rabbit.guava;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.Lists;
//import com.google.common.io.Files;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class FileCustomColumnTest {
//    public static void main(String[] args) {
//        File directory = new File("");
//        try {
//            System.out.println(directory.getCanonicalPath());
//            System.out.println(directory.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<Column> columnList = readFile(Column.class, "F:\\guava\\listEnablePageColumn.txt");
//        List<Production> customVarietyVos = readFile(Production.class, "F:\\guava\\listAllPage.txt");
//        List<CustomColumnVo> initialList = getCustomVarietyVo(columnList, customVarietyVos);
//        List<CustomColumnVo> finalList = buildCustomColumnVo(initialList);
//        System.out.println(finalList.size());
//    }
//
//    private static <T> List<T> readFile(Class<T> clazz, String filePath) {
//        try {
//            List<String> stringList = Files.readLines(new File(filePath), StandardCharsets.UTF_8);
//            String join = String.join(StringUtils.EMPTY, stringList);
//            return JSON.parseArray(join, clazz);
//        } catch (IOException e) {
//            return Lists.newArrayList();
//        }
//    }
//
//
//    private static List<CustomColumnVo> getCustomVarietyVo(List<Column> columnList, List<Production> productions) {
//        Map<Integer, List<ColumnVo>> pageColumnMap = columnList.stream()
//                .map(FileCustomColumnTest::buildColumnVo)
//                .collect(Collectors.groupingBy(ColumnVo::getPageId));
//        // 头条和禁用的不展示
//        return productions.stream()
//                .filter(production -> (production.getPageShow() && !production.getHomePage()))
//                .map(production -> buildCustomColumnVo(pageColumnMap, production))
//                .collect(Collectors.toList());
//    }
//
//    private static CustomColumnVo buildCustomColumnVo(Map<Integer, List<ColumnVo>> pageColumnMap, Production production) {
//        CustomColumnVo.CustomColumnVoBuilder builder = CustomColumnVo.builder()
//                .varietyCode(production.getId())
//                .varietyName(production.getPageName())
//                .parentVarietyCode(production.getParentId());
//        List<ColumnVo> columns = pageColumnMap.get(production.getId());
//        if (CollectionUtils.isNotEmpty(columns)) {
//            builder.columnVos(columns);
//        }
//        return builder.build();
//    }
//
//    private static ColumnVo buildColumnVo(Column column) {
//        return ColumnVo.builder()
//                .columnName(column.getColumnName())
//                .id(column.getId())
//                .pageId(column.getPageId())
//                .buriedId(column.getBuriedId())
//                .build();
//    }
//
//    private static List<CustomColumnVo> buildCustomColumnVo(List<CustomColumnVo> all) {
//
//        // 父页面是0的都是一级页面
//        List<CustomColumnVo> parents = all.stream()
//                .filter(production -> production.getParentVarietyCode() == 0)
//                .collect(Collectors.toList());
//        setVo(all, parents);
//        return parents;
//
//
//    }
//
//
//    private static void setVo(List<CustomColumnVo> all, List<CustomColumnVo> parents) {
//        parents.forEach(parent -> {
//            List<CustomColumnVo> childList = all.stream()
//                    .filter(child -> child.getParentVarietyCode().equals(parent.getVarietyCode()))
//                    .collect(Collectors.toList());
//            parent.setChildren(childList);
//            if (CollectionUtils.isNotEmpty(childList)) {
//                setVo(all, childList);
//            }
//        });
//    }
//}
