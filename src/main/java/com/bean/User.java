package com.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {
    private String id;

    private String roleId;

    private String openid;

    private String userName;

    private String userPhone;

    private Byte gender;

    private String userEmail;

    private String userHead;

    private BigDecimal userWallet;

    private String userPayPassword;

    private String school;

    private Byte professional;

    private String achievement;

    private String educational;

    private String researchArea;

    private String certificatePhoto;

    private String identificationReversePhoto;

    private String identificationRightPhoto;

    private Byte status;

    private String businessLicensePhoto;

    private String companyName;

    private String favorableRate;

    private Date updateDate;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead == null ? null : userHead.trim();
    }

    public BigDecimal getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(BigDecimal userWallet) {
        this.userWallet = userWallet;
    }

    public String getUserPayPassword() {
        return userPayPassword;
    }

    public void setUserPayPassword(String userPayPassword) {
        this.userPayPassword = userPayPassword == null ? null : userPayPassword.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Byte getProfessional() {
        return professional;
    }

    public void setProfessional(Byte professional) {
        this.professional = professional;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational == null ? null : educational.trim();
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea == null ? null : researchArea.trim();
    }

    public String getCertificatePhoto() {
        return certificatePhoto;
    }

    public void setCertificatePhoto(String certificatePhoto) {
        this.certificatePhoto = certificatePhoto == null ? null : certificatePhoto.trim();
    }

    public String getIdentificationReversePhoto() {
        return identificationReversePhoto;
    }

    public void setIdentificationReversePhoto(String identificationReversePhoto) {
        this.identificationReversePhoto = identificationReversePhoto == null ? null : identificationReversePhoto.trim();
    }

    public String getIdentificationRightPhoto() {
        return identificationRightPhoto;
    }

    public void setIdentificationRightPhoto(String identificationRightPhoto) {
        this.identificationRightPhoto = identificationRightPhoto == null ? null : identificationRightPhoto.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBusinessLicensePhoto() {
        return businessLicensePhoto;
    }

    public void setBusinessLicensePhoto(String businessLicensePhoto) {
        this.businessLicensePhoto = businessLicensePhoto == null ? null : businessLicensePhoto.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getFavorableRate() {
        return favorableRate;
    }

    public void setFavorableRate(String favorableRate) {
        this.favorableRate = favorableRate == null ? null : favorableRate.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserHead() == null ? other.getUserHead() == null : this.getUserHead().equals(other.getUserHead()))
            && (this.getUserWallet() == null ? other.getUserWallet() == null : this.getUserWallet().equals(other.getUserWallet()))
            && (this.getUserPayPassword() == null ? other.getUserPayPassword() == null : this.getUserPayPassword().equals(other.getUserPayPassword()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getProfessional() == null ? other.getProfessional() == null : this.getProfessional().equals(other.getProfessional()))
            && (this.getAchievement() == null ? other.getAchievement() == null : this.getAchievement().equals(other.getAchievement()))
            && (this.getEducational() == null ? other.getEducational() == null : this.getEducational().equals(other.getEducational()))
            && (this.getResearchArea() == null ? other.getResearchArea() == null : this.getResearchArea().equals(other.getResearchArea()))
            && (this.getCertificatePhoto() == null ? other.getCertificatePhoto() == null : this.getCertificatePhoto().equals(other.getCertificatePhoto()))
            && (this.getIdentificationReversePhoto() == null ? other.getIdentificationReversePhoto() == null : this.getIdentificationReversePhoto().equals(other.getIdentificationReversePhoto()))
            && (this.getIdentificationRightPhoto() == null ? other.getIdentificationRightPhoto() == null : this.getIdentificationRightPhoto().equals(other.getIdentificationRightPhoto()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBusinessLicensePhoto() == null ? other.getBusinessLicensePhoto() == null : this.getBusinessLicensePhoto().equals(other.getBusinessLicensePhoto()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getFavorableRate() == null ? other.getFavorableRate() == null : this.getFavorableRate().equals(other.getFavorableRate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserHead() == null) ? 0 : getUserHead().hashCode());
        result = prime * result + ((getUserWallet() == null) ? 0 : getUserWallet().hashCode());
        result = prime * result + ((getUserPayPassword() == null) ? 0 : getUserPayPassword().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getProfessional() == null) ? 0 : getProfessional().hashCode());
        result = prime * result + ((getAchievement() == null) ? 0 : getAchievement().hashCode());
        result = prime * result + ((getEducational() == null) ? 0 : getEducational().hashCode());
        result = prime * result + ((getResearchArea() == null) ? 0 : getResearchArea().hashCode());
        result = prime * result + ((getCertificatePhoto() == null) ? 0 : getCertificatePhoto().hashCode());
        result = prime * result + ((getIdentificationReversePhoto() == null) ? 0 : getIdentificationReversePhoto().hashCode());
        result = prime * result + ((getIdentificationRightPhoto() == null) ? 0 : getIdentificationRightPhoto().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBusinessLicensePhoto() == null) ? 0 : getBusinessLicensePhoto().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getFavorableRate() == null) ? 0 : getFavorableRate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", openid=").append(openid);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", gender=").append(gender);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userHead=").append(userHead);
        sb.append(", userWallet=").append(userWallet);
        sb.append(", userPayPassword=").append(userPayPassword);
        sb.append(", school=").append(school);
        sb.append(", professional=").append(professional);
        sb.append(", achievement=").append(achievement);
        sb.append(", educational=").append(educational);
        sb.append(", researchArea=").append(researchArea);
        sb.append(", certificatePhoto=").append(certificatePhoto);
        sb.append(", identificationReversePhoto=").append(identificationReversePhoto);
        sb.append(", identificationRightPhoto=").append(identificationRightPhoto);
        sb.append(", status=").append(status);
        sb.append(", businessLicensePhoto=").append(businessLicensePhoto);
        sb.append(", companyName=").append(companyName);
        sb.append(", favorableRate=").append(favorableRate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}