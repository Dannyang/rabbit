package com.example.rabbit.mapper;

import com.example.rabbit.entity.ProductReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductReq> getAll();
}
