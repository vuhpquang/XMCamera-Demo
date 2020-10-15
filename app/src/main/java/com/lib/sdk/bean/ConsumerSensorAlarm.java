package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


/**
 * jsonName :  Consumer.SensorAlarm  注意有点“.”  不是ConsSensorAlarm<br/>
 * 获取当前设备下【所有的】智联设备信息<br/>
 *
 * {@link GetModeConfigBean} 这个是获取当前设备【当前模式】下的智联设备信息<br/>
 */
public class ConsumerSensorAlarm {
    public List<String> CurMode;
    public List<String> DefineName;

    @JSONField(name = "SensorDevCfgList")
    public List<SensorDevCfgList> SensorDevCfgList;
}
