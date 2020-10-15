package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangyongyong
 * @date 2018-02-26-10:32
 */
public class NetworkPmsBean {
    private boolean Enable;
    private String ServName;
    private int Port;
    private String BoxID;
    public int PushInterval;
    private SuspiciousDetection SuspiciousDetection;

    @JSONField(name = "Enable")
    public void setEnable(boolean Enable) {
        this.Enable = Enable;
    }

    @JSONField(name = "Enable")
    public boolean getEnable() {
        return Enable;
    }

    @JSONField(name = "PushInterval")
    public int getPushInterval() {
        return PushInterval;
    }

    @JSONField(name = "PushInterval")
    public void setPushInterval(int pushInterval) {
        PushInterval = pushInterval;
    }

    @JSONField(name = "ServName")
    public void setServName(String ServName) {
        this.ServName = ServName;
    }

    @JSONField(name = "ServName")
    public String getServName() {
        return ServName;
    }

    @JSONField(name = "Port")
    public void setPort(int Port) {
        this.Port = Port;
    }

    @JSONField(name = "Port")
    public int getPort() {
        return Port;
    }

    @JSONField(name = "BoxID")
    public void setBoxID(String BoxID) {
        this.BoxID = BoxID;
    }

    @JSONField(name = "BoxID")
    public String getBoxID() {
        return BoxID;
    }

    @JSONField(name = "SuspiciousDetection")
    public void setSuspiciousDetection(SuspiciousDetection SuspiciousDetection) {
        this.SuspiciousDetection = SuspiciousDetection;
    }

    @JSONField(name = "SuspiciousDetection")
    public SuspiciousDetection getSuspiciousDetection() {
        return SuspiciousDetection;
    }

    public static class SuspiciousDetection {

        private boolean Enable;
        private int SuspiciousTime;
        private int SuspiciousSensitivity;

        @JSONField(name = "Enable")
        public void setEnable(boolean Enable) {
            this.Enable = Enable;
        }

        @JSONField(name = "Enable")
        public boolean getEnable() {
            return Enable;
        }

        @JSONField(name = "SuspiciousTime")
        public void setSuspiciousTime(int SuspiciousTime) {
            this.SuspiciousTime = SuspiciousTime;
        }

        @JSONField(name = "SuspiciousTime")
        public int getSuspiciousTime() {
            return SuspiciousTime;
        }

        @JSONField(name = "SuspiciousSensitivity")
        public void setSuspiciousSensitivity(int SuspiciousSensitivity) {
            this.SuspiciousSensitivity = SuspiciousSensitivity;
        }

        @JSONField(name = "SuspiciousSensitivity")
        public int getSuspiciousSensitivity() {
            return SuspiciousSensitivity;
        }
    }

}
