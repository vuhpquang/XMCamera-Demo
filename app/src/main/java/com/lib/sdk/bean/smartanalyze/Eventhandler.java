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
public class Eventhandler implements Serializable{

    @JSONField(name = "AlarmInfo")
    private String alarminfo;
    @JSONField(name = "AlarmOutEnable")
    private boolean alarmoutenable;
    @JSONField(name = "AlarmOutLatch")
    private int alarmoutlatch;
    @JSONField(name = "AlarmOutMask")
    private String alarmoutmask;
    @JSONField(name = "BeepEnable")
    private boolean beepenable;
    @JSONField(name = "EventLatch")
    private int eventlatch;
    @JSONField(name = "FTPEnable")
    private boolean ftpenable;
    @JSONField(name = "LogEnable")
    private boolean logenable;

    @JSONField(name = "MailEnable")
    private boolean mailenable;

    @JSONField(name = "MatrixEnable")
    private boolean matrixenable;

    @JSONField(name = "MatrixMask")
    private String matrixmask;

    @JSONField(name = "MessageEnable")
    private boolean messageenable;

    @JSONField(name = "MsgtoNetEnable")
    private boolean msgtonetenable;

    @JSONField(name = "MultimediaMsgEnable")
    private boolean multimediamsgenable;

    @JSONField(name = "PtzEnable")
    private boolean ptzenable;

    @JSONField(name = "PtzLink")
    private List<List<Object>>  ptzlink;

    @JSONField(name = "RecordEnable")
    private boolean recordenable;

    @JSONField(name = "RecordLatch")
    private int recordlatch;

    @JSONField(name = "RecordMask")
    private String recordmask;

    @JSONField(name = "ShortMsgEnable")
    private boolean shortmsgenable;

    @JSONField(name = "ShowInfo")
    private boolean showinfo;

    @JSONField(name = "ShowInfoMask")
    private String showinfomask;

    @JSONField(name = "SnapEnable")
    private boolean snapenable;

    @JSONField(name = "SnapShotMask")
    private String snapshotmask;

    @JSONField(name = "TimeSection")
    private List<List<String>> timesection;

    @JSONField(name = "TipEnable")
    private boolean tipenable;

    @JSONField(name = "TourEnable")
    private boolean tourenable;

    @JSONField(name = "TourMask")
    private String tourmask;

    @JSONField(name = "VoiceEnable")
    private boolean voiceenable;

    public Eventhandler() {
    }

    @JSONField(name = "AlarmInfo")
    public void setAlarminfo(String alarminfo) {
        this.alarminfo = alarminfo;
    }

    @JSONField(name = "AlarmInfo")
    public String getAlarminfo() {
        return alarminfo;
    }

    @JSONField(name = "AlarmOutEnable")
    public void setAlarmoutenable(boolean alarmoutenable) {
        this.alarmoutenable = alarmoutenable;
    }

    @JSONField(name = "AlarmOutEnable")
    public boolean getAlarmoutenable() {
        return alarmoutenable;
    }

    @JSONField(name = "AlarmOutLatch")
    public void setAlarmoutlatch(int alarmoutlatch) {
        this.alarmoutlatch = alarmoutlatch;
    }

    @JSONField(name = "AlarmOutLatch")
    public int getAlarmoutlatch() {
        return alarmoutlatch;
    }

    public void setAlarmoutmask(String alarmoutmask) {
        this.alarmoutmask = alarmoutmask;
    }

    public String getAlarmoutmask() {
        return alarmoutmask;
    }

    public void setBeepenable(boolean beepenable) {
        this.beepenable = beepenable;
    }

    public boolean getBeepenable() {
        return beepenable;
    }

    @JSONField(name = "EventLatch")
    public void setEventlatch(int eventlatch) {
        this.eventlatch = eventlatch;
    }

    @JSONField(name = "EventLatch")
    public int getEventlatch() {
        return eventlatch;
    }

    @JSONField(name = "FTPEnable")
    public void setFtpenable(boolean ftpenable) {
        this.ftpenable = ftpenable;
    }

    @JSONField(name = "FTPEnable")
    public boolean getFtpenable() {
        return ftpenable;
    }

    @JSONField(name = "LogEnable")
    public void setLogenable(boolean logenable) {
        this.logenable = logenable;
    }

    @JSONField(name = "LogEnable")
    public boolean getLogenable() {
        return logenable;
    }

    public void setMailenable(boolean mailenable) {
        this.mailenable = mailenable;
    }

    public boolean getMailenable() {
        return mailenable;
    }

    public void setMatrixenable(boolean matrixenable) {
        this.matrixenable = matrixenable;
    }

    public boolean getMatrixenable() {
        return matrixenable;
    }

