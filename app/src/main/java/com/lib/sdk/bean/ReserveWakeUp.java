package com.lib.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ccy on 2018-03-15.
 * 单向门铃 来电预约bean
 * {@link JsonConfig#IDR_RESERVE_WAKE_UP}
 */

public class ReserveWakeUp {
    //增删改查Action
    public static final String JSON_NAME = JsonConfig.IDR_RESERVE_WAKE_UP;
    public static final int JSON_ID = 3018; //req = 3018;rsp = 3019
    public static final String CMD_ADD = "AddReserveItem";
    public static final String CMD_MODIFY = "ChangeReserveItem";
    public static final String CMD_DELETE = "DeleteReserveItem";
    public static final String CMD_GET = "GetAllReserveItem";

    public String Action;

    public Parameter Parameter;


    public static class Parameter implements Parcelable {
        public String ID; //唯一ID
        public String Name;
        public String DateTime;
        public boolean Loop;//是否循环。true是每天循环一次，false是只执行一次
        public boolean PushMsg;//推送使能
        public boolean RecordEnable;//录像使能
        public boolean SnapEnable; //抓图使能
        public boolean DoorBellEnable;//响铃使能
        public Parameter() {

        }

        protected Parameter(Parcel in) {
            ID = in.readString();
            Name = in.readString();
            DateTime = in.readString();
            Loop = in.readByte() != 0;
            PushMsg = in.readByte() != 0;
            RecordEnable = in.readByte() != 0;
            SnapEnable = in.readByte() != 0;
            DoorBellEnable = in.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(ID);
            dest.writeString(Name);
            dest.writeString(DateTime);
            dest.writeByte((byte) (Loop ? 1 : 0));
            dest.writeByte((byte) (PushMsg ? 1 : 0));
            dest.writeByte((byte) (RecordEnable ? 1 : 0));
            dest.writeByte((byte) (SnapEnable ? 1 : 0));
            dest.writeByte((byte) (DoorBellEnable ? 1 : 0));
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Parameter> CREATOR = new Creator<Parameter>() {
            @Override
            public Parameter createFromParcel(Parcel in) {
                return new Parameter(in);
            }

            @Override
            public Parameter[] newArray(int size) {
                return new Parameter[size];
            }
        };

        /**
         * 以ID作为唯一身份
         */
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Parameter)) {
                return false;
            }
            if (this.ID == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            return this.ID.equals(((Parameter) o).ID);
        }

        @Override
        public String toString() {
            return "ID = " + ID + ";Name = " + Name + ";time = " + DateTime + ";push = " + PushMsg + ";record = " + RecordEnable + ";snap = " + SnapEnable;
        }

        public ReserveWakeUp.Parameter clone() {
            ReserveWakeUp.Parameter parameter = new Parameter();
            parameter.RecordEnable = this.RecordEnable;
            parameter.PushMsg = this.PushMsg;
            parameter.SnapEnable = this.SnapEnable;
            parameter.DoorBellEnable = this.DoorBellEnable;
            parameter.DateTime = this.DateTime;
            parameter.Name = this.Name;
            parameter.Loop = this.Loop;
            parameter.ID = this.ID;
            return parameter;
        }
    }
}


/*配置文档：
* {
    "Consumer.ReserveWakeUp": [								//初始为空
        {
            "ID": "20180308080300", 						// 增加删除时，使用这个字段判断。年月日时分秒的字符串形式。在删除时删除这个ID。其他时候不变
            "Name": "来电预约1",							//
            "DateTime": "2018-03-08 08:03",					//时间
            "PushMsg": true,								//推送使能
            "RecordEnable": false,							//录像使能
            "SnapEnable": false								//抓图使能
        }
    ]
}
REQ_ID 3018
RSP_ID 3019
Action
查询		GetAllReserveItem   查询的时候可以不传parameter
增加		AddReserveItem
删除		DeleteReserveItem
修改		ChangeReserveItem

{
	"Name":	"Consumer.ReserveWakeUp",
	"Consumer.ReserveWakeUp":	{
		"Action":	"AddReserveItem",
		"Parameter":	{
			"ID": "20180308080300",
            "Name": "来电预约1",
            "DateTime": "2018-03-08 08:03",
            "PushMsg": true,
            "RecordEnable": false,
            "SnapEnable": false
		}
	},
	"SessionID":	"0x0000000001"
}

*/