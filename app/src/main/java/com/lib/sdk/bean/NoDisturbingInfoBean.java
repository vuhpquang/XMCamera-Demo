package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-03-26.
 * 免打扰配置项 Consumer.NoDisturbing
 */

public class NoDisturbingInfoBean {
    @JSONField(name = "EnableDnd")
    private boolean isEnableDnd;
    @JSONField(name = "RingDownDnd")
    private boolean isRingDownDnd;
    @JSONField(name = "MessageDnd")
    private boolean isMessageDnd;
    @JSONField(name = "NotifyLightDnd")
    private boolean isNotifyLightDnd;
    @JSONField(name = "DeepSleepDnd")
    private boolean isDeepSleepDnd;
    @JSONField(name = "StartTime")
    private String startTime;
    @JSONField(name = "EndTime")
    private String endTime;

    public NoDisturbingInfoBean() {

    }


    public boolean isEnableDnd() {
        return isEnableDnd;
    }

    public void setEnableDnd(boolean enableDnd) {
        isEnableDnd = enableDnd;
    }

    public boolean isRingDownDnd() {
        return isRingDownDnd;
    }

    public void setRingDownDnd(boolean ringDownDnd) {
        isRingDownDnd = ringDownDnd;
    }

    public boolean isMessageDnd() {
        return isMessageDnd;
    }

    public void setMessageDnd(boolean messageDnd) {
        isMessageDnd = messageDnd;
    }

    public boolean isNotifyLightDnd() {
        return isNotifyLightDnd;
    }

    public void setNotifyLightDnd(boolean notifyLightDnd) {
        isNotifyLightDnd = notifyLightDnd;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isDeepSleepDnd() {
        return isDeepSleepDnd;
    }

    public void setDeepSleepDnd(boolean deepSleepDnd) {
        isDeepSleepDnd = deepSleepDnd;
    }
}
