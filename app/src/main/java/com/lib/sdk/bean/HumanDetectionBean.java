package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.lib.sdk.bean.smartanalyze.Points;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hws
 * @name XMEye_Android
 * @class name：com.com.lib.bean
 * @class 人形检测
 * @time 2019-05-06 10:52
 */
public class HumanDetectionBean implements Serializable {
    public static final int IA_DIRECT_FORWARD = 0;/* 正向 */
    public static final int IA_DIRECT_BACKWARD = 1;/* 逆向 */
    public static final int IA_BIDIRECTION = 2;/* 双向 */
    public static final int IA_TRIPWIRE = 0;/* 绊线 */
    public static final int IA_PERIMETER = 1;/* 禁区 */
    @JSONField(name = "Enable")
    private boolean enable;
    @JSONField(name = "ObjectType")
    private int objectType;// /* 检测对象，0:人  1:所有物体 */
    @JSONField(name = "iShowRule")
    private boolean iShowRule;//是否显示规则
    @JSONField(name = "ShowTrack")
    private boolean showTrack;//是否显示轨迹
    @JSONField(name = "Sensitivity")
    private int sensitivity;//灵敏度
    @JSONField(name = "PedRule")
    private ArrayList<PedRule> pedRules = new ArrayList<>();

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public boolean isiShowRule() {
        return iShowRule;
    }

    public void setiShowRule(boolean iShowRule) {
        this.iShowRule = iShowRule;
    }

    public boolean isShowTrack() {
        return showTrack;
    }

    public void setShowTrack(boolean showTrack) {
        this.showTrack = showTrack;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public ArrayList<PedRule> getPedRules() {
        return pedRules;
    }

    public void setPedRules(ArrayList<PedRule> pedRules) {
        this.pedRules = pedRules;
    }

    public class PedRule implements Serializable {
        @JSONField(name = "Enable")
        private boolean enable;
        @JSONField(name = "RuleType")
        private int ruleType;
        @JSONField(name = "RuleLine")
        private RuleLine ruleLine = new RuleLine();
        @JSONField(name = "RuleRegion")
        private RuleRegion ruleRegion = new RuleRegion();

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public int getRuleType() {
            return ruleType;
        }

        public void setRuleType(int ruleType) {
            this.ruleType = ruleType;
        }

        public RuleLine getRuleLine() {
            return ruleLine;
        }

        public void setRuleLine(RuleLine ruleLine) {
            this.ruleLine = ruleLine;
        }

        public RuleRegion getRuleRegion() {
            return ruleRegion;
        }

        public void setRuleRegion(RuleRegion ruleRegion) {
            this.ruleRegion = ruleRegion;
        }

        public class RuleLine implements Serializable {
            @JSONField(name = "AlarmDirect")
            private int alarmDirect;
            @JSONField(name = "Pts")
            private Pts pts = new Pts();

            public Pts getPts() {
                return pts;
            }

            public void setPts(Pts pts) {
                this.pts = pts;
            }

            public int getAlarmDirect() {
                return alarmDirect;
            }

            public void setAlarmDirect(int alarmDirect) {
                this.alarmDirect = alarmDirect;
            }

            public class Pts implements Serializable {
                @JSONField(name = "StartX")
                private int startX;
                @JSONField(name = "StartY")
                private int startY;
                @JSONField(name = "StopX")
                private int stopX;
                @JSONField(name = "StopY")
                private int stopY;

                public int getStartX() {
                    return startX;
                }

                public void setStartX(int startX) {
                    this.startX = startX;
                }

                public int getStartY() {
                    return startY;
                }

                public void setStartY(int startY) {
                    this.startY = startY;
                }

                public int getStopX() {
                    return stopX;
                }

                public void setStopX(int stopX) {
                    this.stopX = stopX;
                }

                public int getStopY() {
                    return stopY;
                }

                public void setStopY(int stopY) {
                    this.stopY = stopY;
                }
            }
        }

        public class RuleRegion implements Serializable {
            @JSONField(name = "AlarmDirect")
            private int alarmDirect;
            @JSONField(name = "PtsNum")
            private int ptsNum;
            @JSONField(name = "Pts")
            private ArrayList<Pts> ptsList;

            public int getPtsNum() {
                return ptsNum;
            }

            public void setPtsNum(int ptsNum) {
                this.ptsNum = ptsNum;
            }

            public int getAlarmDirect() {
                return alarmDirect;
            }

            public void setAlarmDirect(int alarmDirect) {
                this.alarmDirect = alarmDirect;
            }

            public ArrayList<Pts> getPtsList() {
                return ptsList;
            }

            public void setPtsList(ArrayList<Pts> pts) {
                this.ptsList = pts;
            }

            @JSONField(serialize = false)
            public void setPtsByPoints(List<Points> pointsList) {
                if (ptsList != null && pointsList != null) {
                    ptsList.clear();
                    for (int i = 0; i < pointsList.size(); i++) {
                        Pts pts = new Pts();
                        Points points = pointsList.get(i);
                        pts.setX((int) points.getX());
                        pts.setY((int) points.getY());
                        ptsList.add(pts);
                    }
                }
            }

            @JSONField(serialize = false)
            public List<Points> getPointsList() {
                List<Points> pointsList = new ArrayList<>();
                if (ptsList != null) {
                    for (int i = 0; i < ptsList.size(); i++) {
                        Pts pts = ptsList.get(i);
                        Points points = new Points();
                        points.setX(pts.getX());
                        points.setY(pts.getY());
                        pointsList.add(points);
                    }
                }
                return pointsList;
            }

            public class Pts implements Serializable {
                @JSONField(name = "X")
                private int x;
                @JSONField(name = "Y")
                private int y;

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }
            }
        }
    }
}

