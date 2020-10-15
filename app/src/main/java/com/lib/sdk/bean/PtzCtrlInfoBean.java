package com.lib.sdk.bean;

/**
 * Created by hws on 2019/1/19.
 */

public class PtzCtrlInfoBean {
    public static final int DEFAULT_SPEED = 4;
    private int ptzCommandId;
    private boolean isStop;
    private int chnId;
    private String devId;
    private int speed = DEFAULT_SPEED;
    private int seq;
    public int getPtzCommandId() {
        return ptzCommandId;
    }

    public void setPtzCommandId(int ptzCommandId) {
        this.ptzCommandId = ptzCommandId;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public int getChnId() {
        return chnId;
    }

    public void setChnId(int chnId) {
        this.chnId = chnId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
