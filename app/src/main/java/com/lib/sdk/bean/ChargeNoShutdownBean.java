package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @class 充电时是否休眠
 * @time 2019-08-19 15:50
 */
public class ChargeNoShutdownBean {
    public static final String JSON_NAEM = "Consumer.ChargeNoShutdown";
    @JSONField(name = "Enable")
    private boolean enable;//充电时是否休眠 默认 false 是充电时休眠

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
