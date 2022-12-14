package com.example.rabbit.service;

import com.example.rabbit.entity.ProductReq;
import com.example.rabbit.entity.ProductRsp;
import com.example.rabbit.mapper.ProductMapper;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final SqlSessionTemplate sqlSessionTemplate;


    public ProductService(ProductMapper productMapper, SqlSessionTemplate sqlSessionTemplate) {
        this.productMapper = productMapper;
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void batchInsert() {
        int i = 0;
        List<ProductReq> list = Lists.newArrayList();
        while (i < 3*1000*1000) {
            String uuId = UUID.randomUUID().toString();
            ProductReq productReq = new ProductReq();
            productReq.setLevel("2");
            productReq.setName("什么名字");
            productReq.setUuid(uuId);
            productReq.setParentUuid("4dbf40d2-2af7-425c-a103-0349caaa26cf");
            productReq.setSort(2);
            list.add(productReq);
            i++;
        }
//        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try {
//            long t1 = System.currentTimeMillis();
//            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            List<List<ProductReq>> partition = Lists.partition(list, 10000);
            for (List<ProductReq> reqList : partition) {
                productMapper.batchInsert(reqList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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


    public ProductReq getRootProduct(String leafUuid) {
        List<ProductReq> productMapperAll = productMapper.getAll();
        ProductReq theProduct = productMapperAll.stream()
                .filter(product -> leafUuid.equals(product.getUuid()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("cannot find the product"));
        return findTheRoot(productMapperAll, theProduct);
    }

    private static ProductReq findTheRoot(List<ProductReq> all, ProductReq child) {
        Optional<ProductReq> productReq = all.stream().filter(parent -> child.getParentUuid().equals(parent.getUuid())).findFirst();
        // 如果已经不能再往上找到则当前节点为根节点
        if (!productReq.isPresent()) {
            return child;
        }
        // 如果存在再接着往上找知道找不到父节点为止
        return findTheRoot(all, productReq.get());
    }

    /**
     * 1.筛选出根节点
     *
     * @param all
     * @param parentUuid
     * @return
     */
    private static List<ProductRsp> buildTree(List<ProductRsp> all, String parentUuid) {
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
            // 直到没有找到归属于下属节点的列表为止
            if (CollectionUtils.isNotEmpty(children)) {
                getSubList(children, all);
            }
        });
    }

}

