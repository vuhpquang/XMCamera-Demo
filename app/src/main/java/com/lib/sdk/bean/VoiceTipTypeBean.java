package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author hws
 * @name iCSee_Pro_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class 报警声
 * @time 2019-03-27 21:17
 */
public class VoiceTipTypeBean {
    public static final String JSONNAME = "Ability.VoiceTipType";
    @JSONField(name = "VoiceTip")
    private List<VoiceTipBean> voiceTips;

    public List<VoiceTipBean> getVoiceTips() {
        return voiceTips;
    }

    public void setVoiceTips(List<VoiceTipBean> voiceTips) {
        this.voiceTips = voiceTips;
    }

    @JSONField(serialize = false)
    public VoiceTipBean getVoiceTip(int position) {
        if (voiceTips != null) {
            if (position < voiceTips.size()) {
                return voiceTips.get(position);
            }
        }
        return null;
    }

    @JSONField(serialize = false)
    public int getVoiceTipCount() {
        if (voiceTips != null) {
            return voiceTips.size();
        }
        return 0;
    }
}
