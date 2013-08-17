package com.test.vibrate;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
Vibrator v;
ToggleButton vibrateToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        setContentView(R.layout.activity_main);
    }
    public void VibrateToggle(View view) {
    	if (vibrateToggle == null)
    		vibrateToggle = (ToggleButton)view;
    	boolean on = vibrateToggle.isChecked();
    	long pattern [] = {10,1};
    	if (on)
    		v.vibrate(pattern, 0);
    	 
    	else
    		v.cancel();
    		 
    }
    @Override
    protected void onPause() {
    	vibrateToggle.setChecked(false);
    	super.onPause();
    	v.cancel();
    }
    @Override
    protected void onStop() {
    	  v.cancel();
      	vibrateToggle.setChecked(false);
        super.onStop();
      

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
