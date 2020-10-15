package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-08-27.
 * 设备端喇叭[fVideo.Volume]和Mic[fVideo.InVolume]音量调节
 */

public class DevVolumeBean {
    public static final int VOLUME_MAX = 100;
    @JSONField(name = "AudioMode")
    private String audioMode;
    @JSONField(name = "LeftVolume")
    private int leftVolume;
    @JSONField(name = "RightVolume")
    private int rightVolume;

    public String getAudioMode() {
        return audioMode;
    }

    public void setAudioMode(String audioMode) {
        this.audioMode = audioMode;
    }

    public int getLeftVolume() {
        return leftVolume;
    }

    public void setLeftVolume(int leftVolume) {
        this.leftVolume = leftVolume;
    }

    public int getRightVolume() {
        return rightVolume;
    }

    public void setRightVolume(int rightVolume) {
        this.rightVolume = rightVolume;
    }
}
