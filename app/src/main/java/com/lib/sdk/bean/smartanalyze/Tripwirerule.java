package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Tripwirerule implements Serializable {


    private Limit limit;

    private List<Tripwire> tripwire;

    private int typehuman;

    private int typelimit;

    private int typevehicle;

    public Tripwirerule() {
    }


    @JSONField(name = "Limit")
    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    @JSONField(name = "Limit")
    public Limit getLimit() {
        return limit;
    }

    @JSONField(name = "TripWire")
    public void setTripwire(List<Tripwire> tripwire) {
        this.tripwire = tripwire;
    }

    @JSONField(name = "TripWire")
    public List<Tripwire> getTripwire() {
        return tripwire;
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
//        return "Tripwirerule{" +
//                "limit=" + limit +
//                ", tripwire=" + tripwire +
//                ", typehuman=" + typehuman +
//                ", typelimit=" + typelimit +
//                ", typevehicle=" + typevehicle +
//                '}';
//    }

}