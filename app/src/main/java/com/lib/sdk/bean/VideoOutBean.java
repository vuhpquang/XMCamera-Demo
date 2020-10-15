package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @class 视频输出数据
 * @time 2019-11-22 13:19
 */
public class VideoOutBean {
    public static final String JSON_NAME = "fVideo.VideoOut";
    @JSONField(name = "Mode")
    private Mode mode;

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public class Mode {
        @JSONField(name = "Height")
        private int height;
        @JSONField(name = "Width")
        private int width;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
