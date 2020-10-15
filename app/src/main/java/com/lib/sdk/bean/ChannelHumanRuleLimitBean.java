package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author hws
 * @name XMEye_Android
 * @class name：com.com.lib.bean
 * @class 人形规则能力集
 * @time 2019-05-21 15:39
 */
public class ChannelHumanRuleLimitBean implements Serializable{
    @JSONField(name = "ShowRule")
    private boolean showRule; //是否支持配置显示规则
    @JSONField(name = "ShowTrack")
    private boolean showTrack;//是否支持配置显示踪迹
    @JSONField(name = "Sensitivity")
    private boolean sensitivity;//是否支持配置灵敏度
    @JSONField(name = "SupportArea")
    private boolean supportArea;//支持区域
    @JSONField(name = "SupportLine")
    private boolean supportLine;//支持伴线
    @JSONField(name = "dwLowObjectType")
    private String dwLowObjectType;//检测对象，低32种对象。掩码 第0位人形
    @JSONField(name = "dwHighObjectType")
    private String dwHighObjectType;//检测对象，高32种对象
    @JSONField(name = "dwAreaLine")
    private String dwAreaLine;//区域支持几条边。用边数的掩码表示，这里给出的只支持4边形
    @JSONField(name = "LineNum")
    private int lineNum;//警戒线的个数
    @JSONField(name = "dwLineDirect")
    private String dwLineDirect;//支持警戒线的方向。XM_IA_DIRECTION_E枚举的掩码，这里代表支持双向 0x4  表示100
    @JSONField(name = "AreaNum")
    private int areaNum;//警戒区域的个数
    @JSONField(name = "dwAreaDirect")
    private String dwAreaDirect;//支持警戒区域的方向。XM_IA_DIRECTION_E枚举的掩码，这里代表支持双向

    public boolean isShowRule() {
        return showRule;
    }

    public void setShowRule(boolean showRule) {
        this.showRule = showRule;
    }

    public boolean isShowTrack() {
        return showTrack;
    }

    public void setShowTrack(boolean showTrack) {
        this.showTrack = showTrack;
    }

    public boolean isSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(boolean sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isSupportArea() {
        return supportArea;
    }

    public void setSupportArea(boolean supportArea) {
        this.supportArea = supportArea;
    }

    public boolean isSupportLine() {
        return supportLine;
    }

    public void setSupportLine(boolean supportLine) {
        this.supportLine = supportLine;
    }

    public String getDwLowObjectType() {
        return dwLowObjectType;
    }

    public void setDwLowObjectType(String dwLowObjectType) {
        this.dwLowObjectType = dwLowObjectType;
    }

    public String getDwHighObjectType() {
        return dwHighObjectType;
    }

    public void setDwHighObjectType(String dwHighObjectType) {
        this.dwHighObjectType = dwHighObjectType;
    }

    public String getDwAreaLine() {
        return dwAreaLine;
    }

    public void setDwAreaLine(String dwAreaLine) {
        this.dwAreaLine = dwAreaLine;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getDwLineDirect() {
        return dwLineDirect;
    }

    public void setDwLineDirect(String dwLineDirect) {
        this.dwLineDirect = dwLineDirect;
    }

    public int getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(int areaNum) {
        this.areaNum = areaNum;
    }

    public String getDwAreaDirect() {
        return dwAreaDirect;
    }

    public void setDwAreaDirect(String dwAreaDirect) {
        this.dwAreaDirect = dwAreaDirect;
    }
}
