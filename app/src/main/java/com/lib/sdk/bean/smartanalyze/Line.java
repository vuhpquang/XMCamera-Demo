package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Line implements Serializable{


    private Endpt endpt;


    private Startpt startpt;

    public Line() {
        endpt = new Endpt();
        startpt = new Startpt();
    }


    @JSONField(name = "EndPt")
    public void setEndpt(Endpt endpt) {
        this.endpt = endpt;
    }

    @JSONField(name = "EndPt")
    public Endpt getEndpt() {
        return endpt;
    }

    @JSONField(name = "StartPt")
    public void setStartpt(Startpt startpt) {
        this.startpt = startpt;
    }

    @JSONField(name = "StartPt")
    public Startpt getStartpt() {
        return startpt;
    }

//    @Override
//    public String toString() {
//        return "Line{" +
//                "endpt=" + endpt +
//                ", startpt=" + startpt +
//                '}';
//    }

}