package com.example.rabbit.util;

import lombok.Data;

/***
 * 节点
 * @ClassName Node
 * @Author xiaowd
 * @DateTime 2020/1/31 15:37
 */
@Data
public class Node extends TreeDot {

    /**
     * 节点编码
     */
    private Integer nodeId;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 父节点编码
     */
    private Integer parentNodeId;
    /**
     * 创建时间
     */
    private Long time;

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
        super.setId(String.valueOf(nodeId));
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
        super.setTitle(nodeName);
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
        super.setParentId(String.valueOf(parentNodeId));
    }

    public void setTime(Long time) {
        this.time = time;
        super.getAttributes().put("time",time);
    }

}