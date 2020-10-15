package com.lib.sdk.bean;

import java.util.List;

/**
* 
* @ClassName: StorageInfoBean 
* @Description: TODO(储存配置) 
* @author xxy 
* @date 2016年3月19日 下午4:49:24 
*
*/

public class StorageInfoBean {

	public long PartNumber;
	public long PlysicalNo;
	public List<Partition> Partition;

	public static class Partition {
		public long Status;
		public long DirverType;
		public long LogicSerialNo;
		public boolean IsCurrent;
		public String NewEndTime;
		public String RemainSpace;
		public String NewStartTime;
		public String TotalSpace;
		public String OldEndTime;
		public String OldStartTime;
	}
}
