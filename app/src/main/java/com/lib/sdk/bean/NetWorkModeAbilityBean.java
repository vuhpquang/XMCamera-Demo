package com.lib.sdk.bean;

/**
 * 新增网络模式，获取能力集名字
 * Created by hws on 2017-08-21.
 */

public class NetWorkModeAbilityBean {
    public static final String JSON_NAME = "NetWorkModeAbility";
    public static final int JSON_ID = 1360;
    public String Options;//掩码 （0x01 公网优先 0x02 局域网优先 0x03 局域网&公网 0x04 安防模式优先  0x07 所有模式 ）
}
