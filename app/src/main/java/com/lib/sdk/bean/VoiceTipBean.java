package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Administrator
 * @name iCSee_Pro_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class describe
 * @time 2019-03-29 17:22
 * @change
 * @chang time
 * @class describe
 */
public class VoiceTipBean implements Serializable{
    @JSONField(name = "VoiceEnum")
    private int voiceEnum;
    @JSONField(name = "VoiceText")
    private String voiceText;

    public int getVoiceEnum() {
        return voiceEnum;
    }

    public void setVoiceEnum(int voiceEnum) {
        this.voiceEnum = voiceEnum;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }
}
