package com.lib.sdk.bean.smartanalyze;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Points implements Serializable {

    private float x;
    private float y;

    public Points() {
    }

    public Points(float x, float y) {
        this.x = x;
        this.y = y;
    }



    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

//    @Override
//    public String toString() {
//        return "Points{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
//    }

}