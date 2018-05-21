package com.amlogic.DTVPlayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DTVPlayer extends Activity {

    final static String TAG = "CallTV";
    final static String IS_FIRST_TIME = "dvb_is_first_time";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        //setContentView( R.layout.activity_main );

        // setContentView(R.layout.activity_main);
        /*String pid = UtilShell.executeShellCommandWithOp( "pidof com.google.android.youtube.googletv" ).trim();
        UtilShell.executeShellCommandWithOp( "kill "+pid );
        Log.d( TAG, "Killed pid : "+pid+", of package com.google.android.youtube.googletv" );

        pid = UtilShell.executeShellCommandWithOp( "pidof com.spotify.tv.android" ).trim();
        UtilShell.executeShellCommandWithOp( "kill "+pid );
        Log.d( TAG, "Killed pid : "+pid+", of package com.spotify.tv.android" );

        pid = UtilShell.executeShellCommandWithOp( "pidof com.cnn.mobile.android.tv" ).trim();
        UtilShell.executeShellCommandWithOp( "kill "+pid );
        Log.d( TAG, "Killed pid : "+pid+", of package com.cnn.mobile.android.tv" );

        pid = UtilShell.executeShellCommandWithOp( "pidof com.radio.fmradio" ).trim();
        UtilShell.executeShellCommandWithOp( "kill "+pid );
        Log.d( TAG, "Killed pid : "+pid+", of package com.radio.fmradio" );*/

        /*UtilShell.executeShellCommandWithOp( "am force-stop com.google.android.youtube.googletv" );
        UtilShell.executeShellCommandWithOp( "am force-stop com.spotify.tv.android" );
        UtilShell.executeShellCommandWithOp( "am force-stop com.cnn.mobile.android.tv" );*/

/*        new Handler().postDelayed( new Runnable() {

			@Override
			public void run() {
				Log.d( null, "Running after 0 seconds DTVplayer" );
				// UtilShell.executeShellCommandWithOp( "monkey -p com.google.android.youtube.googletv -c android.intent.category.LAUNCHER 1" );
				// am start -a android.intent.action.MAIN -n com.google.android.youtube.googletv
				//Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.amlogic.DTVPlayer");
				Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage( "com.android.dtv" );
				startActivity( LaunchIntent );
				finish();
			}
		}, 0 );*/


        // This is for James Cook - Android 6.0
        // First time we let the DVBPlayer open as it as, after reboot.
        // Second time onwards, we first delete the epg.db file, and then open DVBPlayer
        // This is because deleting epg.db fixes the crashed DVB PLayer app
        // 0 or empty means FIRST time, 1 means NOT-FIRST time

        /*
        String is_first_time = UtilShell.executeShellCommandWithOp( "getprop "+IS_FIRST_TIME );
        is_first_time = is_first_time.trim();

        if( is_first_time.equals( "1" ) ){
            *//*UtilShell.executeShellCommandWithOp( "chmod -R 777 /data/hdtv*//**//*",
                    "rm /data/hdtv/epg.db" );

            Log.d( TAG, "Deleting epg.db" );

            String pid = UtilShell.executeShellCommandWithOp( "pidof com.android.dtv" );*//*
            //UtilShell.executeShellCommandWithOp( "kill "+pid );

            //Log.d( TAG, "killed com.android.dtv" );
        }
        else{
            UtilShell.executeShellCommandWithOp( "setprop "+IS_FIRST_TIME+" 1" );
            Log.d( TAG, "First Time : Not Deleting epg.db" );
        }

        try {
            Thread.sleep( 500 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.dtv");
        startActivity(LaunchIntent);
        finish();

    }
}
