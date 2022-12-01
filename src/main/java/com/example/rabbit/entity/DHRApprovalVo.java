package com.example.rabbit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DHRApprovalVo implements Serializable {
    /**
     * 材料审核状态1通过,0拒绝
     */
    private Integer approvalStatus;
    /**
     * 业务ID
     */
    private List<String> businessIds;
}
