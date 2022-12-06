package com.example.rabbit.guava;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "定制品种实体类")
public class CustomVarietyVo {
    @ApiModelProperty(value = "定制品种名称", name = "varietyName")
    private String varietyName;
    @ApiModelProperty(value = "定制品种编码", name = "varietyCode")
    private Integer varietyCode;
    @ApiModelProperty(value = "定制品种父编码", name = "varietyCode")
    private Integer parentVarietyCode;
    @ApiModelProperty(value = "定制品树", name = "customVarietyVoList")
    List<CustomVarietyVo> customVarietyVoList;
}
