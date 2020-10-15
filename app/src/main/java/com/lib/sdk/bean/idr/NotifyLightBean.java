package com.lib.sdk.bean.idr;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-07-26.
 * 呼吸灯控制
 */

public class NotifyLightBean {
    private static final String JSON_NAME = "Consumer.NotifyLight";
    @JSONField(name = "Enable")
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
