package com.lib.sdk.bean.smartanalyze;

import com.alibaba.fastjson.annotation.JSONField;
import com.manager.db.Define;

import java.io.Serializable;

//import com.lib.funsdk.support.utils.Define;

/**
 * Auto-generated: 2017-04-26 19:0:43
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class DetectAnalyze implements Serializable{

	public static final int MODULE_TYPE_PEA = 0;
	public static final int MODULE_TYPE_OSC = 1;
	public static final int MODULE_TYPE_AVD = 2;
	public static final int MODULE_TYPE_CPC = 3;
    private boolean enable;//视频分析关闭

    private Eventhandler eventhandler;//遮挡检测联动
    
    /**
     * 使用的那种算法模块，
		PEA：周界检测与绊线
		OSC：物品盗移、滞留，非法停车
		AVD：异常视频信号诊断
		{MODULE_TYPE_PEA,MODULE_TYPE_OSC,MODULE_TYPE_AVD,MODULE_TYPE_CPC}
     */
    private int moduletype;

    private Ruleconfig ruleconfig;//各种算法的规则配置

    public DetectAnalyze() {
    }

    @JSONField(name = "Enable")
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @JSONField(name = "Enable")
    public boolean getEnable() {
        return enable;
    }

    @JSONField(name = "EventHandler")
    public void setEventhandler(Eventhandler eventhandler) {
        this.eventhandler = eventhandler;
    }

    @JSONField(name = "EventHandler")
    public Eventhandler getEventhandler() {
        return eventhandler;
    }

    @JSONField(name = "ModuleType")
    public void setModuletype(int moduletype) {
        this.moduletype = moduletype;
    }

    @JSONField(name = "ModuleType")
    public int getModuletype() {
        return moduletype < 0 ? 0 : moduletype;
    }
    @JSONField(name = "RuleConfig")
    public void setRuleconfig(Ruleconfig ruleconfig) {
        this.ruleconfig = ruleconfig;
    }
    @JSONField(name = "RuleConfig")
    public Ruleconfig getRuleconfig() {
        return ruleconfig;
    }

//    @Override
//    public String toString() {
//        return "DetectAnalyze{" +
//                "enable=" + enable +
//                ", eventhandler=" + eventhandler +
//                ", moduletype=" + moduletype +
//                ", ruleconfig=" + ruleconfig +
//                '}';
//    }
    
    public int getAnalyzeAlertType() {
    	int type = -1;
    	switch (moduletype) {
		case MODULE_TYPE_PEA:
			if(getRuleconfig().getPearule().getTripwireenable() == 1) {
				type = Define.ALERT_lINE_TYPE;
			}else if(getRuleconfig().getPearule().getPerimeterenable() == 1) {
				type = Define.ALERT_AREA_TYPE;
			}
			break;
		case MODULE_TYPE_OSC:
			if(getRuleconfig().getOscrule().getStolenenable() == 1
			|| getRuleconfig().getOscrule().getAbandumenable() == 1) {
				type = Define.GOODS_RETENTION_TYPE;
			}
			break;
		case MODULE_TYPE_AVD:
			if(getRuleconfig().getAvdrule().getClarityenable() == 1
			|| getRuleconfig().getAvdrule().getNosignalenable() == 1
			|| getRuleconfig().getAvdrule().getChangeenable() == 1) {
				type = Define.STOLEN_GOODS_TYPE;
			}
			break;
		default:
			break;
		}
    	return type;
    }

}