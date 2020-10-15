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
public class Cpcrule  implements Serializable{


    @JSONField(name = "Countmax")
    private int countmax;//最大目标数[1~15],
    @JSONField(name = "EnterDirection")
    private int enterdirection;//进入的方向

    private String flag;//标志位，用来判断进出，默认设0

    private List<Points> points;//检测规则，需要画满4个点

    private int sensitivity;//灵敏度档位

    private int sizemax;//最大像距(sizemin, height/2)

    private int sizemin;//最小像距(0,height/2)

    public Cpcrule() {
    }

    @JSONField(name = "Countmax")
    public void setCountmax(int countmax) {
        this.countmax = countmax;
    }

    @JSONField(name = "Countmax")
    public int getCountmax() {
        return countmax;
    }

    @JSONField(name = "EnterDirection")
    public void setEnterdirection(int enterdirection) {
        this.enterdirection = enterdirection;
    }

    @JSONField(name = "EnterDirection")
    public int getEnterdirection() {
        return enterdirection;
    }

    @JSONField(name = "Flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @JSONField(name = "Flag")
    public String getFlag() {
        return flag;
    }

    @JSONField(name = "Points")
    public void setPoints(List<Points> points) {
        this.points = points;
    }

    @JSONField(name = "Points")
    public List<Points> getPoints() {
        return points;
    }

    @JSONField(name = "Sensitivity")
    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    @JSONField(name = "Sensitivity")
    public int getSensitivity() {
        return sensitivity;
    }

    @JSONField(name = "Sizemax")
    public void setSizemax(int sizemax) {
        this.sizemax = sizemax;
    }

    @JSONField(name = "Sizemax")
    public int getSizemax() {
        return sizemax;
    }

    @JSONField(name = "Sizemin")
    public void setSizemin(int sizemin) {
        this.sizemin = sizemin;
    }

    @JSONField(name = "Sizemin")
    public int getSizemin() {
        return sizemin;
    }

//    @Override
//    public String toString() {
//        return "Cpcrule{" +
//                "countmax=" + countmax +
//                ", enterdirection=" + enterdirection +
//                ", flag='" + flag + '\'' +
//                ", points=" + points +
//                ", sensitivity=" + sensitivity +
//                ", sizemax=" + sizemax +
//                ", sizemin=" + sizemin +
//                '}';
//    }

}