package com.example.rabbit.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushMessageVO {

    private String title;                // 推送标题
    private String content;                // 推送内容

    private Long articleId;                // 文章ID
    private String articleUrl;            // 文章链接地址

    private String subCityId;            // 推送目标的所属城市，多个逗号分隔(预留)
    private String subCityName;            // 推送目标的所属城市，多个逗号分隔(预留)
    private String subBreedId;            // 推送目标的定制品种，多个逗号分隔
    private String subBreedName;        // 推送目标的定制品种，多个逗号分隔

    private Long createAdminId;            // 创建管理员ID
    private String createAdminName;        // 创建管理员名称
    private Long createTime;            // 创建时间

    private Long auditAdminId;            // 审核管理员ID
    private String auditAdminName;        // 审核管理员名称
    private Long auditTime;                // 审核时间

    private Integer type;                // 类型  0-系统通知 1-即时新闻
    private Integer status;                // 状态 0-待审核 1-审核通过 9-审核不通过 2-待推送 3-已推送

    private String firDepartMentName;    //创建人所属一级部门
    private String secDepartMentName;    //创建人所属二级部门

    private Integer totalReadCount;        //文章累积阅读量
    private String articleTitle;        //文章标题


}