package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangyongyong on 2018-03-22.
 */

public class OPElecPTZControl {

    @JSONField(name = "Command")
    private String Command = "";
    @JSONField(name = "Parameter")
    private Parameter Parameter = new Parameter();

    @JSONField(name = "Command")
    public void setCommand(String Command) {
        this.Command = Command;
    }

    @JSONField(name = "Command")
    public String getCommand() {
        return this.Command;
    }

    @JSONField(name = "Parameter")
    public void setParameter(Parameter Parameter) {
        this.Parameter = Parameter;
    }

    @JSONField(name = "Parameter")
    public Parameter getParameter() {
        return this.Parameter;
    }


    public static class Parameter {
        @JSONField(name = "Channel")
        private int Channel;
        @JSONField(name = "POINT")
        private POINT POINT = new POINT();
        @JSONField(name = "Preset")
        private int Preset;
        @JSONField(name = "Step")
        private int Step;
        @JSONField(name = "Channel")
        public void setChannel(int Channel) {
            this.Channel = Channel;
        }
        @JSONField(name = "Channel")
        public int getChannel() {
            return this.Channel;
        }
        @JSONField(name = "POINT")
        public void setPOINT(POINT POINT) {
            this.POINT = POINT;
        }
        @JSONField(name = "POINT")
        public POINT getPOINT() {
            return this.POINT;
        }
        @JSONField(name = "Preset")
        public void setPreset(int Preset) {
            this.Preset = Preset;
        }
        @JSONField(name = "Preset")
        public int getPreset() {
            return this.Preset;
        }
        @JSONField(name = "Step")
        public void setStep(int Step) {
            this.Step = Step;
        }
        @JSONField(name = "Step")
        public int getStep() {
            return this.Step;
        }

        @Override
        public String toString() {
            return "Parameter{" +
                    "Channel=" + Channel +
                    ", POINT=" + POINT.toString() +
                    ", Preset=" + Preset +
                    ", Step=" + Step +
                    '}';
        }
    }


    public static class POINT {
        @JSONField(name = "PixelsX")
        private int PixelsX;
        @JSONField(name = "PixelsY")
        private int PixelsY;

        @JSONField(name = "PixelsX")
        public void setPixelsX(int PixelsX) {
            this.PixelsX = PixelsX;
        }

        @JSONField(name = "PixelsX")
        public int getPixelsX() {
            return this.PixelsX;
        }

        @JSONField(name = "PixelsY")
        public void setPixelsY(int PixelsY) {
            this.PixelsY = PixelsY;
        }

        @JSONField(name = "PixelsY")
        public int getPixelsY() {
            return this.PixelsY;
        }

        @Override
        public String toString() {
            return "POINT{" +
                    "PixelsX=" + PixelsX +
                    ", PixelsY=" + PixelsY +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OPPTZControl{" +
                "Command='" + Command + '\'' +
                ", Parameter=" + Parameter.toString() +
                '}';
    }
}
