package com.bean;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private Integer id;

    private String loginname;

    private String password;

    private String tel;

    private String cardno;

    private String realname;

    private Byte ischeckname;

    private Byte isactive;

    private Byte ismerchant;

    private Integer merchantid;

    private String openid;

    private String nickname;

    private String headimg;

    private String paypwd;

    private Date createtime;

    private Integer parentid;

    private String extcode;

    private Date extinvalidtime;

    private String colcode;

    private Integer cityid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Byte getIscheckname() {
        return ischeckname;
    }

    public void setIscheckname(Byte ischeckname) {
        this.ischeckname = ischeckname;
    }

    public Byte getIsactive() {
        return isactive;
    }

    public void setIsactive(Byte isactive) {
        this.isactive = isactive;
    }

    public Byte getIsmerchant() {
        return ismerchant;
    }

    public void setIsmerchant(Byte ismerchant) {
        this.ismerchant = ismerchant;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd == null ? null : paypwd.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getExtcode() {
        return extcode;
    }

    public void setExtcode(String extcode) {
        this.extcode = extcode == null ? null : extcode.trim();
    }

    public Date getExtinvalidtime() {
        return extinvalidtime;
    }

    public void setExtinvalidtime(Date extinvalidtime) {
        this.extinvalidtime = extinvalidtime;
    }

    public String getColcode() {
        return colcode;
    }

    public void setColcode(String colcode) {
        this.colcode = colcode == null ? null : colcode.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
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
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginname() == null ? other.getLoginname() == null : this.getLoginname().equals(other.getLoginname()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getCardno() == null ? other.getCardno() == null : this.getCardno().equals(other.getCardno()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getIscheckname() == null ? other.getIscheckname() == null : this.getIscheckname().equals(other.getIscheckname()))
            && (this.getIsactive() == null ? other.getIsactive() == null : this.getIsactive().equals(other.getIsactive()))
            && (this.getIsmerchant() == null ? other.getIsmerchant() == null : this.getIsmerchant().equals(other.getIsmerchant()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getHeadimg() == null ? other.getHeadimg() == null : this.getHeadimg().equals(other.getHeadimg()))
            && (this.getPaypwd() == null ? other.getPaypwd() == null : this.getPaypwd().equals(other.getPaypwd()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getExtcode() == null ? other.getExtcode() == null : this.getExtcode().equals(other.getExtcode()))
            && (this.getExtinvalidtime() == null ? other.getExtinvalidtime() == null : this.getExtinvalidtime().equals(other.getExtinvalidtime()))
            && (this.getColcode() == null ? other.getColcode() == null : this.getColcode().equals(other.getColcode()))
            && (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginname() == null) ? 0 : getLoginname().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getCardno() == null) ? 0 : getCardno().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getIscheckname() == null) ? 0 : getIscheckname().hashCode());
        result = prime * result + ((getIsactive() == null) ? 0 : getIsactive().hashCode());
        result = prime * result + ((getIsmerchant() == null) ? 0 : getIsmerchant().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getHeadimg() == null) ? 0 : getHeadimg().hashCode());
        result = prime * result + ((getPaypwd() == null) ? 0 : getPaypwd().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getExtcode() == null) ? 0 : getExtcode().hashCode());
        result = prime * result + ((getExtinvalidtime() == null) ? 0 : getExtinvalidtime().hashCode());
        result = prime * result + ((getColcode() == null) ? 0 : getColcode().hashCode());
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginname=").append(loginname);
        sb.append(", password=").append(password);
        sb.append(", tel=").append(tel);
        sb.append(", cardno=").append(cardno);
        sb.append(", realname=").append(realname);
        sb.append(", ischeckname=").append(ischeckname);
        sb.append(", isactive=").append(isactive);
        sb.append(", ismerchant=").append(ismerchant);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", headimg=").append(headimg);
        sb.append(", paypwd=").append(paypwd);
        sb.append(", createtime=").append(createtime);
        sb.append(", parentid=").append(parentid);
        sb.append(", extcode=").append(extcode);
        sb.append(", extinvalidtime=").append(extinvalidtime);
        sb.append(", colcode=").append(colcode);
        sb.append(", cityid=").append(cityid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}