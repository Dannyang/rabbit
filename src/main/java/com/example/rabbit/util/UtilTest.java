package com.example.rabbit.util;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.guava.Production;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import site.lizhivscaomei.libs.tree.entity.TreeDestNode;
import site.lizhivscaomei.libs.tree.service.TreeHelper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    public static void main(String[] args) {
        List<Production> customVarietyVos = readFile(Production.class, "F:\\guava\\listAllPage.txt");
//        List<TreeDot<Production>> treeDots = TreeDotUtil.convertListToTreeDot(customVarietyVos);
//
        List<MyTreeDestNode<Production>> treeDestNodes = MyTreeHelper.convert(customVarietyVos);
        System.out.println(treeDestNodes.size());
        UtilTest utilTest = new UtilTest();
        List<TreeDot<Node>> tree = utilTest.tree();
        System.out.println(tree.size());
    }

    private static <T> List<T> readFile(Class<T> clazz, String filePath) {
        try {
            List<String> stringList = Files.readLines(new File(filePath), StandardCharsets.UTF_8);
            String join = String.join(StringUtils.EMPTY, stringList);
            return JSON.parseArray(join, clazz);
        } catch (IOException e) {
            return Lists.newArrayList();
        }
    }

    public List<TreeDot<Node>> tree(){
        //国节点 中国
        Node rootNode = new Node();
        rootNode.setNodeId(110000);
        rootNode.setNodeName("中国");
        rootNode.setParentNodeId(0);
        rootNode.setTime(System.currentTimeMillis());

        //省节点 广东
        Node pNode1 = new Node();
        pNode1.setNodeId(120000);
        pNode1.setNodeName("广东");
        pNode1.setParentNodeId(110000);
        pNode1.setTime(System.currentTimeMillis());

        //市节点 广州
        Node cNode1 = new Node();
        cNode1.setNodeId(120001);
        cNode1.setNodeName("广州");
        cNode1.setParentNodeId(120000);
        cNode1.setTime(System.currentTimeMillis());

        //区节点 广州
        Node aNode1 = new Node();
        aNode1.setNodeId(1200011);
        aNode1.setNodeName("天河区");
        aNode1.setParentNodeId(120001);
        aNode1.setTime(System.currentTimeMillis());

        //子节点 湖南
        Node pNode2 = new Node();
        pNode2.setNodeId(130000);
        pNode2.setNodeName("湖南");
        pNode2.setParentNodeId(110000);
        pNode2.setTime(System.currentTimeMillis());

        //市节点 长沙
        Node cNode2 = new Node();
        cNode2.setNodeId(130001);
        cNode2.setNodeName("长沙");
        cNode2.setParentNodeId(130000);
        cNode2.setTime(System.currentTimeMillis());

        //子节点 上海
        Node pNode3 = new Node();
        pNode3.setNodeId(140000);
        pNode3.setNodeName("上海");
        pNode3.setParentNodeId(110000);
        pNode3.setTime(System.currentTimeMillis());

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(rootNode);
        nodeList.add(pNode1);
        nodeList.add(cNode1);
        nodeList.add(aNode1);
        nodeList.add(pNode2);
        nodeList.add(cNode2);
        nodeList.add(pNode3);

        //转换

        return TreeDotUtil.convertListToTreeDot(nodeList);
    }
}
