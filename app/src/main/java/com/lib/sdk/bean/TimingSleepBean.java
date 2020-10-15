package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hws on 2018-07-04.
 */

public class TimingSleepBean {
    @JSONField(name = "Enable")
    private boolean enable;
    @JSONField(name = "ManualWakeUp")
    private boolean manualWakeUp;
    @JSONField(name = "RepeatType")
    private int repeatType;
    @JSONField(name = "WorkPeriod")
    private WorkPeriod workPeriod;
    @JSONField(name = "InSleeping")
    private boolean inSleeping;//只获取不能设置
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public WorkPeriod getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(WorkPeriod workPeriod) {
        this.workPeriod = workPeriod;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public boolean isManualWakeUp() {
        return manualWakeUp;
    }

    public void setManualWakeUp(boolean manualWakeUp) {
        this.manualWakeUp = manualWakeUp;
    }

    @JSONField(serialize = false)
    public boolean isInSleeping() {
        return inSleeping;
    }

    public void setInSleeping(boolean inSleeping) {
        this.inSleeping = inSleeping;
    }

    public class WorkPeriod {
        @JSONField(name = "SHour")
        private int sHour;
        @JSONField(name = "SMinute")
        private int sMinute;
        @JSONField(name = "EHour")
        private int eHour;
        @JSONField(name = "EMinute")
        private int eMinute;

        public int getsHour() {
            return sHour;
        }

        public void setsHour(int sHour) {
            this.sHour = sHour;
        }

        public int getsMinute() {
            return sMinute;
        }

        public void setsMinute(int sMinute) {
            this.sMinute = sMinute;
        }

        public int geteHour() {
            return eHour;
        }

        public void seteHour(int eHour) {
            this.eHour = eHour;
        }

        public int geteMinute() {
            return eMinute;
        }

        public void seteMinute(int eMinute) {
            this.eMinute = eMinute;
        }

        @JSONField(serialize = false)
        public int[] getStartTime() {
            return new int[]{sHour,sMinute};
        }

        @JSONField(serialize = false)
        public int[] getEndTime() {
            return new int[]{eHour,eMinute};
        }
    }
}
