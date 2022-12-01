package com.example.rabbit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 百年建筑招标信息
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invite  implements Serializable {
	
	private static final long serialVersionUID = 3285260524917513630L;
	private static final String INVITE_STRING = "Invite-";

	/** 表ID */
	private long id;
	/** 置顶 0-不置顶，1-置顶 */
	private int ding = 0;
	/** 模板 */
	private String template = "";
	/** 招标编号 */
	private String code = "";
	/** 标题 */
	private String title = "";
	/** 标题颜色 */
	private String titleColor = "";
	/** 是否加粗 */
	private boolean titleBold = false;
	/** 是否倾斜 */
	private boolean titleItalic = false;
	/** 是否带下划线 */
	private boolean titleUnderline = false;
	/** 是否推荐 */
	private boolean recommend = false;
	/** 是否邀请 */
	private boolean invitation = false;
	/** 是否为优质 */
	private boolean quality = false;
	/** 是否复星招投标 */
	private boolean fuxing = false;
	/** 副标题 */
	private String subTitle = "";
	/** 来源 */
	private String source = "";
	/** 类别 */
	private String catalog = "";
	/** 所属行业 */
	private String industry = "";
	/** 细分行业 */
	private String segment = "";
	/** 投标截止时间（暂不用） */
	private String blockingTime = "";
	/** 国家 */
	private String country = "";
	/** 省份 */
	private String state = "";
	/** 城市 */
	private String city = "";
	/** 县/区 */
	private String area = "";
	/** 招标业主 */
	private String biddingOwner = "";
	/** 招标业主简介 */
	private String biddingBrief = "";
	/** 联系人 */
	private String linkman = "";
	/** 联系方式 */
	private String contactWay = "";
	/** 招标代理机构 */
	private String biddingProxyOwner = "";
	/** 代理机构联系人 */
	private String proxyLinkman = "";
	/** 代理机构联系方式 */
	private String proxyContactWay = "";
	/** 客服电话 */
	private String customerServicePhone = "";
	/** 开标时间 （暂不用） */
	private String openingTime = "";
	/** 开标地址 （暂不用） */
	private String openingAddress = "";
	/** 工程名称 （暂不用） */
	private String name = "";
	/** 工程地点 （暂不用） */
	private String address = "";
	/** 工期要求 */
	private String duration = "";
	/** 投资规模 */
	private float funds = 0.0f;
	/** 施工面积 （暂不用） */
	private float siteArea = 0.0f;
	/** 承包方式 （暂不用） */
	private String designBuild = "";
	/** 工程质量要求 （暂不用） */
	private String requirements = "";
	/** 招标政策 （暂不用） */
	private String policy = "";
	/** 资格预审方法 （暂不用） */
	private String preliminary = "";
	/** 资格预审文件的获取 （暂不用） */
	private String getFile = "";
	/** 资格预审文件的递交 （暂不用） */
	private String toFile = "";
	/** 报名时间  暂不用） */
	private String regTime = "";
	/** 报名地点 （暂不用） */
	private String regAddress = "";
	/** 招标文件领取 （暂不用） */
	private String acquire = "";
	/** 显示时间 */
	private long viewTime;
	/** 状态 */
	private int status;
	/** 公告内容 */
	private String brief = "";
	/** 投标人资质要求 （暂不用） */
	private String qualifications = "";
	/** 报名要求 （暂不用） */
	private String registration = "";
	/** 备注 */
	private String note = "";
	/** 创建人 */
	private long creatorId;
	/** 创建时间 */
	private long createTime;
	/** 最后更新时间 */
	private long lastAccess;
	/** 采集时间 */
	private long collectTime = 0;
	/** 采集来源 */
	private String collectSource = "";
	/** 采集来源链接 */
	private String collectLink = "";
	/** 依据关键词（采集分析出来的关键词） */
	private String basisKeyword="";
	/** 招标业主颜色 */
	private String biddingOwnerColor="";
	/** 招标业主是否加粗 0：不加粗 1：加粗 */
	private boolean biddingOwnerBold = false;
	/** 0：采集，1：录入 */
	private Integer dataType = 0;
	
	/** 招标数量 */
	private Long inviteNum = 0L;

	/**
	 * 爬虫文章ID
	 */
	private Long bid = 0L;

	/**
	 * 文章来源是否是老爬虫系统(true-老系统,false-新系统)
	 */
	private boolean old = false;
	
	
}