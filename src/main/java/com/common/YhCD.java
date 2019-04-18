package com.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
public class YhCD {
    private String cdmc;
    private String cdurl;
    private Integer orders;
    private String icon;
    private boolean hasChild;
    private List<YhCD> childCds;

    public YhCD() {

    }

    public YhCD(String cdmc, String cdurl, Integer orders, String icon) {
        this.cdmc = cdmc;
        this.cdurl = cdurl;
        this.orders = orders;
        this.icon = icon;
    }

    public void putChildCD(String zcdmc, String zcdurl, Integer orders, String icon) {
        this.hasChild = true;
        if (this.childCds == null) {
            this.childCds = new ArrayList<YhCD>();
        }
        this.childCds.add(new YhCD(zcdmc, zcdurl, orders, icon));
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getCdmc() {
        return cdmc;
    }

    public void setCdmc(String cdmc) {
        this.cdmc = cdmc;
    }

    public String getCdurl() {
        return cdurl;
    }

    public void setCdurl(String cdurl) {
        this.cdurl = cdurl;
    }

    public boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public List<YhCD> getChildCds() {
        return childCds;
    }

    public void setChildCds(List<YhCD> childCds) {
        this.childCds = childCds;
    }
}
