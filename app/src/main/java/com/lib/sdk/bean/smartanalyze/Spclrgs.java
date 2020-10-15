package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Spclrgs  implements Serializable{


    private String name;//区域名称

    private Oscrg oscrg;//要检测区域定义

    private Subrga subrga;//检测区域中的无效子区域

    private Subrgb subrgb;

    private Subrgc subrgc;

    private int valid;//是否有效

    public Spclrgs() {
    }

    @JSONField(name = "Name")
    public void setName(String name) {
         this.name = name;
     }
     
     @JSONField(name = "Name")
     public String getName() {
         return name;
     }

     @JSONField(name = "OscRg")
    public void setOscrg(Oscrg oscrg) {
         this.oscrg = oscrg;
     }

     @JSONField(name = "OscRg")
     public Oscrg getOscrg() {
         return oscrg;
     }

     @JSONField(name = "SubRgA")
    public void setSubrga(Subrga subrga) {
         this.subrga = subrga;
     }

     @JSONField(name = "SubRgA")
     public Subrga getSubrga() {
         return subrga;
     }

     @JSONField(name = "SubRgB")
    public void setSubrgb(Subrgb subrgb) {
         this.subrgb = subrgb;
     }

     @JSONField(name = "SubRgB")
     public Subrgb getSubrgb() {
         return subrgb;
     }

     @JSONField(name = "SubRgC")
    public void setSubrgc(Subrgc subrgc) {
         this.subrgc = subrgc;
     }

     @JSONField(name = "SubRgC")
     public Subrgc getSubrgc() {
         return subrgc;
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
//        return "Spclrgs{" +
//                "name='" + name + '\'' +
//                ", oscrg=" + oscrg +
//                ", subrga=" + subrga +
//                ", subrgb=" + subrgb +
//                ", subrgc=" + subrgc +
//                ", valid=" + valid +
//                '}';
//    }

}