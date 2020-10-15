package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Limit implements Serializable{


    private int mindist;


    private int mintime;

    public Limit() {
    }


    @JSONField(name = "MinDist")
    public void setMindist(int mindist) {
        this.mindist = mindist;
    }

    @JSONField(name = "MinDist")
    public int getMindist() {
        return mindist;
    }

    @JSONField(name = "MinTime")
    public void setMintime(int mintime) {
        this.mintime = mintime;
    }

    @JSONField(name = "MinTime")
    public int getMintime() {
        return mintime;
    }

//    @Override
//    public String toString() {
//        return "Limit{" +
//                "mindist=" + mindist +
//                ", mintime=" + mintime +
//                '}';
//    }

}