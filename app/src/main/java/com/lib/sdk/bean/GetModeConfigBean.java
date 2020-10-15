package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * jsonName :GetModeConfig<br/>
 * 获取当前设备【当前模式】下的智联设备信息<br/>
 * 注意：{@link ConsumerSensorAlarm}这个是获取当前设备下【所有的】智联设备信息
 */
public class GetModeConfigBean {
	public String CurMode;
	public String DefineName;
	
	@JSONField(name = "SensorDevCfgList")
	public List<GetAllDevListBean> SensorDevCfgList;
	
}
