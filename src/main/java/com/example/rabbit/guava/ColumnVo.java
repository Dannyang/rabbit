package com.example.rabbit.guava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColumnVo {
    private Integer pageId;
    private Integer id;
    private String columnName;
    private String buriedId;
}
