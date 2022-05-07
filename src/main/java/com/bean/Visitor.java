package com.bean;

/**
 * 游客信息
 * uId 游客id
 * tpId 参加的旅游套餐id
 * adId 所属旅游公司的id
 * leaveTime 出发时间
 * leaveLoc 出发地点
 */
public class Visitor {
    private int uId;
    private int tpId;
    private int adId;
    private String leaveTime;
    private String leaveLoc;

    public Visitor() {
    }


    public Visitor(int uId, int tpId, int adId, String leaveTime, String leaveLoc) {
        this.uId = uId;
        this.tpId = tpId;
        this.adId = adId;
        this.leaveTime = leaveTime;
        this.leaveLoc = leaveLoc;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    @Override
    public String toString() {
        return "visitor{" +
                "uId=" + uId +
                ", tpId=" + tpId +
                ", adId=" + adId +
                ", leaveTime='" + leaveTime + '\'' +
                ", leaveLoc='" + leaveLoc + '\'' +
                '}';
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getTpId() {
        return tpId;
    }

    public void setTpId(int tpId) {
        this.tpId = tpId;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveLoc() {
        return leaveLoc;
    }

    public void setLeaveLoc(String leaveLoc) {
        this.leaveLoc = leaveLoc;
    }
}
