package com.example.rabbit.config.test;


import java.util.Arrays;
import java.util.List;

public class PostDeal1 extends PostDeal {
    private static final String union = "UNION ALL ";
    private static final List<String> forIdTags = Arrays.asList("businessType", "customizationType", "customizationColumn");

    public PostDeal1(StringBuilder stringBuilder) {
        super(stringBuilder);
    }


    @Override
    <T> void postSet(String tagKey, String tagName, List<T> listVal, T leftVal, T rightVal) {
        if (TableAttributeRelation.betweenTag.contains(tagKey)) {
            this.getSqlBuilder().append(union).append(getRangeCountSql(leftVal, rightVal, tagKey));
            return;
        }
        if (forIdTags.contains(tagKey)) {
            this.getSqlBuilder().append(union).append(getCountForId(listVal, tagKey));
            return;
        }
        this.getSqlBuilder().append(union).append(getCountForInfo(listVal, tagKey));

    }

    private <T> String getRangeCountSql(T left, T right, String tagKey) {
        StringBuilder sql = new StringBuilder();
        if (left != null && right != null) {
            sql.append(getCount(String.valueOf(left), String.valueOf(right), tagKey));
        }
        if (left != null && right == null) {
            sql.append(getCountWithoutEnd(String.valueOf(left), tagKey));
        }
        if (left == null && right != null) {
            sql.append(getCountWithoutStart(String.valueOf(right), tagKey));
        }
        return sql.toString();
    }

    private String getCountWithoutEnd(String start, String fieldName) {
        return String.format(DataTableConstant.betweenWithoutEndSql, TableAttributeRelation.attributeColumnMap.get(fieldName),
                start);
    }

    private String getCountWithoutStart(String end, String fieldName) {
        return String.format(DataTableConstant.betweenWithoutStartSql, TableAttributeRelation.attributeColumnMap.get(fieldName),
                end);
    }

    private String getCount(String start, String end, String fieldName) {
        return String.format(DataTableConstant.betweenSql, TableAttributeRelation.attributeColumnMap.get(fieldName), start
                , end);
    }

    private <T>String getCountForInfo(List<T> listVal, String tagKey) {
        //todo listVal值转化
        String content = "";
        String strVal = getListVal(listVal);
        return String.format(DataTableConstant.inSqlForInfo, tagKey, content,
                TableAttributeRelation.attributeColumnMap.get(tagKey), strVal);

    }

    private <T>String getCountForId(List<T> val, String fieldName) {
        return String.format(DataTableConstant.inSqlForId, TableAttributeRelation.attributeColumnMap.get(fieldName), val);

    }
}
