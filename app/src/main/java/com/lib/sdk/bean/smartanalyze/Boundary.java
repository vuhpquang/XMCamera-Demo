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
public class Boundary  implements Serializable {


    private int pointnum;////边界点数  有几边形，目前最多8变形


    private List<Points> points;

    public Boundary() {
    }


    @JSONField(name = "PointNum")
    public void setPointnum(int pointnum) {
        this.pointnum = pointnum;
    }

    @JSONField(name = "PointNum")
    public int getPointnum() {
        return pointnum;
    }

    @JSONField(name = "Points")
    public void setPoints(List<Points> points) {
        this.points = points;
    }

    @JSONField(name = "Points")
    public List<Points> getPoints() {
        return points;
    }

//    @Override
//    public String toString() {
//        return "Boundary{" +
//                "pointnum=" + pointnum +
//                ", points=" + points +
//                '}';
//    }

}