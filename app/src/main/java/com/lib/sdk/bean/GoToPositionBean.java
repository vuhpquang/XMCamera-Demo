package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-09-13.
 *获取总步数
 */

public class GoToPositionBean {
    public static final String JSON_NAME = "GoToPosition";
    public static final int CMD_ID = 1360;
    @JSONField(name = "HorSteps")
    private int horSteps;//横向总步数
    @JSONField(name = "VerSteps")
    private int verSteps;//纵向总步数
    @JSONField(name = "HorStart")
    private int horStart;//横向开始位置偏移（步数）
    @JSONField(name = "VerStart")
    private int verStart;//纵向开始位置偏移（步数）
    @JSONField(name = "HorNow")
    private int horNow;//横向当前位置,相对起始位置的偏移
    @JSONField(name = "VerNow")
    private int verNow;//纵向当前位置，相对起始位置的偏移
    public int getHorSteps() {
        return horSteps;
    }

    public void setHorSteps(int horSteps) {
        this.horSteps = horSteps;
    }

    public int getVerSteps() {
        return verSteps;
    }

    public void setVerSteps(int verSteps) {
        this.verSteps = verSteps;
    }

    public int getHorStart() {
        return horStart;
    }

    public void setHorStart(int horStart) {
        this.horStart = horStart;
    }

    public int getVerStart() {
        return verStart;
    }

    public void setVerStart(int verStart) {
        this.verStart = verStart;
    }

    public int getHorNow() {
        return horNow;
    }

    public void setHorNow(int horNow) {
        this.horNow = horNow;
    }

    public int getVerNow() {
        return verNow;
    }

    public void setVerNow(int verNow) {
        this.verNow = verNow;
    }
}
