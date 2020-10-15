package com.lib.sdk.struct;

/**
 * 智能分析报警区域信息
 * @author hws
 *
 */
public class SDK_AlarmAnalysisAreaInfo {
	public byte st_0_version;
	public byte st_1_areaCount;
	public byte[] st_2_arg = new byte[2];
	public AreaInfo[] st_3_areaInfo = new AreaInfo[6];
	public byte[] st_4_arg = new byte[12];
	public SDK_AlarmAnalysisAreaInfo() {
		for (int i = 0; i < st_3_areaInfo.length; i++) {
			st_3_areaInfo[i] = new AreaInfo();
		}
	}
}
