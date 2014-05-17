package com.ignifazius.sceduledsilence.app;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class addItemActivity extends Activity {
    int hour_start = 0;
    int hour_end = 0;
    int minute_start = 0;
    int minute_end = 0;

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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    }
}
