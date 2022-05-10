package com.bean;

public class Order {
    private int oId;
    private int tpId;
    private int uId;
    private String oDate;

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", tpId=" + tpId +
                ", uId=" + uId +
                ", oDate='" + oDate + '\'' +
                '}';
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getTpId() {
        return tpId;
    }

    public void setTpId(int tpId) {
        this.tpId = tpId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public Order(int oId, int tpId, int uId, String oDate) {
        this.oId = oId;
        this.tpId = tpId;
        this.uId = uId;
        this.oDate = oDate;
    }

    public Order() {
    }
}
