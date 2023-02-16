package com.example.rabbit.entity;

import lombok.Data;

import java.util.List;

@Data
public class Condition {
    private Long adminId;
    private List<Long> adminList;
    private Integer adminFlag;
}
