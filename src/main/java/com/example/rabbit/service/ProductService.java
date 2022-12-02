package com.example.rabbit.service;

import com.example.rabbit.entity.ProductReq;
import com.example.rabbit.entity.ProductRsp;
import com.example.rabbit.mapper.ProductMapper;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductMapper productMapper;


    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;

    }

    public List<ProductRsp> productTree() {
        List<ProductReq> productMapperAll = productMapper.getAll();
        List<ProductRsp> productRsps = productMapperAll.stream().map(req -> {
            ProductRsp productRsp = new ProductRsp();
            try {
                BeanUtils.copyProperties(productRsp, req);
                return productRsp;
            } catch (IllegalAccessException | InvocationTargetException e) {
                return new ProductRsp();
            }
        }).collect(Collectors.toList());
        // 数据库中存的父节点parentUuid为-1
        return buildTree(productRsps, "-1");
    }


    /**
     * 1.筛选出根节点
     *
     * @param all
     * @param parentUuid
     * @return
     */
    public static List<ProductRsp> buildTree(List<ProductRsp> all, String parentUuid) {
        if (CollectionUtils.isEmpty(all))
            return Lists.newArrayList();

        List<ProductRsp> parentList = all.stream()
                .filter(e -> StringUtils.isBlank(e.getParentUuid())
                        || "-1".equals(e.getParentUuid())
                        || e.getParentUuid().equals(parentUuid))
                .collect(Collectors.toList());

        getSubList(parentList, all);

        return parentList;
    }

    private static void getSubList(List<ProductRsp> parentList, List<ProductRsp> all) {

        // 每个父节点循环设置子节点
        parentList.forEach(parent -> {
            List<ProductRsp> children = all.stream().filter(child -> child.getParentUuid().equals(parent.getUuid())).collect(Collectors.toList());
            parent.setSubList(children);
            // 直到没有找到归属于父节点的列表为止
            if (CollectionUtils.isNotEmpty(children)) {
                getSubList(children, all);
            }
        });
    }

}

