package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangyongyong on 2017-09-27-19:32.
 */

public class NetworkWifi {

    private String Auth;

    private int Channel;

    private boolean Enable;

    private String EncrypType;

    private String GateWay;

    private String HostIP;

    private int KeyType;

    private String Keys;

    private String NetType;

    private String SSID;

    private String Submask;
    @JSONField(name = "Auth")
    public void setAuth(String Auth) {
        this.Auth = Auth;
    }
    @JSONField(name = "Auth")
    public String getAuth() {
        return this.Auth;
    }
    @JSONField(name = "Channel")
    public void setChannel(int Channel) {
        this.Channel = Channel;
    }
    @JSONField(name = "Channel")
    public int getChannel() {
        return this.Channel;
    }
    @JSONField(name = "Enable")
    public void setEnable(boolean Enable) {
        this.Enable = Enable;
    }
    @JSONField(name = "Enable")
    public boolean getEnable() {
        return this.Enable;
    }
    @JSONField(name = "EncrypType")
    public void setEncrypType(String EncrypType) {
        this.EncrypType = EncrypType;
    }
    @JSONField(name = "EncrypType")
    public String getEncrypType() {
        return this.EncrypType;
    }
    @JSONField(name = "GateWay")
    public void setGateWay(String GateWay) {
        this.GateWay = GateWay;
    }
    @JSONField(name = "GateWay")
    public String getGateWay() {
        return this.GateWay;
    }
    @JSONField(name = "HostIP")
    public void setHostIP(String HostIP) {
        this.HostIP = HostIP;
    }
    @JSONField(name = "HostIP")
    public String getHostIP() {
        return this.HostIP;
    }
    @JSONField(name = "KeyType")
    public void setKeyType(int KeyType) {
        this.KeyType = KeyType;
    }
    @JSONField(name = "KeyType")
    public int getKeyType() {
        return this.KeyType;
    }
    @JSONField(name = "Keys")
    public void setKeys(String Keys) {
        this.Keys = Keys;
    }
    @JSONField(name = "Keys")
    public String getKeys() {
        return this.Keys;
    }
    @JSONField(name = "NetType")
    public void setNetType(String NetType) {
        this.NetType = NetType;
    }
    @JSONField(name = "NetType")
    public String getNetType() {
        return this.NetType;
    }
    @JSONField(name = "SSID")
    public void setSSID(String SSID) {
        this.SSID = SSID;
    }
    @JSONField(name = "SSID")
    public String getSSID() {
        return this.SSID;
    }
    @JSONField(name = "Submask")
    public void setSubmask(String Submask) {
        this.Submask = Submask;
    }
    @JSONField(name = "Submask")
    public String getSubmask() {
        return this.Submask;
    }
}
