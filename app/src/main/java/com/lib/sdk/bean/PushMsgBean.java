package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by hws on 2018-01-15.
 * 推送信息
 */

public class PushMsgBean implements Serializable{
    @JSONField(name = "SerialNumber")
    private String sn;
    @JSONField(name = "AuthCode")
    private String authCode;
    @JSONField(name = "AlarmID")
    private String alarmID;
    @JSONField(name = "AlarmMsg")
    private String alarmMsg;
    @JSONField(name = "AlarmTime")
    private String alarmTime;
    @JSONField(name = "AlarmEvent")
    private String alarmEvent;
    @JSONField(name = "Channel")
    private int channel;
    @JSONField(name = "Status")
    private String status;


    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAlarmID() {
        return alarmID;
    }

    public void setAlarmID(String alarmID) {
        this.alarmID = alarmID;
    }

    public String getAlarmMsg() {
        return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg) {
        this.alarmMsg = alarmMsg;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmEvent() {
        return alarmEvent;
    }

    public void setAlarmEvent(String alarmEvent) {
        this.alarmEvent = alarmEvent;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHavePic() {
        if (!StringUtils.isStringNULL(alarmEvent)) {
            String[] strs = alarmEvent.split(":");
            if (null != strs && strs.length == 2) {
                return strs[1] == "1";
            }
        }
        return false;
    }
}
