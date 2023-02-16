package com.example.rabbit.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("任务数量实体")
public class TaskCountDescDTO implements Serializable {
    private static final long serialVersionUID = -5818623822403856163L;
    @ApiModelProperty(value = "任务数量描述", name = "taskCountDesc", example = "待我处理任务")
    private String taskCountDesc;
    @ApiModelProperty(value = "任务数量", name = "taskCount", example = "100")
    private String taskCount;
}
