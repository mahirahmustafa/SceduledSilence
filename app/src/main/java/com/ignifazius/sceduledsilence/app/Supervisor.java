package com.ignifazius.sceduledsilence.app;

import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import java.util.Date;

/**
 * Created by Stefan on 18.05.2014.
 */
public class Supervisor {
    Context mContext;
    int storedRingerMode;
    NotificationManager mNotificationManager;
    AudioManager myAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

    Supervisor(Context context){
        this.mContext = context;
    }


    public boolean checkForEvent(SceduledItem item,int hour_start, int minute_start, int hour_end, int minute_end){

        return false;
    }

    public void createNotification(String title,int id, Date time){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("SceduledSilence is active.")
                        .setContentText(title + " -- "+ "TODO Time");
        // Creates an explicit intent for an Activity in your app
//        Intent resultIntent = new Intent(this, MainActivity.class);
//
//        // The stack builder object will contain an artificial back stack for the
//        // started Activity.
//        // This ensures that navigating backward from the Activity leads out of
//        // your application to the Home screen.
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        // Adds the back stack for the Intent (but not the Intent itself)
//
//
//        // mId allows you to update the notification later on.
//        stackBuilder.addParentStack(MainActivity.class);
//        // Adds the Intent that starts the Activity to the top of the stack
//        stackBuilder.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent =
//                stackBuilder.getPendingIntent(
//                        0,
//                        PendingIntent.FLAG_UPDATE_CURRENT
//                );
//        mBuilder.setContentIntent(resultPendingIntent);
        mNotificationManager.notify(id, mBuilder.build());
    }

    public void removeNotification(int id){
        mNotificationManager.cancel(id);
    }

    public void saveCurrentRingerMode(){
        storedRingerMode = myAudioManager.getRingerMode();
    }
    public void restoreRingerMode(){
        myAudioManager.setRingerMode(storedRingerMode);
    }
    public void setRingerSilent(){
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
    public void setRingerVibrate(){
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }
    public void setRingerNormal(){
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
}
