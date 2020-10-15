package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangyongyong on 2017-03-30-13:21.
 */

public class NetCommon {

    public String GateWay;

    public String HostIP;

    public String HostName;

    public int HttpPort;

    public String MAC;

    public int MaxBps;

    public String MonMode;

    public int SSLPort;

    public String SubMask;

    public int TCPMaxConn;

    public int TCPPort;

    public String TransferPlan;

    public int UDPPort;

    public boolean UseHSDownLoad;

    private String UserName;

    @JSONField(name = "HostIP")
    public String getHostIP() {
        return HostIP;
    }

    @JSONField(name = "HostIP")
    public void setHostIP(String hostIP) {
        HostIP = hostIP;
    }

    @JSONField(name = "Username")
    public String getUserName() {
        return UserName;
    }

    @JSONField(name = "Username")
    public void setUserName(String userName) {
        UserName = userName;
    }

    @JSONField(name = "Password")
    public String getPassword() {
        return Password;
    }

    @JSONField(name = "Password")
    public void setPassword(String password) {
        Password = password;
    }

    private String Password;

    @JSONField(name = "SubMask")
    public String getSubMask() {
        return SubMask;
    }

    @JSONField(name = "SubMask")
    public void setSubMask(String subMask) {
        SubMask = subMask;
    }

    @JSONField(name = "GateWay")
    public String getGateWay() {
        return GateWay;
    }

    @JSONField(name = "GateWay")
    public void setGateWay(String gateWay) {
        GateWay = gateWay;
    }

    @JSONField(name = "HostIP")
    public String getHostIp() {
        return HostIP;
    }

    @JSONField(name = "HostIP")
    public void setHostIp(String hostIp) {
        HostIP = hostIp;
    }

    @JSONField(name = "HostName")
    public String getHostName() {
        return HostName;
    }

    @JSONField(name = "HostName")
    public void setHostName(String hostName) {
        HostName = hostName;
    }

    @JSONField(name = "HttpPort")
    public int getHttpPort() {
        return HttpPort;
    }

    @JSONField(name = "HttpPort")
    public void setHttpPort(int httpPort) {
        HttpPort = httpPort;
    }

    @JSONField(name = "MAC")
    public String getMAC() {
        return MAC;
    }

    @JSONField(name = "MAC")
    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    @JSONField(name = "MaxBps")
    public int getMaxBps() {
        return MaxBps;
    }

    @JSONField(name = "MaxBps")
    public void setMaxBps(int maxBps) {
        MaxBps = maxBps;
    }

    @JSONField(name = "MonMode")
    public String getMonMode() {
        return MonMode;
    }

    @JSONField(name = "MonMode")
    public void setMonMode(String monMode) {
        MonMode = monMode;
    }

    @JSONField(name = "SSLPort")
    public int getSSLPort() {
        return SSLPort;
    }

    @JSONField(name = "SSLPort")
    public void setSSLPort(int SSLPort) {
        this.SSLPort = SSLPort;
    }

    @JSONField(name = "TCPMaxConn")
    public int getTCPMaxConn() {
        return TCPMaxConn;
    }

    @JSONField(name = "TCPMaxConn")
    public void setTCPMaxConn(int TCPMaxConn) {
        this.TCPMaxConn = TCPMaxConn;
    }

    @JSONField(name = "TCPPort")
    public int getTCPPort() {
        return TCPPort;
    }

    @JSONField(name = "TCPPort")
    public void setTCPPort(int TCPPort) {
        this.TCPPort = TCPPort;
    }

    @JSONField(name = "TransferPlan")
    public String getTransferPlan() {
        return TransferPlan;
    }

    @JSONField(name = "TransferPlan")
    public void setTransferPlan(String transferPlan) {
        TransferPlan = transferPlan;
    }

    @JSONField(name = "UDPPort")
    public int getUDPPort() {
        return UDPPort;
    }

    @JSONField(name = "UDPPort")
    public void setUDPPort(int UDPPort) {
        this.UDPPort = UDPPort;
    }

    @JSONField(name = "UseHSDownLoad")
    public boolean isUseHSDownLoad() {
        return UseHSDownLoad;
    }

    @JSONField(name = "UseHSDownLoad")
    public void setUseHSDownLoad(boolean useHSDownLoad) {
        UseHSDownLoad = useHSDownLoad;
    }

    @Override
    public String toString() {
        return "NetCommon{" +
                "GateWay='" + GateWay + '\'' +
                ", HostIP='" + HostIP + '\'' +
                ", HostName='" + HostName + '\'' +
                ", HttpPort=" + HttpPort +
                ", MAC='" + MAC + '\'' +
                ", MaxBps=" + MaxBps +
                ", MonMode='" + MonMode + '\'' +
                ", SSLPort=" + SSLPort +
                ", SubMask='" + SubMask + '\'' +
                ", TCPMaxConn=" + TCPMaxConn +
                ", TCPPort=" + TCPPort +
                ", TransferPlan='" + TransferPlan + '\'' +
                ", UDPPort=" + UDPPort +
                ", UseHSDownLoad=" + UseHSDownLoad +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}