package com.example.rabbit.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.io.Files;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class FileBusinessTypeTest {
    public static void main(String[] args) {
        List<CustomVarietyVo> productionVos = buildCustomVarietyVo();
        String s = JSON.toJSONString(productionVos);
        System.out.println(productionVos.size());
        try {
            Files.write(s.getBytes(StandardCharsets.UTF_8), new File("F:\\guava\\formatProduction.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private static String readFile() {
        try {
            List<String> stringList = Files.readLines(new File("F:\\guava\\listAllPage.txt"), StandardCharsets.UTF_8);
            return String.join(StringUtils.EMPTY, stringList);
        } catch (IOException e) {
            return StringUtils.EMPTY;
        }
    }

    private static List<CustomVarietyVo> buildCustomVarietyVo() {
        System.out.println(readFile());
        List<ProductionVo> productionList = JSON.parseArray(readFile(), ProductionVo.class);
        List<CustomVarietyVo> customVarietyVos = productionList.stream().map(FileBusinessTypeTest::getCustomVarietyVo).collect(Collectors.toList());
        // 父页面是0的都是一级页面
        List<CustomVarietyVo> parents =
                productionList.stream()
                        .filter(production -> production.getParentId() == 0)
                        .map(FileBusinessTypeTest::getCustomVarietyVo)
                        .collect(Collectors.toList());
        setVo(customVarietyVos, parents);
        return parents;


    }

    private static CustomVarietyVo getCustomVarietyVo(ProductionVo vo) {
        return CustomVarietyVo.builder().varietyCode(vo.getId()).parentVarietyCode(vo.getParentId()).varietyName(vo.getPageName()).build();
    }

    private static void setVo(List<CustomVarietyVo> all, List<CustomVarietyVo> parents) {
        parents.forEach(parent -> {
            List<CustomVarietyVo> childList =
                    all.stream().filter(child -> child.getParentVarietyCode().equals(parent.getVarietyCode())).collect(Collectors.toList());
            parent.setCustomVarietyVoList(childList);
            if (CollectionUtils.isNotEmpty(childList)) {
                setVo(all, childList);
            }
        });
    }
}
