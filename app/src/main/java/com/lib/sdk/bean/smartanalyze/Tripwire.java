package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Tripwire implements Serializable {


    private int forbiddendir;//单绊线禁止方向角度(单位: 度)

    private int isdoubledir;//表示该绊线是否为双向绊线(0: 否, 1: 是)

    private Line line;//单绊线位置

    private int valid;//是否有效

    public Tripwire() {
    }


    @JSONField(name = "ForbiddenDir")
    public void setForbiddendir(int forbiddendir) {
        this.forbiddendir = forbiddendir;
    }

    @JSONField(name = "ForbiddenDir")
    public int getForbiddendir() {
        return forbiddendir;
    }

    @JSONField(name = "IsDoubleDir")
    public void setIsdoubledir(int isdoubledir) {
        this.isdoubledir = isdoubledir;
    }

    @JSONField(name = "IsDoubleDir")
    public int getIsdoubledir() {
        return isdoubledir;
    }

    @JSONField(name = "Line")
    public void setLine(Line line) {
        this.line = line;
    }

    @JSONField(name = "Line")
    public Line getLine() {
        return line == null ? line = new Line() : line;
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
//        return "Tripwire{" +
//                "forbiddendir=" + forbiddendir +
//                ", isdoubledir=" + isdoubledir +
//                ", line=" + line +
//                ", valid=" + valid +
//                '}';
//    }

}