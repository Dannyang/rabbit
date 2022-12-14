package com.example.rabbit.util;

import site.lizhivscaomei.libs.tree.entity.TreeSourceNode;

import java.util.ArrayList;
import java.util.List;

public class MyTreeHelper {
    public static <T extends TreeSourceNode> List<MyTreeDestNode<T>> convert(List<T> sourceNodeList) {
        List<MyTreeDestNode<T>> destNodeList = new ArrayList<>();
        //第一步，找出第一级的节点
        //1.1 统计所有节点的id
        List<String> allIds = new ArrayList<String>();
        for (T sourceNode : sourceNodeList) {
            allIds.add(sourceNode.getId());
        }
        //所有父节点找不到对应的都是一级id
        for (T sourceNode : sourceNodeList) {
            if (!allIds.contains(sourceNode.getParentId())) {
                //从每个一级节点，递归查找children
                MyTreeDestNode<T> destNode = new MyTreeDestNode<T>();
                destNode.setId(sourceNode.getId());
                destNode.setName(sourceNode.getName());
                List<MyTreeDestNode<T>> myChilds = getChilderen(sourceNodeList, destNode);
                destNode.setChildren(myChilds.isEmpty() ? null : myChilds);
                destNodeList.add(destNode);
            }
        }
        return destNodeList;
    }

    //    递归获取子节点
    private static <T extends TreeSourceNode> List<MyTreeDestNode<T>> getChilderen(List<T> sourceNodeList, MyTreeDestNode<T> parentNode) {
        List<MyTreeDestNode<T>> childrenList = new ArrayList<>();
        for (T sourceNode : sourceNodeList) {
            if (sourceNode.getParentId().equals(parentNode.getId())) {
                MyTreeDestNode<T> children = new MyTreeDestNode<T>();
                children.setId(sourceNode.getId());
                children.setName(sourceNode.getName());
                List<MyTreeDestNode<T>> myChilds = getChilderen(sourceNodeList, children);
                children.setChildren(myChilds.isEmpty() ? null : myChilds);
                childrenList.add(children);
            }
        }
        return childrenList;
    }
}
