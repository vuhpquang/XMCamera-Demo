package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class EventHandler {
	public int AlarmOutLatch;
	public int EventLatch;
	public int RecordLatch;
	public boolean MailEnable;
	public boolean MessageEnable;
	public boolean MsgtoNetEnable;
	public boolean BeepEnable;
	public boolean LogEnable;
	public boolean ShowInfo;
	public boolean ShortMsgEnable;
	public boolean MultimediaMsgEnable;
	public boolean VoiceEnable;
	public boolean AlarmOutEnable;
	public boolean MatrixEnable;
	public boolean TipEnable;
	public boolean FTPEnable;
	public boolean PtzEnable;
	public boolean TourEnable;
	public boolean RecordEnable;
	public boolean SnapEnable;
	public String SnapShotMask;
	public String TourMask;
	public String AlarmOutMask;
	public String RecordMask;
	public String ShowInfoMask;
	public String MatrixMask;
	public String AlarmInfo;
	public Object[][] PtzLink;
	public String[][] TimeSection; //[7][6] ，第一维表示周日~周一7天，第二维的第1个表示全天报警，后5个表示5种自定义报警
	@JSONField(serialize = false)
	public EventHandler clone() {
		EventHandler eventHandler = new EventHandler();
		eventHandler.AlarmOutLatch = AlarmOutLatch;
		eventHandler.EventLatch = EventLatch;
		eventHandler.RecordLatch = RecordLatch;
		eventHandler.MailEnable = MailEnable;
		eventHandler.MessageEnable = MessageEnable;
		eventHandler.MsgtoNetEnable = MsgtoNetEnable;
		eventHandler.BeepEnable = BeepEnable;
		eventHandler.LogEnable = LogEnable;
		eventHandler.ShowInfo = ShowInfo;
		eventHandler.ShortMsgEnable = ShortMsgEnable;
		eventHandler.MultimediaMsgEnable = MultimediaMsgEnable;
		eventHandler.VoiceEnable = VoiceEnable;
		eventHandler.AlarmOutEnable = AlarmOutEnable;
		eventHandler.MatrixEnable = MatrixEnable;
		eventHandler.TipEnable = TipEnable;
		eventHandler.FTPEnable = FTPEnable;
		eventHandler.PtzEnable = PtzEnable;
		eventHandler.TourEnable = TourEnable;
		eventHandler.RecordEnable = RecordEnable;
		eventHandler.SnapEnable = SnapEnable;
		eventHandler.SnapShotMask = SnapShotMask;
		eventHandler.TourMask = TourMask;
		eventHandler.AlarmOutMask = AlarmOutMask;
		eventHandler.RecordMask = RecordMask;
		eventHandler.ShowInfoMask = ShowInfoMask;
		eventHandler.MatrixMask = MatrixMask;
		eventHandler.AlarmInfo = AlarmInfo;
		eventHandler.PtzLink = PtzLink != null ? PtzLink.clone() : null;
		eventHandler.TimeSection = TimeSection != null ? TimeSection.clone() : null; //[7][6] ，第一维表示周日~周一7天，第二维的第1个表示全天报警，后5个表示5种自定义报警
		return eventHandler;
	}
}
