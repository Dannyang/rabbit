package com.example.rabbit.config.test;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataServiceQuery {
    private final List<Param> params = new ArrayList<>();
    private final StringBuilder sqlBuilder = new StringBuilder();


    public DataServiceQuery sql(String sql) {
        sqlBuilder.append(sql);
        return this;
    }

    public DataServiceQuery param(Param param) {
        this.params.add(param);
        return this;
    }

    public String parse() {
        if (CollectionUtils.isEmpty(params)) {
            return sqlBuilder.toString();
        }
//        sqlBuilder.append(StringUtils.SPACE).append("WHERE").append(StringUtils.SPACE);
        for (int i = 0; i < params.size(); i++) {
            if (Objects.isNull(params.get(i).getValue())) {
                continue;
            }
            sqlBuilder.append(params.get(i).getCode()).append(StringUtils.SPACE).append(params.get(i).getOperation()).append(StringUtils.SPACE);
            if (SqlOperationEnum.IN.getOperation().equals(params.get(i).getOperation())) {
                String strVal = String.valueOf(params.get(i).getValue());
                String paramVal = Arrays.stream(strVal.split(",")).map(a -> "'".concat(a).concat("'")).collect(Collectors.joining(","));
                sqlBuilder.append("(").append(paramVal).append(")");
            } else {
                sqlBuilder.append(params.get(i).getValue());
            }
            sqlBuilder.append(StringUtils.SPACE);
            if (i != params.size() - 1) {
                sqlBuilder.append("AND").append(StringUtils.SPACE);
            }
        }
        return sqlBuilder.toString();
    }

}
