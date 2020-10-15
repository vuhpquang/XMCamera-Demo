package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author hws
 * @class 远程控制
 * @time 2019-11-22 13:24
 */
public class OPRemoteCtrlBean {
    private static final int CONVERT_PARAMETER = 8192;
    public static final int CMD_ID = 4000;
    public static final String JSON_NAME = "OPRemoteCtrl";
    @JSONField(name = "P1")
    private String parameter = "0x2";
    /**
     * 坐标点 高位是x，低位是y；例如 0x03fe03fd （1022，1021）
     */
    @JSONField(name = "P2")
    private String position;
    /**
     * 活动事件
     */
    @JSONField(name = "msg")
    private String actionEvent;

    @JSONField(serialize = false)
    private int positionX;
    @JSONField(serialize = false)
    private int positionY;
    @JSONField(serialize = false)
    private int moveX;
    @JSONField(serialize = false)
    private int moveY;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @JSONField(serialize = false)
    public void initPosition(int videoWith,int videoHeight,int wndWidth,int wndHeight) {
        positionX =  videoWith / 2;
        positionY = videoHeight / 2;

        if (positionX < 0) {
            positionX = 0;
        }

        if (positionY < 0) {
            positionY = 0;
        }

        this.position = "0x" + Long.toHexString((positionX << 16) + positionY);
    }

    @JSONField(serialize = false)
    public void setPosition(int moveX,int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;

        positionX += moveX;
        positionY += moveY;

        if (positionX < 0) {
            positionX = 0;
        }

        if (positionY < 0) {
            positionY = 0;
        }

        this.position = "0x" + Long.toHexString((positionX << 16) + positionY);
    }

    @JSONField(serialize = false)
    public void keepMove() {
        setPosition(moveX,moveY);
    }

    public String getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(String actionEvent) {
        this.actionEvent = actionEvent;
    }

    @JSONField(serialize = false)
    public void setActionEvent(int actionEvent) {
        this.actionEvent = "0x" + Long.toHexString(actionEvent);
    }

    /**
     * 远程控制事件类型
     */
    public class RemoteCtrlEventType {
        public static final int XM_FILE_WAKEUP = 0x010000;
        public static final int XM_MSG_GUI = 0x020000;
        public static final int XM_KEEPALIVE = 0x020001;
        public static final int XM_KEYDOWN = 0x020002;
        public static final int XM_KEYUP = 0x020003;
        public static final int XM_MOUSEFOUND = 0x020004;
        public static final int XM_MOUSELOST = 0x020005;
        public static final int XM_MOUSEMOVE = 0x020006;
        public static final int XM_MOUSEWHEEL = 0x020007;
        public static final int XM_LBUTTONDOWN = 0x020008;
        public static final int XM_LBUTTONUP = 0x020009;
        public static final int XM_LBUTTONDBLCLK = 0x02000a;
        public static final int XM_RBUTTONDOWN = 0x02000b;
        public static final int XM_RBUTTONUP = 0x02000c;
        public static final int XM_RBUTTONDBLCLK = 0x02000d;
        public static final int XM_MBUTTONDOWN = 0x02000e;
        public static final int XM_MBUTTONUP = 0x02000f;
        public static final int XM_MBUTTONDBLCLK = 0x020010;
        public static final int XM_DRAW = 0x020011;
        public static final int XM_SCROLL = 0x020012;
        public static final int XM_LIST = 0x020013;
        public static final int XM_NUMPAD = 0x020014;
        public static final int XM_CARET = 0x020015;
        public static final int XM_CHAR = 0x020016;
        public static final int XM_TIMER = 0x020017;
        public static final int XM_INPUTTYPE = 0x020018;
        public static final int XM_ACTIVATE = 0x020019;
        public static final int XM_DEACTIVATE = 0x02001a;
        public static final int XM_COUNTDOWN = 0x02001b;
        public static final int XM_SYSTEM_END = 0x02001c;
    }
}
