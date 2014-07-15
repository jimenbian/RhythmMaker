package com.example.fitnesstrainer;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Splash extends Activity {
	private final int SPLASH_DISPLAY_LENGHT = 3000; //�ӳ�����  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS); //ȥ������ 
		 this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		setContentView(R.layout.activity_start);
		 
			 new Handler().postDelayed(new Runnable(){ 
			  
	         @Override 
	         public void run() { 
	             Intent mainIntent = new Intent(Splash.this,MainActivity.class); 
	             startActivity(mainIntent); 
	             finish(); 
	         } 
	            
	        }, SPLASH_DISPLAY_LENGHT); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
