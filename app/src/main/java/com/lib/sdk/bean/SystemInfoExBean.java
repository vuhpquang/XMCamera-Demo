package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-10-09.
 */

public class SystemInfoExBean {
    public static final String JSON_NAME = "SystemInfoEx";
    public static final int CMD_ID = 1020;
    @JSONField(name = "McuVersion")
    private String mcuVersion;//单片机版本号

    public String getMcuVersion() {
        return mcuVersion;
    }

    public void setMcuVersion(String mcuVersion) {
        this.mcuVersion = mcuVersion;
    }
}
