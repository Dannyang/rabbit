package com.example.rabbit.mapper;

import com.example.rabbit.entity.ProductReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductReq> getAll();

    ProductReq getOne(String id);

    void batchInsert(@Param("productReqList") List<ProductReq> productReqList);

    List<ProductReq> getOneTest(List<Long> id);
}
