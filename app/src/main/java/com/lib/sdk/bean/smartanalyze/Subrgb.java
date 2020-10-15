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
public class Subrgb implements Serializable{


    private int pointnu;

    private List<Points> points;

    private int valid;

    public Subrgb() {
    }


    @JSONField(name = "PointNu")
    public void setPointnu(int pointnu) {
        this.pointnu = pointnu;
    }

    @JSONField(name = "PointNu")
    public int getPointnu() {
        return pointnu;
    }

    @JSONField(name = "Points")
    public void setPoints(List<Points> points) {
        this.points = points;
    }

    @JSONField(name = "Points")
    public List<Points> getPoints() {
        return points;
    }

    @JSONField(name = "Valid")
    public void setValid(int valid) {
        this.valid = valid;
    }

    @JSONField(name = "Valid")
    public int getValid() {
        return valid;
    }

//    @Override
//    public String toString() {
//        return "Subrgb{" +
//                "pointnu=" + pointnu +
//                ", points=" + points +
//                ", valid=" + valid +
//                '}';
//    }

}