package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-04-13.
 *
 */

public class IntervalWakeUpInfoBean {
    @JSONField(name = "Enable")
    private boolean enable;
    @JSONField(name = "SetTime")
    private String setTime;/*"2018-03-08 08:03:00"*/
    @JSONField(name = "TimeInterval")
    private int timeInterval;/*最大48h 设置间隔。单位为min*/
    @JSONField(name = "PushMsg")
    private boolean pushMsg;//推送使能
    @JSONField(name = "RecordEnable")
    private boolean recordEnable;//录像使能
    @JSONField(name = "SnapEnable")
    private boolean snapEnable;   //抓图使能
    @JSONField(name = "DoorBellEnable")
    private boolean doorBellEnable; //响铃使能

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public boolean isPushMsg() {
        return pushMsg;
    }

    public void setPushMsg(boolean pushMsg) {
        this.pushMsg = pushMsg;
    }

    public boolean isRecordEnable() {
        return recordEnable;
    }

    public void setRecordEnable(boolean recordEnable) {
        this.recordEnable = recordEnable;
    }

    public boolean isSnapEnable() {
        return snapEnable;
    }

    public void setSnapEnable(boolean snapEnable) {
        this.snapEnable = snapEnable;
    }

    public boolean isDoorBellEnable() {
        return doorBellEnable;
    }

    public void setDoorBellEnable(boolean doorBellEnable) {
        this.doorBellEnable = doorBellEnable;
    }
}
