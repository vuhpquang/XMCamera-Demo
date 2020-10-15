package com.lib.sdk.bean.smartdevice;

import com.alibaba.fastjson.annotation.JSONField;
import com.lib.sdk.bean.HandleConfigData;

public class OPConsumerProCmdBean2 {
	public static final String JSON_NAME = "OPConsumerProCmd";
	public static final int JSON_ID = 2046;
	public String Cmd;
	public String Arg1;
	public Arg2 Arg2;
	
	public class Arg2{
		public String sceneId;
		public int status;
	}

	@JSONField(serialize = false)
	public static String getCmdJson(String cmd,String arg1,String sceneId,int status) {
		OPConsumerProCmdBean2 bean = new OPConsumerProCmdBean2();
		bean.Cmd = cmd;
		bean.Arg1 = arg1;
		bean.Arg2 = bean.new Arg2();
		bean.Arg2.sceneId = sceneId;
		bean.Arg2.status = status;
		return HandleConfigData.getSendData(JSON_NAME, "0x01", bean);
	}
}
