package com.lib.sdk.bean.idr;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-07-25.
 * 关机控制
 */

public class ForceShutDownModeBean {
    public static final String JSON_NAME = "Consumer.ForceShutDownMode";
    @JSONField(name = "ShutDownMode")
    private int shutDownMode;

    public int getShutDownMode() {
        return shutDownMode;
    }

    public void setShutDownMode(int shutDownMode) {
        this.shutDownMode = shutDownMode;
    }
}
