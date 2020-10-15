package com.lib.sdk.bean;

/**
 *jsonName:SensorDevCfgList  ,与GetAllDevListBean有差别，勿混用<br/>
 * 为{@link ConsumerSensorAlarm}所使用<br/>
 * @see GetAllDevListBean
 */
public class SensorDevCfgList {

    public AlarmInfoBean ConsSensorAlarm;
    public String DevAddr;
    public String DevID;
    public String DevName;
    public int DevType;
    public boolean[] Status;
}
