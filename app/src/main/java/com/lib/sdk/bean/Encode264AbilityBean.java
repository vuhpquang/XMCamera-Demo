package com.lib.sdk.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XMuser on 2018-07-06.
 */

public class Encode264AbilityBean {

        public List<String> uIntel264 = new ArrayList<>();
        public List<String> uIntel264Plus = new ArrayList<>();

        public List<String> getuIntel264() {
            return uIntel264;
        }

        public void setuIntel264(List<String> uIntel264) {
            this.uIntel264 = uIntel264;
        }

        public List<String> getuIntel264Plus() {
            return uIntel264Plus;
        }

        public void setuIntel264Plus(List<String> uIntel264Plus) {
            this.uIntel264Plus = uIntel264Plus;
        }

    public boolean getuIntel264Main(){
        String s = uIntel264.get(0);
        s = s.replace("0x", "");
        int i = Integer.parseInt(s, 16);
        return i > 0;
    }

    public boolean getuIntel264PlusMain(){
        String s = uIntel264Plus.get(0);
        s = s.replace("0x", "");
        int i = Integer.parseInt(s, 16);
        return i > 0;
    }
}
