package com.md.sys.entity.cus;

import java.io.Serializable;
import java.util.Date;
/**
 * 咨询表
 */
public class CusConsultation implements Serializable {

	/**序列化序号*/
	private static final long serialVersionUID = 709710391890397923L;
	/**序号*/
	private int id;
	/**姓名*/
	private String name;
	/**年龄*/
	private int age;
	/**性别*/
	private String gender;
	/**电话*/
	private String tel;
	/**左右眼*/
	private String eye;
	/**视力下降时间(年)*/
	private String declineTimeYear;
	/**视力下降时间(月)*/
	private String declineTimeMonth;
	/**诊断*/
	private String diagnose;
	/**眼病*/
	private String oculopathy;
	/**矫正方法*/
	private String correctionMethod;
	/**效果*/
	private String effect;
	/**现视力情况*/
	private String visualAcuity;
	/**父视力情况*/
	private String fVisionCondition;
	/**父其他*/
	private String fOther;
	/**母视力情况*/
	private String mVisionCondition;
	/**母其他*/
	private String mOther;
	/**睡眠时间*/
	private String sleepingTime;
	/**用眼项目*/
	private String eyeProject;
	/**用眼项目其他*/
	private String eyeProjectOther;
	/**每次看书、作业的时长*/
	private String readingTime;
	/**看书距离*/
	private String readingDistance;
	/**单次看电视时长*/
	private String watchingTime;
	/**看电视距离*/
	private String watchingDistance;
	/**用眼姿势*/
	private String eyePosition;
	/**家庭环境光线*/
	private String homeLightingEnvironment;
	/**教室环境光线*/
	private String classroomLightingEnvironment;
	/**裸眼远视力（5米）： 右眼*/
	private double rD;
	/**裸眼远视力（5米）： 左眼*/
	private double lD;
	/**矫正远视力（5米）: 右眼*/
	private double rCva;
	/**矫正远视力（5米）: 左眼*/
	private double lCva;
	/**训练导师*/
	private String tutor;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEye() {
		return eye;
	}
	public void setEye(String eye) {
		this.eye = eye;
	}
	public String getDeclineTimeYear() {
		return declineTimeYear;
	}
	public void setDeclineTimeYear(String declineTimeYear) {
		this.declineTimeYear = declineTimeYear;
	}
	public String getDeclineTimeMonth() {
		return declineTimeMonth;
	}
	public void setDeclineTimeMonth(String declineTimeMonth) {
		this.declineTimeMonth = declineTimeMonth;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getOculopathy() {
		return oculopathy;
	}
	public void setOculopathy(String oculopathy) {
		this.oculopathy = oculopathy;
	}
	public String getCorrectionMethod() {
		return correctionMethod;
	}
	public void setCorrectionMethod(String correctionMethod) {
		this.correctionMethod = correctionMethod;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getfVisionCondition() {
		return fVisionCondition;
	}
	public void setfVisionCondition(String fVisionCondition) {
		this.fVisionCondition = fVisionCondition;
	}
	public String getfOther() {
		return fOther;
	}
	public void setfOther(String fOther) {
		this.fOther = fOther;
	}
	public String getmVisionCondition() {
		return mVisionCondition;
	}
	public void setmVisionCondition(String mVisionCondition) {
		this.mVisionCondition = mVisionCondition;
	}
	public String getmOther() {
		return mOther;
	}
	public void setmOther(String mOther) {
		this.mOther = mOther;
	}
	public String getSleepingTime() {
		return sleepingTime;
	}
	public void setSleepingTime(String sleepingTime) {
		this.sleepingTime = sleepingTime;
	}
	public String getEyeProject() {
		return eyeProject;
	}
	public void setEyeProject(String eyeProject) {
		this.eyeProject = eyeProject;
	}
	public String getEyeProjectOther() {
		return eyeProjectOther;
	}
	public void setEyeProjectOther(String eyeProjectOther) {
		this.eyeProjectOther = eyeProjectOther;
	}
	public String getReadingTime() {
		return readingTime;
	}
	public void setReadingTime(String readingTime) {
		this.readingTime = readingTime;
	}
	public String getReadingDistance() {
		return readingDistance;
	}
	public void setReadingDistance(String readingDistance) {
		this.readingDistance = readingDistance;
	}
	public String getWatchingTime() {
		return watchingTime;
	}
	public void setWatchingTime(String watchingTime) {
		this.watchingTime = watchingTime;
	}
	public String getWatchingDistance() {
		return watchingDistance;
	}
	public void setWatchingDistance(String watchingDistance) {
		this.watchingDistance = watchingDistance;
	}
	public String getEyePosition() {
		return eyePosition;
	}
	public void setEyePosition(String eyePosition) {
		this.eyePosition = eyePosition;
	}
	public String getHomeLightingEnvironment() {
		return homeLightingEnvironment;
	}
	public void setHomeLightingEnvironment(String homeLightingEnvironment) {
		this.homeLightingEnvironment = homeLightingEnvironment;
	}
	public String getClassroomLightingEnvironment() {
		return classroomLightingEnvironment;
	}
	public void setClassroomLightingEnvironment(String classroomLightingEnvironment) {
		this.classroomLightingEnvironment = classroomLightingEnvironment;
	}
	public double getrD() {
		return rD;
	}
	public void setrD(double rD) {
		this.rD = rD;
	}
	public double getlD() {
		return lD;
	}
	public void setlD(double lD) {
		this.lD = lD;
	}
	public double getrCva() {
		return rCva;
	}
	public void setrCva(double rCva) {
		this.rCva = rCva;
	}
	public double getlCva() {
		return lCva;
	}
	public void setlCva(double lCva) {
		this.lCva = lCva;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
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
