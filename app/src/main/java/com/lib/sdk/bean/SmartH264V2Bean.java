package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author hws
 * @name M-Cam_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class describe
 * @time 2019-04-09 10:38
 */
public class SmartH264V2Bean {
    @JSONField(name = "Smart264PlusV2")
    private List<Smart264PlusV2> smart264PlusV2List;
    @JSONField(name = "Smart264V2")
    private List<Smart264V2> smart264V2List;

    public List<Smart264V2> getSmart264V2List() {
        return smart264V2List;
    }

    public void setSmart264V2List(List<Smart264V2> smart264V2List) {
        this.smart264V2List = smart264V2List;
    }

    public List<Smart264PlusV2> getSmart264PlusV2List() {
        return smart264PlusV2List;
    }

    public void setSmart264PlusV2List(List<Smart264PlusV2> smart264PlusV2List) {
        this.smart264PlusV2List = smart264PlusV2List;
    }

    public class Smart264PlusV2 {
        @JSONField(name = "SmartH264Plus")
        private int smartH264Plus;

        public int getSmartH264Plus() {
            return smartH264Plus;
        }

        public void setSmartH264Plus(int smartH264Plus) {
            this.smartH264Plus = smartH264Plus;
        }
    }

    public class Smart264V2 {
        @JSONField(name = "SmartH264")
        private boolean smartH264;

        public boolean isSmartH264() {
            return smartH264;
        }

        public void setSmartH264(boolean smartH264) {
            this.smartH264 = smartH264;
        }
    }
}
