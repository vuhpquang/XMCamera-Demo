package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @name iCSee_Pro_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class 设置语言
 * @time 2019-04-02 11:54
 */
public class BrowserLanguageBean {
    /**
     * {@link com.xworld.utils.DevLanguageUtils}
     */
    @JSONField(name = "BrowserLanguageType")
    private int browserLanguageType;////传的枚举

    public int getBrowserLanguageType() {
        return browserLanguageType;
    }

    public void setBrowserLanguageType(int browserLanguageType) {
        this.browserLanguageType = browserLanguageType;
    }
}
