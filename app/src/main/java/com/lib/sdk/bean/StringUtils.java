/**
 * Android_NetSdk
 * StringUtils.java
 * Administrator
 * TODO
 * 2015-4-10
 */
package com.lib.sdk.bean;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.io.UnsupportedEncodingException;

/**
 * Android_NetSdk
 * StringUtils.java
 * @author huangwanshui
 * TODO
 * 2015-4-10
 */
public class StringUtils {
	/**
	 * �Ա��ַ�
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean contrast(String str1,String str2) {
		if(str1 == null && str2 != null)
			return false;
		else if(str1 != null && str2 == null)
			return false;
		else if(str1 == null && str2 == null)
			return true;
		else if(str1.equals(str2))
			return true;
		else
			return false;
	}
	public static boolean isStringNULL(String str) {
		if(str == null || str.equals("") || str.equals("null"))
			return true;
		else
			return false;
	}
	public static SpannableString getTintString(String originStr, int color,
												String... keywords) {
		if (originStr == null)
			return null;
		SpannableString ss = new SpannableString(originStr);
		for (String key : keywords) {
			int length = key.length();
			int start = originStr.indexOf(key);
			if (start > -1) {
				ss.setSpan(new ForegroundColorSpan(color), start, start + length,
						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return ss;
	}

	/**
	 * 截取指定字节数长度，utf-8一个汉字占3字节。如果最后一个为汉字，不会把汉字截成乱码
	 *
	 * @param text
	 * @param byteCount
	 * @return
	 */
	public static String getWholeText(String text, int byteCount) {
		try {
			if (text != null && text.getBytes("utf-8").length > byteCount) {
				char[] tempChars = text.toCharArray();
				int sumByte = 0;
				int charIndex = 0;
				for (int i = 0, len = tempChars.length; i < len; i++) {
					char itemChar = tempChars[i];
					// 根据Unicode值，判断它占用的字节数
					if (itemChar >= 0x0000 && itemChar <= 0x007F) {
						sumByte += 1;
					} else if (itemChar >= 0x0080 && itemChar <= 0x07FF) {
						sumByte += 2;
					} else {
						sumByte += 3;
					}
					if (sumByte > byteCount) {
						charIndex = i;
						break;
					}
				}
				return String.valueOf(tempChars, 0, charIndex);
			}
		} catch (UnsupportedEncodingException e) {
		}
		return text;
	}
}
