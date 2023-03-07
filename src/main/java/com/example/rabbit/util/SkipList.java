package com.example.rabbit.util;

import java.util.Random;

public class SkipList<T> {
    // 头结点
    SkipNode<T> head;
    //当前索引层数
    int highLevel;
    Random random;// 用于投掷硬币
    final int MAX_LEVEL = 32;//最大的层

    SkipList(){
        random=new Random();
        head=new SkipNode<T>(Integer.MIN_VALUE,null);
        highLevel=0;
    }
    //其他方法
    // head -----> node -----> node ------> node
    //  |           |           |            |
    //  |           |           |            |
    //  node->node->node->node->node->node->node
    SkipNode<T> get(int key){
        while (head != null){
            // 从头开始往右查找
            if (head.key == key){
                return head;
            }
            //  先从头开始往右查找
            if(head.right != null && head.right.key > key){
                head = head.right;
                // 右边没有节点了或者右边的节点大于所找key开始往下找
            }else {
                head = head.down;
            }
        }
        return null;
    }
}
