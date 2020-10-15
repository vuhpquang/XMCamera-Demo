package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author hws
 * @name M-Cam_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class 当前设备语言信息
 * @time 2019-03-21 10:04
 */
public class DevLanguageBean {
    @JSONField(name = "MultiLanguage")
    private List<String> multiLanguages;

    public List<String> getMultiLanguages() {
        return multiLanguages;
    }

    public void setMultiLanguages(List<String> multiLanguages) {
        this.multiLanguages = multiLanguages;
    }
}
