package com.lib.sdk.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 * @name iCSee_Pro_Android
 * @class name：com.com.lib.com.lib.sdk.bean
 * @class describe
 * @time 2019-03-29 10:20
 * @change
 * @chang time
 * @class describe
 */
public class OPFileBean {
    public static final int MEDIA_TYPE_AUDIO = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static final int MEDIA_TYPE_PIC = 3;
    @JSONField(name = "FileType")
    private int fileType; //文件类型 1:音频；2：视频；3：图片...
    @JSONField(name = "Channel")
    private int[] channel;//指定通道号发送（支持单通道、多通道、全通道发送）
    @JSONField(name = "FilePurpose")
    private int filePurpose; //文件用途 0：设备报警音
    @JSONField(name = "FileSize")
    private int fileSize;
    @JSONField(name = "FileName")
    private String fileName;
    @JSONField(name = "Parameter")
    private Parameter parameter = new Parameter();

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFilePurpose() {
        return filePurpose;
    }

    public void setFilePurpose(int filePurpose) {
        this.filePurpose = filePurpose;
    }

    public int[] getChannel() {
        return channel;
    }

    public void setChannel(int[] channel) {
        this.channel = channel;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public class Parameter {
        @JSONField(name = "AudioFormat")
        private AudioFormat audioFormat = new AudioFormat();

        public AudioFormat getAudioFormat() {
            return audioFormat;
        }

        public void setAudioFormat(AudioFormat audioFormat) {
            this.audioFormat = audioFormat;
        }

        public class AudioFormat {
            @JSONField(name = "BitRate")
            private int bitRate;
            @JSONField(name = "SampleRate")
            private int sampleRate;
            @JSONField(name = "SampleBit")
            private int sampleBit;
            @JSONField(name = "EncodeType")
            private String encodeType = "G711_ALAW";

            public int getBitRate() {
                return bitRate;
            }

            public void setBitRate(int bitRate) {
                this.bitRate = bitRate;
            }

            public int getSampleRate() {
                return sampleRate;
            }

            public void setSampleRate(int sampleRate) {
                this.sampleRate = sampleRate;
            }

            public int getSampleBit() {
                return sampleBit;
            }

            public void setSampleBit(int sampleBit) {
                this.sampleBit = sampleBit;
            }

            public String getEncodeType() {
                return encodeType;
            }

            public void setEncodeType(String encodeType) {
                this.encodeType = encodeType;
            }
        }
    }
}
