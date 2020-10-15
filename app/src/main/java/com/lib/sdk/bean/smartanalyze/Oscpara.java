package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Oscpara  implements Serializable {


    private int sizemax;//目标最大尺寸


    private int sizemin;//目标最小尺寸


    private int timemin;//时间约束

    public Oscpara() {
    }


    @JSONField(name = "SizeMax")
    public void setSizemax(int sizemax) {
        this.sizemax = sizemax;
    }

    @JSONField(name = "SizeMax")
    public int getSizemax() {
        return sizemax;
    }

    @JSONField(name = "SizeMin")
    public void setSizemin(int sizemin) {
        this.sizemin = sizemin;
    }

    @JSONField(name = "SizeMin")
    public int getSizemin() {
        return sizemin;
    }

    @JSONField(name = "TimeMin")
    public void setTimemin(int timemin) {
        this.timemin = timemin;
    }

    @JSONField(name = "TimeMin")
    public int getTimemin() {
        return timemin;
    }

//    @Override
//    public String toString() {
//        return "Oscpara{" +
//                "sizemax=" + sizemax +
//                ", sizemin=" + sizemin +
//                ", timemin=" + timemin +
//                '}';
//    }

}