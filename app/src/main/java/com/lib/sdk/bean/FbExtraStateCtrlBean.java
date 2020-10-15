package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class FbExtraStateCtrlBean {
    @JSONField(name = "ison")
    private int ison;
    private int PlayVoiceTip;


    @JSONField(name = "PlayVoiceTip")
    public int getPlayVoiceTip() {
        return PlayVoiceTip;
    }

    @JSONField(name = "PlayVoiceTip")
    public void setPlayVoiceTip(int playVoiceTip) {
        PlayVoiceTip = playVoiceTip;
    }

    public int getIson() {
        return ison;
    }

    public void setIson(int ison) {
        this.ison = ison;
    }

}