    public void setMatrixmask(String matrixmask) {
        this.matrixmask = matrixmask;
    }

    public String getMatrixmask() {
        return matrixmask;
    }

    public void setMessageenable(boolean messageenable) {
        this.messageenable = messageenable;
    }

    public boolean getMessageenable() {
        return messageenable;
    }

    public void setMsgtonetenable(boolean msgtonetenable) {
        this.msgtonetenable = msgtonetenable;
    }

    public boolean getMsgtonetenable() {
        return msgtonetenable;
    }

    public void setMultimediamsgenable(boolean multimediamsgenable) {
        this.multimediamsgenable = multimediamsgenable;
    }

    public boolean getMultimediamsgenable() {
        return multimediamsgenable;
    }

    public void setPtzenable(boolean ptzenable) {
        this.ptzenable = ptzenable;
    }

    public boolean getPtzenable() {
        return ptzenable;
    }

    public void setPtzlink(List<List<Object>> ptzlink) {
        this.ptzlink = ptzlink;
    }

    public List<List<Object>>  getPtzlink() {
        return ptzlink;
    }

    public void setRecordenable(boolean recordenable) {
        this.recordenable = recordenable;
    }

    public boolean getRecordenable() {
        return recordenable;
    }

    public void setRecordlatch(int recordlatch) {
        this.recordlatch = recordlatch;
    }

    public int getRecordlatch() {
        return recordlatch;
    }

    public void setRecordmask(String recordmask) {
        this.recordmask = recordmask;
    }

    public String getRecordmask() {
        return recordmask;
    }

    public void setShortmsgenable(boolean shortmsgenable) {
        this.shortmsgenable = shortmsgenable;
    }

    public boolean getShortmsgenable() {
        return shortmsgenable;
    }

    public void setShowinfo(boolean showinfo) {
        this.showinfo = showinfo;
    }

    public boolean getShowinfo() {
        return showinfo;
    }

    public void setShowinfomask(String showinfomask) {
        this.showinfomask = showinfomask;
    }

    public String getShowinfomask() {
        return showinfomask;
    }

    public void setSnapenable(boolean snapenable) {
        this.snapenable = snapenable;
    }

    public boolean getSnapenable() {
        return snapenable;
    }

    public void setSnapshotmask(String snapshotmask) {
        this.snapshotmask = snapshotmask;
    }

    public String getSnapshotmask() {
        return snapshotmask;
    }

    public void setTimesection(List<List<String>> timesection) {
        this.timesection = timesection;
    }

    public List<List<String>> getTimesection() {
        return timesection;
    }

    public void setTipenable(boolean tipenable) {
        this.tipenable = tipenable;
    }

    public boolean getTipenable() {
        return tipenable;
    }

    public void setTourenable(boolean tourenable) {
        this.tourenable = tourenable;
    }

    public boolean getTourenable() {
        return tourenable;
    }

    public void setTourmask(String tourmask) {
        this.tourmask = tourmask;
    }

    public String getTourmask() {
        return tourmask;
    }

    public void setVoiceenable(boolean voiceenable) {
        this.voiceenable = voiceenable;
    }

    public boolean getVoiceenable() {
        return voiceenable;
    }

//    @Override
//    public String toString() {
//        return "Eventhandler{" +
//                "alarminfo='" + alarminfo + '\'' +
//                ", alarmoutenable=" + alarmoutenable +
//                ", alarmoutlatch=" + alarmoutlatch +
//                ", alarmoutmask='" + alarmoutmask + '\'' +
//                ", beepenable=" + beepenable +
//                ", eventlatch=" + eventlatch +
//                ", ftpenable=" + ftpenable +
//                ", logenable=" + logenable +
//                ", mailenable=" + mailenable +
//                ", matrixenable=" + matrixenable +
//                ", matrixmask='" + matrixmask + '\'' +
//                ", messageenable=" + messageenable +
//                ", msgtonetenable=" + msgtonetenable +
//                ", multimediamsgenable=" + multimediamsgenable +
//                ", ptzenable=" + ptzenable +
//                ", ptzlink=" + ptzlink +
//                ", recordenable=" + recordenable +
//                ", recordlatch=" + recordlatch +
//                ", recordmask='" + recordmask + '\'' +
//                ", shortmsgenable=" + shortmsgenable +
//                ", showinfo=" + showinfo +
//                ", showinfomask='" + showinfomask + '\'' +
//                ", snapenable=" + snapenable +
//                ", snapshotmask='" + snapshotmask + '\'' +
//                ", timesection=" + timesection +
//                ", tipenable=" + tipenable +
//                ", tourenable=" + tourenable +
//                ", tourmask='" + tourmask + '\'' +
//                ", voiceenable=" + voiceenable +
//                '}';
//    }

}