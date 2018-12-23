package com.md.sys.entity.cus;

import java.io.Serializable;
import java.util.Date;
/**
 * 诊断表
 */
public class CusDiagnose implements Serializable {

	/**序列化序号*/
	private static final long serialVersionUID = 5832718007780180070L;
	/**序号*/
	private int id;
	/**右眼球面镜（近视）*/
	private double rDs;
	/**右眼柱面镜（散光）*/
	private double rDc;
	/**右眼x轴*/
	private double rX;
	/**右眼屈光力（度数）*/
	private double rD;
	/**左眼球面镜（近视）*/
	private double lDs;
	/**左眼柱面镜（散光）*/
	private double lDc;
	/**左眼x轴*/
	private double lX;
	/**左眼屈光力（度数）*/
	private double lD;
	/**瞳距*/
	private double pupilDistance;
	/**右眼镜度数*/
	private double rGlassesD;
	/**右眼镜散光*/
	private double rGlassesDc;
	/**左眼镜度数*/
	private double lGlassesD;
	/**左眼镜散光*/
	private double lGlassesDc;
	/**眼位检查*/
	private String eyePositionExamination;
	/**同视视*/
	private String synoptophore;
	/**融合视*/
	private String fusionvision;
	/**立体视*/
	private String stereopsis;
	/**屈光不正*/
	private String ametropia;
	/**弱视程度*/
	private String amblyopiaDegree;
	/**弱视性质*/
	private String amblyopia;
	/**弱视预后*/
	private String amblyopiaPrognosis;
	/**斜视*/
	private String strabismus;
	/**视光其他诊断*/
	private String visionOther;
	/**训练过程家长配合事项*/
	private String parentCooperationDuringTraining;
	/**诊断师*/
	private String diagnostics;
	/**门店/用户id*/
	private int userId;
	/**客户表id*/
	private int customerId;
	/**建表时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getrDs() {
		return rDs;
	}
	public void setrDs(double rDs) {
		this.rDs = rDs;
	}
	public double getrDc() {
		return rDc;
	}
	public void setrDc(double rDc) {
		this.rDc = rDc;
	}
	public double getrX() {
		return rX;
	}
	public void setrX(double rX) {
		this.rX = rX;
	}
	public double getrD() {
		return rD;
	}
	public void setrD(double rD) {
		this.rD = rD;
	}
	public double getlDs() {
		return lDs;
	}
	public void setlDs(double lDs) {
		this.lDs = lDs;
	}
	public double getlDc() {
		return lDc;
	}
	public void setlDc(double lDc) {
		this.lDc = lDc;
	}
	public double getlX() {
		return lX;
	}
	public void setlX(double lX) {
		this.lX = lX;
	}
	public double getlD() {
		return lD;
	}
	public void setlD(double lD) {
		this.lD = lD;
	}
	public double getPupilDistance() {
		return pupilDistance;
	}
	public void setPupilDistance(double pupilDistance) {
		this.pupilDistance = pupilDistance;
	}
	public double getrGlassesD() {
		return rGlassesD;
	}
	public void setrGlassesD(double rGlassesD) {
		this.rGlassesD = rGlassesD;
	}
	public double getrGlassesDc() {
		return rGlassesDc;
	}
	public void setrGlassesDc(double rGlassesDc) {
		this.rGlassesDc = rGlassesDc;
	}
	public double getlGlassesD() {
		return lGlassesD;
	}
	public void setlGlassesD(double lGlassesD) {
		this.lGlassesD = lGlassesD;
	}
	public double getlGlassesDc() {
		return lGlassesDc;
	}
	public void setlGlassesDc(double lGlassesDc) {
		this.lGlassesDc = lGlassesDc;
	}
	public String getEyePositionExamination() {
		return eyePositionExamination;
	}
	public void setEyePositionExamination(String eyePositionExamination) {
		this.eyePositionExamination = eyePositionExamination;
	}
	public String getSynoptophore() {
		return synoptophore;
	}
	public void setSynoptophore(String synoptophore) {
		this.synoptophore = synoptophore;
	}
	public String getFusionvision() {
		return fusionvision;
	}
	public void setFusionvision(String fusionvision) {
		this.fusionvision = fusionvision;
	}
	public String getStereopsis() {
		return stereopsis;
	}
	public void setStereopsis(String stereopsis) {
		this.stereopsis = stereopsis;
	}
	public String getAmetropia() {
		return ametropia;
	}
	public void setAmetropia(String ametropia) {
		this.ametropia = ametropia;
	}
	public String getAmblyopiaDegree() {
		return amblyopiaDegree;
	}
	public void setAmblyopiaDegree(String amblyopiaDegree) {
		this.amblyopiaDegree = amblyopiaDegree;
	}
	public String getAmblyopia() {
		return amblyopia;
	}
	public void setAmblyopia(String amblyopia) {
		this.amblyopia = amblyopia;
	}
	public String getAmblyopiaPrognosis() {
		return amblyopiaPrognosis;
	}
	public void setAmblyopiaPrognosis(String amblyopiaPrognosis) {
		this.amblyopiaPrognosis = amblyopiaPrognosis;
	}
	public String getStrabismus() {
		return strabismus;
	}
	public void setStrabismus(String strabismus) {
		this.strabismus = strabismus;
	}
	public String getVisionOther() {
		return visionOther;
	}
	public void setVisionOther(String visionOther) {
		this.visionOther = visionOther;
	}
	public String getParentCooperationDuringTraining() {
		return parentCooperationDuringTraining;
	}
	public void setParentCooperationDuringTraining(String parentCooperationDuringTraining) {
		this.parentCooperationDuringTraining = parentCooperationDuringTraining;
	}
	public String getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	

}
