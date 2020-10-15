package com.lib.sdk.bean;

/**
 * Created by Administrator on 2017-07-20.
 */

public class OPPlayBackBean{
    public String Action;
    public Parameter Parameter = new Parameter();
    public String StartTime;
    public String EndTime;
    public int StreamType;

    public class Parameter {
        public String FileName;
        public String TransMode;
        public String PlayMode;
        public int Value;
        public String IntelligentPlayBackEvent;//要正常速度回放的事件掩码
        public int IntelligentPlayBackSpeed;//快放事件回放速度 0:  2:  4:  6:  8 0表示该通道没开启
    }

}
