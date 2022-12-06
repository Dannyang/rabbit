package com.example.rabbit.guava;

import lombok.Data;

@Data
public class Column {
    private Integer pageId;
    private Integer id;
    private Integer columnType;
    private Integer priority;
    private String relationCode;
    private String endVersion;
    private String version;
    private String buriedId;
    private String columnName;
    private Long createTime;
}
