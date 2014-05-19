package com.ignifazius.sceduledsilence.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Stefan on 18.05.2014.
 */
public class Storage {
    Context mContext;
    SharedPreferences pref = mContext.getSharedPreferences(mContext.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();

    Storage(Context context){
        mContext = context;

    }

    public void store(SceduledItem item){
        editor.putString("name", item.getName());
        editor.putBoolean("monday", item.getMo());
        editor.putBoolean("tuesday", item.getTu());
        editor.putBoolean("wednesday", item.getWe());
        editor.putBoolean("thursday", item.getTh());
        editor.putBoolean("friday", item.getFr());
        editor.putBoolean("saturday", item.getSa());
        editor.putBoolean("sunday", item.getSu());
        editor.putBoolean("vibrate", item.getVibrate());
        editor.putInt("startingHour", item.getHour_start());
        editor.putInt("startingMinute", item.getMinute_start());
        editor.putInt("endingHour", item.getHour_end());
        editor.putInt("endingMinute", item.getMinute_end());
        editor.commit();
    }

    public void load(){

    }
}
