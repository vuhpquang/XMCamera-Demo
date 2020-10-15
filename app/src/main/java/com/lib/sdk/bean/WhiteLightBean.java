package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangyongyong on 2017-08-08-18:59.
 */

public class WhiteLightBean {

    private String WorkMode;

    private WorkPeriod WorkPeriod;

    private MoveTrigLight MoveTrigLight;

    @JSONField(name = "WorkMode")
    public String getWorkMode() {
        return WorkMode;
    }

    @JSONField(name = "WorkMode")
    public void setWorkMode(String workMode) {
        WorkMode = workMode;
    }

    @JSONField(name = "WorkPeriod")
    public WorkPeriod getWorkPeriod() {
        return WorkPeriod;
    }

    @JSONField(name = "WorkPeriod")
    public void setWorkPeriod(WorkPeriod workPeriod) {
        WorkPeriod = workPeriod;
    }

    @JSONField(name = "MoveTrigLight")
    public MoveTrigLight getMoveTrigLight() {
        return MoveTrigLight;
    }

    @JSONField(name = "MoveTrigLight")
    public void setMoveTrigLight(MoveTrigLight moveTrigLight) {
        MoveTrigLight = moveTrigLight;
    }

    public static class WorkPeriod {
        private int SHour;
        private int SMinute;
        private int EHour;
        private int EMinute;

        @JSONField(name = "SHour")
        public int getSHour() {
            return SHour;
        }

        @JSONField(name = "SHour")
        public void setSHour(int SHour) {
            this.SHour = SHour;
        }

        @JSONField(name = "SMinute")
        public int getSMinute() {
            return SMinute;
        }

        @JSONField(name = "SMinute")
        public void setSMinute(int SMinute) {
            this.SMinute = SMinute;
        }

        @JSONField(name = "EHour")
        public int getEHour() {
            return EHour;
        }

        @JSONField(name = "EHour")
        public void setEHour(int EHour) {
            this.EHour = EHour;
        }

        @JSONField(name = "EMinute")
        public int getEMinute() {
            return EMinute;
        }

        @JSONField(name = "EMinute")
        public void setEMinute(int EMinute) {
            this.EMinute = EMinute;
        }

        @Override
        public String toString() {
            return "WorkPeriod{" +
                    "SHour=" + SHour +
                    ", SMinute=" + SMinute +
                    ", EHour=" + EHour +
                    ", EMinute=" + EMinute +
                    '}';
        }
    }

    public static class MoveTrigLight {
        private int Level;
        private int Duration;

        @JSONField(name = "Level")
        public int getLevel() {
            return Level;
        }

        @JSONField(name = "Level")
        public void setLevel(int level) {
            Level = level;
        }

        @JSONField(name = "Duration")
        public int getDuration() {
            return Duration;
        }

        @JSONField(name = "Duration")
        public void setDuration(int duration) {
            Duration = duration;
        }

        @Override
        public String toString() {
            return "MoveTrigLight{" +
                    "Level=" + Level +
                    ", Duration=" + Duration +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WhiteLight{" +
                "WorkMode='" + WorkMode + '\'' +
                ", WorkPeriod=" + WorkPeriod +
                ", MoveTrigLight=" + MoveTrigLight +
                '}';
    }
}
