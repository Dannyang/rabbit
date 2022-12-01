package com.example.rabbit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CheckResponseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serialId;

    private Integer action;

    private String actionMsg;

    private Integer label;

    private String labelMsg;

    private Integer level;

    private String levelMsg;

    private List<String> hint;


}
