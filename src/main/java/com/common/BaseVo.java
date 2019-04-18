package com.common;

import com.util.StringUtil;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/7.
 */
public class BaseVo extends Print implements Serializable {
    private static final long serialVersionUID = -6808810890815522388L;
    private String pageSize;
    private String pageNum;
    private String errMessage = "";
    private String errCode = "-1";
    private boolean isSuccess;
    private String id;
    private Integer cityid;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPageNumInt() {
        return StringUtil.String2Integer(pageNum, 1).intValue();
    }

    public int getPageSizeInt() {
        return StringUtil.String2Integer(pageSize, 10).intValue();
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}
