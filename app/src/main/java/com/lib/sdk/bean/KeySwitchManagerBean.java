package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-06-05.
 * 按键管理
 */

public class KeySwitchManagerBean {
    @JSONField(name = "LongPress")
    private LongPress longPress;
    @JSONField(name = "ShortPress")
    private ShortPress shortPress;
    public LongPress getLongPress() {
        return longPress;
    }

    public void setLongPress(LongPress longPress) {
        this.longPress = longPress;
    }

    public ShortPress getShortPress() {
        return shortPress;
    }

    public void setShortPress(ShortPress shortPress) {
        this.shortPress = shortPress;
    }

    public class LongPress {
        @JSONField(name = "Enable")
        private boolean enable;
        @JSONField(name = "HintTone")
        private boolean hintTone;
        @JSONField(name = "RecordEnable")
        private boolean recordEnable;
        @JSONField(name = "SnapEnable")
        private boolean snapEnable;
        @JSONField(name = "APEnable")
        private boolean apEnable;
        public boolean isEnable() {
            return enable;
        }
        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public boolean isHintTone() {
            return hintTone;
        }

        public void setHintTone(boolean hintTone) {
            this.hintTone = hintTone;
        }

        public boolean isRecordEnable() {
            return recordEnable;
        }

        public void setRecordEnable(boolean recordEnable) {
            this.recordEnable = recordEnable;
        }

        public boolean isSnapEnable() {
            return snapEnable;
        }

        public void setSnapEnable(boolean snapEnable) {
            this.snapEnable = snapEnable;
        }

        public boolean isApEnable() {
            return apEnable;
        }

        public void setApEnable(boolean apEnable) {
            this.apEnable = apEnable;
        }
    }

    public class ShortPress {
        @JSONField(name = "Enable")
        private boolean enable;
        @JSONField(name = "HintTone")
        private boolean hintTone;
        @JSONField(name = "RecordEnable")
        private boolean recordEnable;
        @JSONField(name = "SnapEnable")
        private boolean snapEnable;
        @JSONField(name = "MessagePushEnable")
        private boolean messagePushEnable;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public boolean isHintTone() {
            return hintTone;
        }

        public void setHintTone(boolean hintTone) {
            this.hintTone = hintTone;
        }

        public boolean isRecordEnable() {
            return recordEnable;
        }

        public void setRecordEnable(boolean recordEnable) {
            this.recordEnable = recordEnable;
        }

        public boolean isSnapEnable() {
            return snapEnable;
        }

        public void setSnapEnable(boolean snapEnable) {
            this.snapEnable = snapEnable;
        }

        public boolean isMessagePushEnable() {
            return messagePushEnable;
        }

        public void setMessagePushEnable(boolean messagePushEnable) {
            this.messagePushEnable = messagePushEnable;
        }
    }
}
