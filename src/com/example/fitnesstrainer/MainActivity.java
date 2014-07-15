package com.example.fitnesstrainer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		Button bn = (Button)findViewById(R.id.button1);
		Button bn1 = (Button)findViewById(R.id.button2);
		Button bn2 = (Button)findViewById(R.id.button3);
	
         bn.setOnClickListener(new OnClickListener() {
            @Override
        	 public void onClick(View sourse) {
                Intent intent = new Intent(MainActivity.this, Instruction.class);
                startActivity(intent);
                finish();
            }
        }
         );
         bn1.setOnClickListener(new OnClickListener() {
             @Override
         	 public void onClick(View sourse) {
            	  
            	 Intent intent = new Intent(MainActivity.this, Play.class);
                 startActivity(intent);
                 finish();
             }
         }
          );
         
         
    
         bn2.setOnClickListener(new OnClickListener() {
             @Override
         	 public void onClick(View sourse) {
                 System.exit(0);
             }
         }
          );
         
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
