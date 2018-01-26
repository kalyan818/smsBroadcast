package com.example.kalya.simcard1;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity  {
    VideoView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, com.example.kalya.simcard1.Main2Activity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        String fin = "android.resource://" + getPackageName() + "/" + R.raw.ka;
        view = (VideoView) findViewById(R.id.vid);
        view.setVideoURI(Uri.parse(fin));
        view.start();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
       if (keyCode == KeyEvent.KEYCODE_HOME){
           Toast.makeText(this,"home",Toast.LENGTH_LONG).show();
            return false;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK){
            //Toast.makeText(this,"back",Toast.LENGTH_LONG).show();
            return false;
        }
        if (keyCode == KeyEvent.KEYCODE_MENU)
        {
            Toast.makeText(this,"menu",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}