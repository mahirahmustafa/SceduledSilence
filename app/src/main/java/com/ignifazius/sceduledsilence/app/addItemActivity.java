package com.ignifazius.sceduledsilence.app;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class addItemActivity extends Activity {
    int hour_start = 0;
    int hour_end = 0;
    int minute_start = 0;
    int minute_end = 0;
    EditText eventName;
    CheckBox mo, tu, we, th, fr, sa, su, vib;

    TimePickerDialog.OnTimeSetListener startingTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            TextView startingTime = (TextView) findViewById(R.id.textView_start_time);
            String hour = ""+i;
            String minute =""+i2;
            if (i2 < 10){
                minute = "0" + minute;
            }
            if (i < 10){
                hour = "0" + hour;
            }
            startingTime.setText(hour + ":" +minute);
            hour_start = i;
            minute_start = i2;
        }
    };

    TimePickerDialog.OnTimeSetListener endingTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            TextView endingTime = (TextView) findViewById(R.id.textView_end_time);
            String hour = ""+i;
            String minute =""+i2;
            if (i2 < 10){
                minute = "0" + minute;
            }
            if (i < 10){
                hour = "0" + hour;
            }
            endingTime.setText(hour + ":" +minute);
            hour_end = i;
            minute_end = i2;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        eventName =(EditText)findViewById(R.id.editText);
        mo = (CheckBox)findViewById(R.id.checkBox_Mo);
        tu = (CheckBox)findViewById(R.id.checkBox_Tu);
        we = (CheckBox)findViewById(R.id.checkBox_We);
        th = (CheckBox)findViewById(R.id.checkBox_Th);
        fr = (CheckBox)findViewById(R.id.checkBox_Fr);
        sa = (CheckBox)findViewById(R.id.checkBox_Sa);
        su = (CheckBox)findViewById(R.id.checkBox_Su);
        vib = (CheckBox)findViewById(R.id.checkBox_vibrate);
    }

    public void setStartingTime(View view){
        int hour = hour_start;
        int minute = minute_start;
        if (hour == 0){
            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }
        TimePickerDialog picker = new TimePickerDialog(this, startingTimeListener, hour, minute, true);
        picker.show();
    }

    public void setEndingTime(View view){
        int hour = hour_end;
        int minute = minute_end;
        TimePickerDialog picker = new TimePickerDialog(this, endingTimeListener, hour, minute, true);
        picker.show();
    }

    public void addToList(View view){
        SceduledItem item = new SceduledItem(eventName.getText().toString(),mo.isChecked(),tu.isChecked(),we.isChecked(),th.isChecked(),fr.isChecked(),sa.isChecked(),su.isChecked(),vib.isChecked(),hour_start,minute_start,hour_end,minute_end);
        MainActivity.addItemToList(item);
        this.finish();
    }
}
