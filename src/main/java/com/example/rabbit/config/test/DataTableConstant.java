package com.example.rabbit.config.test;

public class DataTableConstant {
    /**
     * 用户标签内容汇总表
     */
    public static final String LABEL_SUMMARY_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_SUMMARY";
    /**
     * 用户标签内容基础明细表
     */
    public static final String BASIC_INFO_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_BASEINFO";
    /**
     * 用户标签参会品种明细表
     */
    public static final String ATTEND_VARIETY_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_BREED_FREQ_NAME";
    /**
     * 用户标签关注品种明细表
     */
    public static final String CONCERN_VARIETY_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_FOLLOW_BREED";
    /**
     * 用户标签关注栏目明细表
     */
    public static final String CONCERN_COLUMN_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_FOLLOW_SECTION";
    /**
     * 用户标签关注地区明细表
     */
    public static final String CONCERN_REGION_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_REGION_NAME";
    /**
     * 用户标签权限信息明细表
     */
    public static final String RIGHT_INFO_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_RIGHTS";
    /**
     * 用户标签定制品种明细表
     */
    public static final String CUSTOM_VARIETY_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_CUSTOMIZED_BREED";
    /**
     * 用户标签定制栏目明细表
     */
    public static final String CUSTOM_COLUMN_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_CUSTOMIZED_SECTION";
    /**
     * 用户标签推送用户明细
     */
    public static final String USER_DETAIL_TABLE = "ADS.BACKPUSH_APPUSER_LABEL_PUSH_USERS";




    public static final String inSqlForInfo = "SELECT SUM(user_cnt) as countOfContainedUser , %s as tagKey, %s as selectedContent " +
            "FROM ADS" +
            ".BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE label_type = '%s' " +
            "AND " +
            "label_info IN %s";
    public static final String inSqlForId = "SELECT SUM(user_cnt) FROM ADS.BACKPUSH_APPUSER_LABEL_SUMMARY WHERE " +
            "label_type = '%s' " +
            "AND " +
            "label_id IN %s";
    public static final String betweenSql = "SELECT SUM(user_cnt) FROM ADS.BACKPUSH_APPUSER_LABEL_SUMMARY WHERE " +
            "label_type = '%s' AND " +
            "label_info >= '%s' AND label_info <= '%s'";
    public static final String betweenWithoutEndSql = "SELECT SUM(user_cnt) FROM ADS.BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE label_type " +
            "= '%s' AND label_info >= '%s'";
    public static final String betweenWithoutStartSql = "SELECT SUM(user_cnt) FROM ADS.BACKPUSH_APPUSER_LABEL_SUMMARY " +
            "WHERE " +
            "label_type ='%s' AND label_info <= '%s'";

}
