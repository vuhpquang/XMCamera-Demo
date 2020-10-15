package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Ruleconfig implements Serializable{


    private Avdrule avdrule;//异常视频信号诊断配置

    private Cpcrule cpcrule;//人头计数算法配置

    private Oscrule oscrule;//物品盗移、滞留，非法停车配置

    private Pearule pearule;//周界检测与绊线配置

    public Ruleconfig() {
    }


    @JSONField(name = "AVDRule")
    public void setAvdrule(Avdrule avdrule) {
         this.avdrule = avdrule;
     }

     @JSONField(name = "AVDRule")
     public Avdrule getAvdrule() {
         return avdrule;
     }

     @JSONField(name = "CPCRule")
    public void setCpcrule(Cpcrule cpcrule) {
         this.cpcrule = cpcrule;
     }

     @JSONField(name = "CPCRule")
     public Cpcrule getCpcrule() {
         return cpcrule;
     }

     @JSONField(name = "OSCRule")
    public void setOscrule(Oscrule oscrule) {
         this.oscrule = oscrule;
     }

     @JSONField(name = "OSCRule")
     public Oscrule getOscrule() {
         return oscrule;
     }

     @JSONField(name = "PEARule")
    public void setPearule(Pearule pearule) {
         this.pearule = pearule;
     }

     @JSONField(name = "PEARule")
     public Pearule getPearule() {
         return pearule;
     }

//    @Override
//    public String toString() {
//        return "Ruleconfig{" +
//                "avdrule=" + avdrule +
//                ", cpcrule=" + cpcrule +
//                ", oscrule=" + oscrule +
//                ", pearule=" + pearule +
//                '}';
//    }
    
}