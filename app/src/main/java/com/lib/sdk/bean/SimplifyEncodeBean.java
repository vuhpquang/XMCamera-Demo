package com.lib.sdk.bean;

/**
 * @author xxy
 * @ClassName: SimplifyEncodeBean
 * @Description: TODO(简单编码配置)
 * @date 2016年3月19日 下午4:48:13
 */

public class SimplifyEncodeBean {

    public MainFormat MainFormat;
    public ExtraFormat ExtraFormat;
    public SnapFormat SnapFormat;

    public static class MainFormat {
        public boolean VideoEnable;
        public boolean AudioEnable;
        public Video Video;

        public static class Video {
            public int Quality;
            public int FPS;
            public int GOP;
            public int BitRate;
            public String Resolution;
            public String Compression;
            public String BitRateControl;
        }
    }

    public static class ExtraFormat {
        public boolean VideoEnable;
        public boolean AudioEnable;
        public Video Video;

        public static class Video {
            public int Quality;
            public int FPS;
            public int GOP;
            public int BitRate;
            public String BitRateControl;
            public String Compression;
            public String Resolution;
        }
    }

    public static class SnapFormat{
        public boolean VideoEnable;
        public boolean AudioEnable;
        public Video Video;

        public static class Video {
            public int Quality;
            public int FPS;
            public int GOP;
            public int BitRate;
            public String BitRateControl;
            public String Compression;
            public String Resolution;
        }
    }
}
