package com.lib.sdk.bean;

public class DetectionDevBean {



	public DetectionDevBean(String id,String name, int rightIcon, int type) {
		super();
		this.id = id;
		this.name = name;
		this.rightIcon = rightIcon;
		this.type = type;
	}


	public DetectionDevBean(String id,String name, String tips, String rightText, int type,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.tips = tips;
		this.rightText = rightText;
		this.type = type;
		this.status = status;
	}
	public DetectionDevBean(String id,String name, String tips, int type,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.tips = tips;
		this.type = type;
		this.status = status;
	}


	public DetectionDevBean(String id,String name, String tips, String rightText, int msgCount, int type,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.tips = tips;
		this.rightText = rightText;
		this.msgCount = msgCount;
		this.type = type;
		this.status = status;
	}



	
	public DetectionDevBean() {

	}
	
	public static final int SMART_BUTTON = 0xf0;  //大一点，免得跟已有的重合
	public String id;
	public String name;
	public String tips;
	public String rightText;
	public int msgCount = 0;
	public int rightIcon = 0;
	public boolean status = false; //开关状态   0关1开
	
	/**
	 * 默认智联按钮     设备、传感器类型  常量在DeviceWifiManager类
	 */
	public int type = SMART_BUTTON;
	
	
	
	public String getTips() {
		return tips;
	}


	public void setTips(String tips) {
		this.tips = tips;
	}


	public int getMsgCount() {
		return msgCount;
	}


	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	
	
	public boolean getStatus() {
		return status;
	}
	
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
