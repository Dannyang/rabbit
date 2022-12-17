package com.example.rabbit.config.test;

public class PostDeal2 extends PostDeal {
    String inQuerySql = "SELECT user_id, phone_number FROM %s WHERE %s IN %s";
    String betweenQuerySql = "SELECT user_id, phone_number FROM %s WHERE %s BETWEEN %s AND %s";
    String betweenQuerySqlWithoutEnd = "SELECT user_id, phone_number FROM %s WHERE %s >= %s";
    String betweenQuerySqlWithoutStart = "SELECT user_id, phone_number FROM %s WHERE %s <= %s";

    private static final String union = "UNION ALL ";

    public PostDeal2(StringBuilder stringBuilder) {
        super(stringBuilder);
    }


    @Override
    <T> void postSet(String tagKey, String tagName, String listVal, T leftVal, T rightVal) {
        if (TableAttributeRelation.betweenTag.contains(tagKey)) {
            this.getSql().append(union).append(getRangeCountSql(leftVal, rightVal, tagKey));
            return;
        }
        this.getSql().append(union).append(getInQuerySql(listVal, tagKey));

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
        return String.format(betweenQuerySqlWithoutEnd,
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getLeft(),
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getRight(),
                start);
    }

    private String getCountWithoutStart(String end, String fieldName) {
        return String.format(betweenQuerySqlWithoutStart, TableAttributeRelation.tagKeyTableMap.get(fieldName).getLeft(),
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getRight(),
                end);
    }

    private String getCount(String start, String end, String fieldName) {
        return String.format(betweenQuerySql, TableAttributeRelation.tagKeyTableMap.get(fieldName).getLeft(),
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getRight(), start
                , end);
    }

    private String getInQuerySql(String val, String fieldName) {
        return String.format(inQuerySql,
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getLeft(),
                TableAttributeRelation.tagKeyTableMap.get(fieldName).getRight(), val);

    }


}
