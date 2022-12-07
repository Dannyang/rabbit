package com.example.rabbit.guava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recursion<T>  {
    private Integer id;
    private Integer parentId;
    private List<Recursion<T>> children;
}
