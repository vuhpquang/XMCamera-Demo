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
public class Noparkingrule implements Serializable{


    private int cameratype;


    private Oscpara oscpara;


    private int scenetype;


    private List<Spclrgs> spclrgs;

    public Noparkingrule() {
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
//        return "Noparkingrule{" +
//                "cameratype=" + cameratype +
//                ", oscpara=" + oscpara +
//                ", scenetype=" + scenetype +
//                ", spclrgs=" + spclrgs +
//                '}';
//    }

}