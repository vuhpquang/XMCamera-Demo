package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-09-10.
 */

public class DevAppBindFlagBean {
    @JSONField(name = "BeBinded")
    private boolean beBinded;


    public boolean isBeBinded() {
        return beBinded;
    }

    public void setBeBinded(boolean beBinded) {
        this.beBinded = beBinded;
    }
}
