package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-07-04.
 * 一键遮蔽
 */

public class OPOneKeyMaskVideoBean {
    @JSONField(name = "Enable")
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
