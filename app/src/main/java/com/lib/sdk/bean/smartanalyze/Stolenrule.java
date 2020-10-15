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
public class Stolenrule  implements Serializable {


    private int cameratype;//相机类型

    private Oscpara oscpara;//一些约束

    private int scenetype;//场景类型

    private List<Spclrgs> spclrgs;//要处理的区域个数

    public Stolenrule() {
    }



    @JSONField(name = "CameraType")
    public void setCameratype(int cameratype) {
         this.cameratype = cameratype;
     }

     @JSONField(name = "CameraType")
     public int getCameratype() {
         return cameratype;
     }

     @JSONField(name = "OscPara")
    public void setOscpara(Oscpara oscpara) {
         this.oscpara = oscpara;
     }

     @JSONField(name = "OscPara")
     public Oscpara getOscpara() {
         return oscpara;
     }

     @JSONField(name = "SceneType")
    public void setScenetype(int scenetype) {
         this.scenetype = scenetype;
     }

     @JSONField(name = "SceneType")
     public int getScenetype() {
         return scenetype;
     }

     @JSONField(name = "SpclRgs")
    public void setSpclrgs(List<Spclrgs> spclrgs) {
         this.spclrgs = spclrgs;
     }

     @JSONField(name = "SpclRgs")
     public List<Spclrgs> getSpclrgs() {
         return spclrgs;
     }

//    @Override
//    public String toString() {
//        return "Stolenrule{" +
//                "cameratype=" + cameratype +
//                ", oscpara=" + oscpara +
//                ", scenetype=" + scenetype +
//                ", spclrgs=" + spclrgs +
//                '}';
//    }


}