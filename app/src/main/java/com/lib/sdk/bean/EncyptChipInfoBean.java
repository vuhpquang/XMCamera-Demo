package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @name iCSee_Pro_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class 加密芯片信息
 * @time 2018-11-07 19:43
 * @change
 * @chang time
 * @class describe
 */
public class EncyptChipInfoBean {
    public static final int CMD = 1020;
    public static final String JSON_NAME = "EncyptChipInfo";
    @JSONField(name = "Version")
    private String version;
    @JSONField(name = "Base")
    private int base;
    @JSONField(name = "DssLevel")
    private int dssLevel;
    @JSONField(name = "EnBase")
    private int enBase;
    @JSONField(name = "ExtraLevel")
    private int extraLevel;
    @JSONField(name = "Intel")
    private int intel;
    @JSONField(name = "IntelCPC")
    private int intelCPC;
    @JSONField(name = "IpcDeviceType")
    private int ipcDeviceType;
    @JSONField(name = "Nat")
    private int nat;
    @JSONField(name = "OEMID")
    private int oEMID;
    @JSONField(name = "OEMProuct")
    private int oEMProuct;
    @JSONField(name = "OEMSerial")
    private int oEMSerial;
    @JSONField(name = "Resolution")
    private int resolution;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getDssLevel() {
        return dssLevel;
    }

    public void setDssLevel(int dssLevel) {
        this.dssLevel = dssLevel;
    }

    public int getEnBase() {
        return enBase;
    }

    public void setEnBase(int enBase) {
        this.enBase = enBase;
    }

    public int getExtraLevel() {
        return extraLevel;
    }

    public void setExtraLevel(int extraLevel) {
        this.extraLevel = extraLevel;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getIntelCPC() {
        return intelCPC;
    }

    public void setIntelCPC(int intelCPC) {
        this.intelCPC = intelCPC;
    }

    public int getIpcDeviceType() {
        return ipcDeviceType;
    }

    public void setIpcDeviceType(int ipcDeviceType) {
        this.ipcDeviceType = ipcDeviceType;
    }

    public int getNat() {
        return nat;
    }

    public void setNat(int nat) {
        this.nat = nat;
    }

    public int getoEMID() {
        return oEMID;
    }

    public void setoEMID(int oEMID) {
        this.oEMID = oEMID;
    }

    public int getoEMProuct() {
        return oEMProuct;
    }

    public void setoEMProuct(int oEMProuct) {
        this.oEMProuct = oEMProuct;
    }

    public int getoEMSerial() {
        return oEMSerial;
    }

    public void setoEMSerial(int oEMSerial) {
        this.oEMSerial = oEMSerial;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
}
