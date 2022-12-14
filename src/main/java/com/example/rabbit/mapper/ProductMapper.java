package com.example.rabbit.mapper;

import com.example.rabbit.entity.ProductReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductReq> getAll();

    void batchInsert(@Param("productReqList") List<ProductReq> productReqList);
}
