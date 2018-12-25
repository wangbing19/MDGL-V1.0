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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getEye_move() {
		return eye_move;
	}
	public void setEye_move(Integer eye_move) {
		this.eye_move = eye_move;
	}
	public String getHide_slope_check() {
		return hide_slope_check;
	}
	public void setHide_slope_check(String hide_slope_check) {
		this.hide_slope_check = hide_slope_check;
	}
	public String getEye_light() {
		return eye_light;
	}
	public void setEye_light(String eye_light) {
		this.eye_light = eye_light;
	}
	public String getSensiti() {
		return sensiti;
	}
	public void setSensiti(String sensiti) {
		this.sensiti = sensiti;
	}
	public String getColor_feel() {
		return color_feel;
	}
	public void setColor_feel(String color_feel) {
		this.color_feel = color_feel;
	}
	public String getStereo_view() {
		return stereo_view;
	}
	public void setStereo_view(String stereo_view) {
		this.stereo_view = stereo_view;
	}
	public String getNaked_eye_view() {
		return naked_eye_view;
	}
	public void setNaked_eye_view(String naked_eye_view) {
		this.naked_eye_view = naked_eye_view;
	}
	public String getHyperopia() {
		return hyperopia;
	}
	public void setHyperopia(String hyperopia) {
		this.hyperopia = hyperopia;
	}
	public String getMyopia() {
		return myopia;
	}
	public void setMyopia(String myopia) {
		this.myopia = myopia;
	}
	public String getAstigmatism() {
		return astigmatism;
	}
	public void setAstigmatism(String astigmatism) {
		this.astigmatism = astigmatism;
	}
	public String getVision_near_eye_dis() {
		return vision_near_eye_dis;
	}
	public void setVision_near_eye_dis(String vision_near_eye_dis) {
		this.vision_near_eye_dis = vision_near_eye_dis;
	}
	public String getFusion_img() {
		return fusion_img;
	}
	public void setFusion_img(String fusion_img) {
		this.fusion_img = fusion_img;
	}
	public String getDiplopia() {
		return diplopia;
	}
	public void setDiplopia(String diplopia) {
		this.diplopia = diplopia;
	}
	public String getHide_slope_quantitative() {
		return hide_slope_quantitative;
	}
	public void setHide_slope_quantitative(String hide_slope_quantitative) {
		this.hide_slope_quantitative = hide_slope_quantitative;
	}
	public String getNRP() {
		return NRP;
	}
	public void setNRP(String nRP) {
		NRP = nRP;
	}
	public String getPRA() {
		return PRA;
	}
	public void setPRA(String pRA) {
		PRA = pRA;
	}
	public String getBCC() {
		return BCC;
	}
	public void setBCC(String bCC) {
		BCC = bCC;
	}
	public String getAMP() {
		return AMP;
	}
	public void setAMP(String aMP) {
		AMP = aMP;
	}
	public String getCollection_near_point() {
		return collection_near_point;
	}
	public void setCollection_near_point(String collection_near_point) {
		this.collection_near_point = collection_near_point;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Date getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	
}
