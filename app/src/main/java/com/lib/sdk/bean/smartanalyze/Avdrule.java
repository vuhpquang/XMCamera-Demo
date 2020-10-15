package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Avdrule implements Serializable{


    @JSONField(name = "ChangeEnable")
    private int changeenable;//场景变换检测使能

    @JSONField(name = "ClarityEnable")
    private int clarityenable;//清晰度检测使能


    private int colorenable;//偏色检测使能


    private int freezeenable;//画面冻结检测使能


    private int interfereenable;//人为干扰检测使能


    private int level;//灵敏度档位 1-5档，数值越大越灵敏越易报警


    private int noiseenable;//噪声检测使能


    private int nosignalenable;//信号缺失检测使能


    private int ptzlosectlenable;//PTZ失控检测使能


    private int tbrightabnmlenable;//亮度异常使能

    public Avdrule() {
    }

    @JSONField(name = "ChangeEnable")
    public void setChangeenable(int changeenable) {
        this.changeenable = changeenable;
    }

    @JSONField(name = "ChangeEnable")
    public int getChangeenable() {
        return changeenable;
    }

    @JSONField(name = "ClarityEnable")
    public void setClarityenable(int clarityenable) {
        this.clarityenable = clarityenable;
    }

    @JSONField(name = "ClarityEnable")
    public int getClarityenable() {
        return clarityenable;
    }

    @JSONField(name = "ColorEnable")
    public void setColorenable(int colorenable) {
        this.colorenable = colorenable;
    }

    @JSONField(name = "ColorEnable")
    public int getColorenable() {
        return colorenable;
    }

    @JSONField(name = "FreezeEnable")
    public void setFreezeenable(int freezeenable) {
        this.freezeenable = freezeenable;
    }

    @JSONField(name = "FreezeEnable")
    public int getFreezeenable() {
        return freezeenable;
    }

    @JSONField(name = "InterfereEnable")
    public void setInterfereenable(int interfereenable) {
        this.interfereenable = interfereenable;
    }

    @JSONField(name = "InterfereEnable")
    public int getInterfereenable() {
        return interfereenable;
    }

    @JSONField(name = "Level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JSONField(name = "Level")
    public int getLevel() {
        return level;
    }

    @JSONField(name = "NoiseEnable")
    public void setNoiseenable(int noiseenable) {
        this.noiseenable = noiseenable;
    }

    @JSONField(name = "NoiseEnable")
    public int getNoiseenable() {
        return noiseenable;
    }

    @JSONField(name = "NosignalEnable")
    public void setNosignalenable(int nosignalenable) {
        this.nosignalenable = nosignalenable;
    }

    @JSONField(name = "NosignalEnable")
    public int getNosignalenable() {
        return nosignalenable;
    }

    @JSONField(name = "PtzLoseCtlEnable")
    public void setPtzlosectlenable(int ptzlosectlenable) {
        this.ptzlosectlenable = ptzlosectlenable;
    }

    @JSONField(name = "PtzLoseCtlEnable")
    public int getPtzlosectlenable() {
        return ptzlosectlenable;
    }

    @JSONField(name = "tBrightAbnmlEnable")
    public void setTbrightabnmlenable(int tbrightabnmlenable) {
        this.tbrightabnmlenable = tbrightabnmlenable;
    }

    @JSONField(name = "tBrightAbnmlEnable")
    public int getTbrightabnmlenable() {
        return tbrightabnmlenable;
    }

//    @Override
//    public String toString() {
//        return "Avdrule{" +
//                "changeenable=" + changeenable +
//                ", clarityenable=" + clarityenable +
//                ", colorenable=" + colorenable +
//                ", freezeenable=" + freezeenable +
//                ", interfereenable=" + interfereenable +
//                ", level=" + level +
//                ", noiseenable=" + noiseenable +
//                ", nosignalenable=" + nosignalenable +
//                ", ptzlosectlenable=" + ptzlosectlenable +
//                ", tbrightabnmlenable=" + tbrightabnmlenable +
//                '}';
//    }

}