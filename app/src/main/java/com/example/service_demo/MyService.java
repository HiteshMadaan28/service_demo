package com.example.service_demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {
    private MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service was Created", Toast.LENGTH_SHORT).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
// This will play the ringtone/Alarmtone continuously until we stop the service.
        player.setLooping(true);
// It will start the player
        player.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
// tells the system to create a fresh copy of the service when sufficient memory is available.
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
// Stopping the player when service is destroyed
        player.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}