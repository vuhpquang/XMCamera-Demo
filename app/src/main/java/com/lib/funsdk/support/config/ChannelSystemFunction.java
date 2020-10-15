package com.lib.funsdk.support.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelSystemFunction extends DevCmdGeneral {

    /**
     *  以下CONFIG_NAME的定义必须要有,是为了保持所有的配置可以统一解析
     */
    public static final String CONFIG_NAME = JsonConfig.CHANNEL_SYSTEM_FUNCTION;
    public static final int JSON_ID = 1362;

    public static final String BROAD_TRENDS = "BroadTrends";
    public static final String CAMARE_STYLE = "CamareStyle";
    public static final String CORRIDOR_MODE = "CorridorMode";
    public static final String SMART_H264 = "SmartH264";
    public static final String SMART_H264_V2 = "SmartH264V2";
    public static final String SOFT_PHOTO_SENSITIVE_MASK = "SoftPhotoSensitiveMask";
    public static final String SUPPORT_IPC_TALK = "SupportIPCTalk";
    public static final String SET_WEB_LOGIN_ENCRYPT_GRADE = "SetWebLoginEncryptGrade";
    public static final String SUPPORT_PEAL_IN_HUMAN_PED = "SupportPeaInHumanPed";
    private int[] BroadTrends; //  宽动态
    private int[] CamareStyle; // 图像风格
    private int[] CorridorMode;// 走廊模式
    private int[] SmartH264;// Smart编码
    private int[] SmartH264V2;// Smart编码V2
    private int[] SoftPhotoSensitiveMask;  // 软光敏
    private int[] SupportIPCTalk;// 各个通道是否支持IE直接和NVR所连接的IPC对讲
    private int[] SetWebLoginEncryptGrade;// 是否支持网络登陆加密等级设定
    private int[] SupportPeaInHumanPed;// 是否支持人形检测中加入周界拌线功能

    public ChannelSystemFunction() {
    }

    public int[] getBroadTrends() {
        return BroadTrends;
    }

    public int[] getCamareStyle() {
        return CamareStyle;
    }

    public int[] getCorridorMode() {
        return CorridorMode;
    }

    public int[] getSmartH264() {
        return SmartH264;
    }

    public int[] getSmartH264V2() {
        return SmartH264V2;
    }

    public int[] getSoftPhotoSensitiveMask() {
        return SoftPhotoSensitiveMask;
    }

    public int[] getSupportIPCTalk() {
        return SupportIPCTalk;
    }

    public int[] getSetWebLoginEncryptGrade() {
        return SetWebLoginEncryptGrade;
    }

    public int[] getSupportPeaInHumanPed() {
        return SupportPeaInHumanPed;
    }

    @Override
    public boolean onParse(String json) {
        if (!super.onParse(json)) {
            return false;
        }
        try {
            JSONObject c_jsonobj = mJsonObj.getJSONObject(CONFIG_NAME);
            return onParse(c_jsonobj);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean onParse(JSONObject c_jsonobj) {
        if (c_jsonobj == null) {
            return false;
        }
        try {
            if (c_jsonobj.has("BroadTrends")) {
                BroadTrends = jsonArray2Int(c_jsonobj.getJSONArray("BroadTrends"));
            }
            if (c_jsonobj.has("CamareStyle")) {
                CamareStyle = jsonArray2Int(c_jsonobj.getJSONArray("CamareStyle"));
            }
            if (c_jsonobj.has("CorridorMode")) {
                CorridorMode = jsonArray2Int(c_jsonobj.getJSONArray("CorridorMode"));
            }
            if (c_jsonobj.has("SmartH264")) {
                SmartH264 = jsonArray2Int(c_jsonobj.getJSONArray("SmartH264"));
            }
            if (c_jsonobj.has("SmartH264V2")) {
                SmartH264V2 = jsonArray2Int(c_jsonobj.getJSONArray("SmartH264V2"));
            }
            if (c_jsonobj.has("SoftPhotoSensitiveMask")) {
                SoftPhotoSensitiveMask = jsonArray2Int(c_jsonobj.getJSONArray("SoftPhotoSensitiveMask"));
            }
            if (c_jsonobj.has("SupportIPCTalk")) {
                SupportIPCTalk = jsonArray2Int(c_jsonobj.getJSONArray("SupportIPCTalk"));
            }
            if (c_jsonobj.has("SetWebLoginEncryptGrade")) {
                SetWebLoginEncryptGrade = jsonArray2Int(c_jsonobj.getJSONArray("SetWebLoginEncryptGrade"));
            }
            if (c_jsonobj.has("SupportPeaInHumanPed")) {
                SupportPeaInHumanPed = jsonArray2Int(c_jsonobj.getJSONArray("SupportPeaInHumanPed"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    private int[] jsonArray2Int(JSONArray jsonArray) {
        int[] data = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                data[i] = (int) jsonArray.get(i);
            } catch (JSONException e) {
                data[i] = 0;
            }
        }
        return data;
    }

    @Override
    public String getSendMsg() {
        return null;
    }

    @Override
    public String getConfigName() {
        return CONFIG_NAME;
    }

    @Override
    public int getJsonID() {
        return JSON_ID;
    }
}
