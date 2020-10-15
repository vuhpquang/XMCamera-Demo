package com.lib.sdk.bean;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.utils.XUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务器端提供的设备能力集信息
 * Created by hws on 2018-03-13.
 */

public class SysDevAbilityInfoBean {
    public static final int CLOUD_STATE_UNKOWN = -1;
    public static final int CLOUD_STATE_NOT_SUPPORT = 0;
    public static final int CLOUD_STATE_NORMAL = 1;
    public static final int CLOUD_STATE_EXPIRE = 2;
    public static final int CLOUD_STATE_NOT_OPENED = 3;
    private HashMap<String, Object> devAbilityMap = new HashMap<>();
    private SystemInfoBean sysInfo;
    private String sn;
    private int devType;
    private String[] devAbilityNames;
    public SysDevAbilityInfoBean(SystemInfoBean sysInfo, String sn, int devType) {
        this.sysInfo = sysInfo;
        this.sn = sn;
        this.devType = devType;
    }

    public SysDevAbilityInfoBean(String sn) {
        this.sn = sn;
    }

    public String getSendJson(Context context,String ... devAbilityNames) {
        if (devAbilityNames == null || sn == null) {
            return "";
        }
        this.devAbilityNames = devAbilityNames;
        JSONObject sendObj = new JSONObject();
        try {
            if (sysInfo != null) {
                sendObj.put("hw", sysInfo.getHardWare());//设备版本
                sendObj.put("sw", sysInfo.getSoftWareVersion());//设备固件版本
            }
			sendObj.put("ver",2);
            sendObj.put("tp", devType);//设备类型
            sendObj.put("sn", sn);//设备序列号
            sendObj.put("caps",devAbilityNames);
            sendObj.put("appType", XUtils.getPackageName(context));
            for (String devAbilityName : devAbilityNames) {
                devAbilityMap.put(devAbilityName,false);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sendObj.toString();
    }

    public boolean parseJson(String sysDevAbilityJson) {
        if (StringUtils.isStringNULL(sysDevAbilityJson)) {
            return false;
        }

        JSONObject jObj;
        try {
            jObj = JSON.parseObject(sysDevAbilityJson);
            if (null == jObj) {
                return false;
            }

            devAbilityMap.putAll(jObj);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isConfigSupport() {
        if (devAbilityNames == null) {
            return false;
        }
        if (devAbilityMap == null || !devAbilityMap.containsKey(devAbilityNames[0])) {
            return false;
        }

        Object object = devAbilityMap.get(devAbilityNames[0]);

        if (object instanceof Boolean) {
            return (boolean) object;
        }

        return false;
    }

    public boolean isConfigSupport(String key) {
        if (null == devAbilityMap || !devAbilityMap.containsKey(key)) {
            return false;
        }

        Object object = devAbilityMap.get(key);
        if (object instanceof Boolean) {
            return (boolean) object;
        }

        return false;
    }

    public Map<String, Object> isConfigSupports() {
        return devAbilityMap;
    }
}
