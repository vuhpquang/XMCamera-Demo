package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: AlarmInfoBean
 * @Description: TODO(报警配置)
 * @author xxy
 * @date 2016年3月19日 下午4:38:42
 * 
 */

public class AlarmInfoBean {

	public AlarmInfoBean() {

	}

	//灵敏度
	public int PirSensitive;
	public int Level;
	public boolean Enable;
	public EventHandler EventHandler = new EventHandler();

	public String[] Region;

	public float PIRCheckTime; //徘徊检测时间、PIR唤醒门铃时间

	public PirTimeSections PirTimeSection = new PirTimeSections();

	public class PirTimeSections {
		public PirTimeSection PirTimeSectionOne = new PirTimeSection();
		public PirTimeSection PirTimeSectionTwo = new PirTimeSection();
		public class PirTimeSection {
			public boolean Enable;//时间段开关
			public String StartTime;//开始时间点 格式 " hour:minute"
			public String EndTime;//结束
			public int WeekMask; //每一位代表一天, 最低位为周一 // 01111111
			@JSONField(serialize = false)
			public PirTimeSection clone() {
				PirTimeSection  pirTimeSection = new PirTimeSection();
				pirTimeSection.Enable = Enable;
				pirTimeSection.StartTime = StartTime;
				pirTimeSection.EndTime = EndTime;
				pirTimeSection.WeekMask = WeekMask;
				return pirTimeSection;
			}
		}
		@JSONField(serialize = false)
		public PirTimeSections clone() {
			PirTimeSections pirTimeSections = new PirTimeSections();
			pirTimeSections.PirTimeSectionOne = PirTimeSectionOne.clone();
			pirTimeSections.PirTimeSectionTwo = PirTimeSectionTwo.clone();
			return pirTimeSections;
		}
	}

	@JSONField(serialize = false)
	public AlarmInfoBean clone() {
		AlarmInfoBean alarmInfoBean = new AlarmInfoBean();
		alarmInfoBean.Level = Level;
		alarmInfoBean.Enable = Enable;
		alarmInfoBean.EventHandler = EventHandler.clone();
		alarmInfoBean.PIRCheckTime = PIRCheckTime;
		alarmInfoBean.Region = Region != null ? Region.clone() : null;
		alarmInfoBean.PirTimeSection = PirTimeSection.clone();
		return alarmInfoBean;
	}
}
