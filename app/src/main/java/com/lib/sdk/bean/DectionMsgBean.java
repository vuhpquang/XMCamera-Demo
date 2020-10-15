package com.lib.sdk.bean;

public class DectionMsgBean {
	private long time; // 毫秒
	private String content;

	public DectionMsgBean() {

	}

	public DectionMsgBean(long time, String content) {
		this.time = time;
		this.content = content;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
