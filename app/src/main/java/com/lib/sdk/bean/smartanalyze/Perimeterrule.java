package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Perimeterrule implements Serializable {


    private Limitpara limitpara;////目标类型限?

    private int mode;//周界模式

    private int typehuman;//目标类别：人(限定类型时使用) *

    private int typelimit;//目标类型限制

    private int typevehicle;//目标类别：车

    public Perimeterrule() {
    }


    @JSONField(name = "LimitPara")
    public void setLimitpara(Limitpara limitpara) {
        this.limitpara = limitpara;
    }

    @JSONField(name = "LimitPara")
    public Limitpara getLimitpara() {
        return limitpara;
    }

    @JSONField(name = "Mode")
    public void setMode(int mode) {
        this.mode = mode;
    }

    @JSONField(name = "Mode")
    public int getMode() {
        return mode;
    }

    @JSONField(name = "TypeHuman")
    public void setTypehuman(int typehuman) {
        this.typehuman = typehuman;
    }

    @JSONField(name = "TypeHuman")
    public int getTypehuman() {
        return typehuman;
    }

    @JSONField(name = "TypeLimit")
    public void setTypelimit(int typelimit) {
        this.typelimit = typelimit;
    }

    @JSONField(name = "TypeLimit")
    public int getTypelimit() {
        return typelimit;
    }

    @JSONField(name = "TypeVehicle")
    public void setTypevehicle(int typevehicle) {
        this.typevehicle = typevehicle;
    }

    @JSONField(name = "TypeVehicle")
    public int getTypevehicle() {
        return typevehicle;
    }

//    @Override
//    public String toString() {
//        return "Perimeterrule{" +
//                "limitpara=" + limitpara +
//                ", mode=" + mode +
//                ", typehuman=" + typehuman +
//                ", typelimit=" + typelimit +
//                ", typevehicle=" + typevehicle +
//                '}';
//    }

}