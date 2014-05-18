package com.ignifazius.sceduledsilence.app;

import java.util.Calendar;

/**
 * Created by Stefan on 17.05.2014.
 */
public class SceduledItem {
    private Boolean mo, tu, we, th, fr, sa, su, vibrate;
    private int hour_start, hour_end, minute_start, minute_end;
    private String name;

    SceduledItem(String name,boolean mo, boolean di, boolean mi, boolean don, boolean fr, boolean sa, boolean so, boolean vib, int h_start, int m_start, int h_end, int m_end){
        this.name = name;
        this.mo = mo;
        this.tu = di;
        this.we = mi;
        this.th = don;
        this.fr = fr;
        this.sa = sa;
        this.su = so;
        this.vibrate = vib;
        this.hour_start = h_start;
        this.minute_start = m_start;
        this.hour_end = h_end;
        this.minute_end = m_end;
    }

    public Boolean getMo() {
        return mo;
    }

    public Boolean getTu() {
        return tu;
    }

    public Boolean getWe() {
        return we;
    }

    public Boolean getTh() {
        return th;
    }

    public Boolean getFr() {
        return fr;
    }

    public Boolean getSa() {
        return sa;
    }

    public Boolean getSu() {
        return su;
    }

    public Boolean getVibrate() {
        return vibrate;
    }

    public int getHour_start() {
        return hour_start;
    }

    public int getHour_end() {
        return hour_end;
    }

    public int getMinute_start() {
        return minute_start;
    }

    public int getMinute_end() {
        return minute_end;
    }

    public String getName() {
        return name;
    }

    public boolean checkMute(){
        Calendar c = Calendar.getInstance();
        int date = c.get(c.DATE);
        return false;
    }
}
