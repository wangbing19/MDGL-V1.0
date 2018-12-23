package com.md.sys.entity.exp;

import java.util.Date;

/**
 * 对应检查项目表
 * @author tarena
 *
 */
public class ExpCheckItem {
	/**检查项目表序号*/
	private Integer id;
	/**客户表序号*/
	private Integer customer_id;
	/**眼球运动*/
	private Integer eye_move;
	/**隐斜检查*/
	private String hide_slope_check;
	/**瞳孔光感*/
	private String eye_light;
	/**调节灵敏度*/
	private String sensiti;
	/**色觉*/
	private String color_feel;
	/**立体视*/
	private String stereo_view;
	/**裸眼视图*/
	private String naked_eye_view;
	/**远视*/
	private String hyperopia;
	/**近视*/
	private String myopia;
	/**散光*/
	private String astigmatism;
	/**远/近瞳距*/
	private String vision_near_eye_dis;
	/**融像功能*/
	private String fusion_img;
	/**复视*/
	private String diplopia;
	/**隐斜视定量*/
	private String hide_slope_quantitative;
	/**正相对调节*/
	private String NRP;
	/**负相对调节*/
	private String PRA;
	/**调节反应*/
	private String BCC;
	/**调节幅度*/
	private String AMP;
	/**集合近点*/
	private String collection_near_point;
	/**创建时间*/
	private Date gmt_create;
	/**修改时间*/
	private Date gmt_modified;
}
