package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Pearule implements Serializable {


    private int level;//警戒级别 2：低级；1：中级；0: 高级

    private int perimeterenable; //周界规则使能 0：关闭；1：开启

    private Perimeterrule perimeterrule;//周界规则

    private int showrule;//是否显示规则

    private int showtrack;//是否显示轨迹

    private int tripwireenable;//单绊线规则使能

    private Tripwirerule tripwirerule;//单绊线规则

    public Pearule() {
    }


    @JSONField(name = "Level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JSONField(name = "Level")
    public int getLevel() {
        return level;
    }

    @JSONField(name = "PerimeterEnable")
    public void setPerimeterenable(int perimeterenable) {
        this.perimeterenable = perimeterenable;
    }

    @JSONField(name = "PerimeterEnable")
    public int getPerimeterenable() {
        return perimeterenable;
    }

    @JSONField(name = "PerimeterRule")
    public void setPerimeterrule(Perimeterrule perimeterrule) {
        this.perimeterrule = perimeterrule;
    }

    @JSONField(name = "PerimeterRule")
    public Perimeterrule getPerimeterrule() {
        return perimeterrule;
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

    @JSONField(name = "TripWireEnable")
    public void setTripwireenable(int tripwireenable) {
        this.tripwireenable = tripwireenable;
    }

    @JSONField(name = "TripWireEnable")
    public int getTripwireenable() {
        return tripwireenable;
    }

    @JSONField(name = "TripWireRule")
    public void setTripwirerule(Tripwirerule tripwirerule) {
        this.tripwirerule = tripwirerule;
    }

    @JSONField(name = "TripWireRule")
    public Tripwirerule getTripwirerule() {
        return tripwirerule;
    }

//    @Override
//    public String toString() {
//        return "Pearule{" +
//                "level=" + level +
//                ", perimeterenable=" + perimeterenable +
//                ", perimeterrule=" + perimeterrule +
//                ", showrule=" + showrule +
//                ", showtrack=" + showtrack +
//                ", tripwireenable=" + tripwireenable +
//                ", tripwirerule=" + tripwirerule +
//                '}';
//    }


}