package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @class 一键呼叫
 * @time 2019-09-24 8:38
 */
public class AlarmRemoteCallBean {
    public static final String JSON_NAME = "Alarm.RemoteCall";
    @JSONField(name = "RemoteCallEenble")
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
