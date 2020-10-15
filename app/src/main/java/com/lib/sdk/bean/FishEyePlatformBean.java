/**
 * Copyright 2016 aTool.org 
 */
package com.lib.sdk.bean;

import java.util.ArrayList;

/**
 * Auto-generated: 2016-07-05 15:3:6
 * 
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class FishEyePlatformBean {
	public int LedAbility;// 是否支持LED调节
	public int SetupMode;// 掩码 支持哪些模式

	public ArrayList<Integer> getParseMask() {
		int mask = SetupMode;
		int index = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		do {
			if ((mask & 0x01) == 1) {
				list.add(index);
			}
			index++;
		} while ((mask = mask >> 1) > 0);
		return list;
	}
}