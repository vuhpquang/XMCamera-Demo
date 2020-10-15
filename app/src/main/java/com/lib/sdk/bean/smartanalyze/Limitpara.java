package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Limitpara implements Serializable{


    @JSONField(name = "Boundary")
    private Boundary boundary;//周界限制参数

    @JSONField(name = "DirectionLimit")
    private int directionlimit;//是否做方向限制  0：双向；1：进入；2：离开

    @JSONField(name = "ForbiddenDirection")
    private int forbiddendirection;//禁止方向角度

    @JSONField(name = "MinDist")
    private int mindist;//最小像素距离

    @JSONField(name = "MinTime")
    private int mintime;//最短时间

    public Limitpara() {
    }

    @JSONField(name = "Boundary")
    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    @JSONField(name = "Boundary")
    public Boundary getBoundary() {
        return boundary;
    }

    @JSONField(name = "DirectionLimit")
    public void setDirectionlimit(int directionlimit) {
        this.directionlimit = directionlimit;
    }

    @JSONField(name = "DirectionLimit")
    public int getDirectionlimit() {
        return directionlimit;
    }

    @JSONField(name = "ForbiddenDirection")
    public void setForbiddendirection(int forbiddendirection) {
        this.forbiddendirection = forbiddendirection;
    }

    @JSONField(name = "ForbiddenDirection")
    public int getForbiddendirection() {
        return forbiddendirection;
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
//        return "Limitpara{" +
//                "boundary=" + boundary +
//                ", directionlimit=" + directionlimit +
//                ", forbiddendirection=" + forbiddendirection +
//                ", mindist=" + mindist +
//                ", mintime=" + mintime +
//                '}';
//    }
}