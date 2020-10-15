package com.lib.sdk.bean.smartanalyze;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Endpt implements Serializable{

    private int x;
    private int y;

    public Endpt() {
    }

    public Endpt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
         this.x = x;
     }
     public int getX() {
         return x;
     }

    public void setY(int y) {
         this.y = y;
     }
     public int getY() {
         return y;
     }

//    @Override
//    public String toString() {
//        return "Endpt{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
//    }

}