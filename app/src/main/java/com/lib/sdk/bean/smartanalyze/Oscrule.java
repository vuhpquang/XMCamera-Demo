package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Oscrule  implements Serializable {


    private int abandumenable;//物品遗留使能

    private Abandumrule abandumrule;//物品遗留参数

    private int level;//警戒级别  2：低级；1：中级；0: 高级

    private int noparkingenable;//非法停车使能 0：关闭；1：开启；

    private Noparkingrule noparkingrule;//非法停车参数，同物品遗留参数一样

    private int showrule;//是否显示规则

    private int showtrack;//是否显示轨迹

    private int stolenenable;//物品被盗使能

    private Stolenrule stolenrule;//参考物品遗留参数

    public Oscrule() {
    }

    @JSONField(name = "AbandumEnable")
    public void setAbandumenable(int abandumenable) {
        this.abandumenable = abandumenable;
    }

    @JSONField(name = "AbandumEnable")
    public int getAbandumenable() {
        return abandumenable;
    }

    @JSONField(name = "AbandumRule")
    public void setAbandumrule(Abandumrule abandumrule) {
        this.abandumrule = abandumrule;
    }

    @JSONField(name = "AbandumRule")
    public Abandumrule getAbandumrule() {
        return abandumrule;
    }

    @JSONField(name = "Level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JSONField(name = "Level")
    public int getLevel() {
        return level;
    }

    @JSONField(name = "NoParkingEnable")
    public void setNoparkingenable(int noparkingenable) {
        this.noparkingenable = noparkingenable;
    }

    @JSONField(name = "NoParkingEnable")
    public int getNoparkingenable() {
        return noparkingenable;
    }

    @JSONField(name = "NoParkingRule")
    public void setNoparkingrule(Noparkingrule noparkingrule) {
        this.noparkingrule = noparkingrule;
    }

    @JSONField(name = "NoParkingRule")
    public Noparkingrule getNoparkingrule() {
        return noparkingrule;
    }

    @JSONField(name = "ShowRule")
    public void setShowrule(int showrule) {
        this.showrule = showrule;
    }

    @JSONField(name = "ShowRule")
    public int getShowrule() {
        return showrule;
    }

    @JSONField(name = "ShowTrack")
    public void setShowtrack(int showtrack) {
        this.showtrack = showtrack;
    }

    @JSONField(name = "ShowTrack")
    public int getShowtrack() {
        return showtrack;
    }

    @JSONField(name = "StolenEnable")
    public void setStolenenable(int stolenenable) {
        this.stolenenable = stolenenable;
    }

    @JSONField(name = "StolenEnable")
    public int getStolenenable() {
        return stolenenable;
    }

    @JSONField(name = "StolenRule")
    public void setStolenrule(Stolenrule stolenrule) {
        this.stolenrule = stolenrule;
    }

    @JSONField(name = "StolenRule")
    public Stolenrule getStolenrule() {
        return stolenrule;
    }

//    @Override
//    public String toString() {
//        return "Oscrule{" +
//                "abandumenable=" + abandumenable +
//                ", abandumrule=" + abandumrule +
//                ", level=" + level +
//                ", noparkingenable=" + noparkingenable +
//                ", noparkingrule=" + noparkingrule +
//                ", showrule=" + showrule +
//                ", showtrack=" + showtrack +
//                ", stolenenable=" + stolenenable +
//                ", stolenrule=" + stolenrule +
//                '}';
//    }

}