package com.example.rabbit.util;

import site.lizhivscaomei.libs.tree.entity.TreeSourceNode;

import java.util.List;

public class MyTreeDestNode<T extends TreeSourceNode> {
    //唯一标识
    private String id;
    //名称
    private String name;
    //子节点
    private List<MyTreeDestNode<T>> children;

    public List<MyTreeDestNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<MyTreeDestNode<T>> children) {
        this.children = children;
    }
//元数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
