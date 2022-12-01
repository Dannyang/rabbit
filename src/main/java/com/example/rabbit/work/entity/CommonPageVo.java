package com.example.rabbit.work.entity;

import java.util.List;
import java.util.Map;

public class CommonPageVo<T> {
    //当前页
    private Integer currentPage;
    // 总数
    private Integer totalNumber;
    // 列表
    private List<T> list;
    // 其他数据
    private Map<String,Object> map;

    public CommonPageVo() {

    }

    public CommonPageVo(Integer totalNumber, List<T> list) {
        this.totalNumber = totalNumber;
        this.list = list;
    }

    public CommonPageVo(Integer totalNumber, List<T> list, Map<String, Object> map) {
        this.totalNumber = totalNumber;
        this.list = list;
        this.map = map;
    }
    public CommonPageVo(Integer currentPage,Integer totalNumber, List<T> list) {
        this.currentPage =currentPage;
        this.totalNumber = totalNumber;
        this.list = list;
    }
}
