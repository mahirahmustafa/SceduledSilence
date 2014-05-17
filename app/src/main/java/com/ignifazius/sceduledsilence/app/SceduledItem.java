package com.ignifazius.sceduledsilence.app;

/**
 * Created by Stefan on 17.05.2014.
 */
public class SceduledItem {
    Boolean mo, tu, we, th, fr, sa, su, vibrate;

    SceduledItem(boolean mo, boolean di, boolean mi, boolean don, boolean fr, boolean sa, boolean so, boolean vib){
        this.mo = mo;
        this.tu = di;
        this.we = mi;
        this.th = don;
        this.fr = fr;
        this.sa = sa;
        this.su = so;
        this.vibrate = vib;
    }

}
