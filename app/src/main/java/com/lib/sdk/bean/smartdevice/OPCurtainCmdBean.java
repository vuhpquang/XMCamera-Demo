package com.lib.sdk.bean.smartdevice;

import com.alibaba.fastjson.annotation.JSONField;
import com.lib.sdk.bean.HandleConfigData;

public class OPCurtainCmdBean {
	public static final String JSON_NAME = "OPConsumerProCmd";
    public static final String CMD_NAME = "ChangeCurtainState";
	public static final int JSON_ID = 2046;
    @JSONField(name = "Cmd")
	private String cmd = CMD_NAME;
    @JSONField(name = "Arg1")
    private String arg1;
	@JSONField(name = "SensorState")
    private SensorState sensorState;
	
	@JSONField(serialize = false)
	public static String getCmdJson(String arg1,int command) {
		OPCurtainCmdBean bean = new OPCurtainCmdBean();
		bean.setArg1(arg1);
        SensorState sensorState = bean.new SensorState();
        sensorState.setCommand(command);
		bean.setSensorState(sensorState);
		return HandleConfigData.getSendData(JSON_NAME, "0x01", bean);
	}

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public SensorState getSensorState() {
        return sensorState;
    }

    public void setSensorState(SensorState sensorState) {
        this.sensorState = sensorState;
    }

    class SensorState {
	    @JSONField(name = "Command")
	    private int command;

        public int getCommand() {
            return command;
        }

        public void setCommand(int command) {
            this.command = command;
        }
    }
}
