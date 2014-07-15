package com.example.fitnesstrainer;





import java.io.File;
import java.io.IOException;
import java.util.HashMap;



import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.SoundPool;


public class Play extends Activity implements OnClickListener {

	private SensorManager sm;
	//声明一个传感器
	private Sensor sensor;
	//声明一个传感器监听器
	private SensorEventListener mySensorListener;
	//圆形的X,Y坐标
	private int arc_x, arc_y;
	//传感器的xyz值
	private float x = 0, y = 0, z = 0;
    private Button btnStart;  
	private Button btnStop;  
    private Button btnPlay;  
    private MediaRecorder mMediaRecorder;  
	private File recAudioFile;  
	private MusicPlayer mPlayer;  
	public static float volume=1.3f;
	public int flag;
	public int flag1,flag2,flag3,flag4;
	
	int[] voice={R.raw.dang,R.raw.chua,R.raw.dun,R.raw.mao,R.raw.gou};
	int[] picture={R.drawable.qiang,R.drawable.xiu,R.drawable.dong,R.drawable.yaogun};
	 String[] result2=new String[4];
	  
	static View view = null;
	SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_play);
		view = this.getWindow().getDecorView();
		boolean MusicPlay=false;
		final MediaPlayer mp = MediaPlayer.create(this,R.raw.music1);
		Bundle b=this.getIntent().getExtras();
		/*Toast toast=Toast.makeText(Play.this,intent.getStringExtra("result"),Toast.LENGTH_LONG);
		toast.show();*/
		if(b!=null)
		{
	    result2=b.getStringArray("result");
		volume= Float.valueOf(result2[0]);
		voice[0]=voice[Integer.parseInt(result2[1])];
		voice[1]=voice[Integer.parseInt(result2[2])];
		voice[2]=voice[Integer.parseInt(result2[3])];
		  if( Integer.parseInt(result2[4])==1)
		  {MusicPlay=true;}
		}
		if(MusicPlay==true)
		{mp.start();}
		Button bn = (Button)findViewById(R.id.button1);
		//volume=datavolume.getFloat("a");
		sm = (SensorManager)getSystemService(Service.SENSOR_SERVICE);
		//实例一个重力传感器实例  
		sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		//实例传感器监听器
		final int soundID1 = soundPool.load(this,voice[0], 1);
		final int soundID2 = soundPool.load(this, voice[1], 1);
		final int soundID3= soundPool.load(this, voice[2], 1);
		
		
		
		btnStart = (Button) findViewById(R.id.start);  
        btnStop = (Button) findViewById(R.id.stop);  
        btnPlay = (Button) findViewById(R.id.play);  
        btnStart.setOnClickListener(this);  
        btnStop.setOnClickListener(this);  
        btnPlay.setOnClickListener(this);  
        recAudioFile = new File("/mnt/sdcard", "My Rhythm.amr");
        
		mySensorListener = new SensorEventListener() {
			@Override
			//传感器获取值发生改变时在响应此函数  
			public void onSensorChanged(SensorEvent event) {
				x = event.values[0]; 
				//x>0 说明当前手机左翻 x<0右翻       
				y = event.values[1];
				//y>0 说明当前手机下翻 y<0上翻  
				z = event.values[2]; 
				//z>0 手机屏幕朝上 z<0 手机屏幕朝下  
				arc_x -= x;
				arc_y += y;
				Play.this.getWindow().setBackgroundDrawableResource(picture[(int)(Math.random() * 3)]);
				if(x<-4)
				{    if(flag1==0)
					{
					int streamID = soundPool.play(soundID1 , volume, volume, 0, 0, 1);
			        Play.this.getWindow().setBackgroundDrawableResource(picture[(int)(Math.random() * 3)]);
					flag1=1;
					}/*soundPool.pause(soundID2);	
					soundPool.pause(soundID3);*/
				}
				
				if(x>4)
				{
					if(flag2==0)
					{
						int streamID = soundPool.play(soundID2 , volume, volume, 0, 0, 1);
					//soundPool.pause(soundID1);	
					    Play.this.getWindow().setBackgroundDrawableResource(picture[(int)(Math.random() * 3)]);
		                flag2=1;			
					}
				}
				if(y>4)
				{   if(flag3==0)
					{
					int streamID = soundPool.play(soundID3 , volume, volume, 0, 0, 1);
				    Play.this.getWindow().setBackgroundDrawableResource(picture[(int)(Math.random() * 3)]);
					flag3=1;
					}
				}
				if(-4<x&x<4&0<y&y<4)
				{
					
					soundPool.pause(soundID1);
					soundPool.pause(soundID2);
					soundPool.pause(soundID3);
					flag=0;
					flag1=0;
					flag2=0;
					flag3=0;
					Play.this.getWindow().setBackgroundDrawableResource(R.drawable.yaogun);
				}
				/*if(0<y&&y<4)
				{
					soundPool.pause(soundID1);
					soundPool.pause(soundID2);
					soundPool.pause(soundID3);
					flag=0;
				}*/
				if(y<-4)
				{
					if(flag==0)
					{Toast toast5=Toast.makeText(Play.this,"正在进入setting",Toast.LENGTH_SHORT);
		    		 toast5.show();
					 mp.stop();
					 Intent intent = new Intent(Play.this, Setting.class);
	                 startActivity(intent);
	                 finish();
	                 flag=1;
	                 }
					else{}
				}
				//if(x>{}10){int streamID = soundPool.play(soundID2 , 1, 1, 0, 0, 1);}
				//if(x<0){mp2.start();}
			
			}

			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
		}

	    };
	    bn.setOnClickListener(new OnClickListener() {
            @Override
        	 public void onClick(View sourse) {
            	//sm.unregisterListener(mySensorListener);
            	 mp.stop();
            	Toast toast3=Toast.makeText(Play.this,"返回菜单",Toast.LENGTH_SHORT);
         		toast3.show();
            	Intent intent = new Intent(Play.this, MainActivity.class);
                startActivity(intent);
                
                finish();
            }
        });
	}
   
    @Override  
    public void onClick(View v) {  
        switch (v.getId()) {  
        case R.id.start:  
           if(flag4==0)
        	{
        	startRecorder(); 
            Toast toast=Toast.makeText(Play.this,"开始录音",Toast.LENGTH_SHORT);
    		toast.show();
    		flag4=1;
    		}
            break;  
        case R.id.stop:  
            if(flag4==1)
        	{
            	stopRecorder(); 
      	        Toast toast1=Toast.makeText(Play.this,"录音停止",Toast.LENGTH_SHORT);
    		    toast1.show();
    		    flag4=0;
    		}
            break;
              
        case R.id.play:  
            
        	mPlayer = new MusicPlayer(Play.this);  
            mPlayer.playMicFile(recAudioFile); 
            Toast toast2=Toast.makeText(Play.this,"播放录音",Toast.LENGTH_SHORT);
    		toast2.show();
            break;  
        default:  
            break;  
        }  
    }  
  
    private void startRecorder() {  
        mMediaRecorder = new MediaRecorder();  
        if (recAudioFile.exists()) {  
            recAudioFile.delete();  
        }  
  
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);   
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);  
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);  
        mMediaRecorder.setOutputFile(recAudioFile.getAbsolutePath());  
        try {  
            mMediaRecorder.prepare();  
        } catch (IllegalStateException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        mMediaRecorder.start();  
    }  
      
    private void stopRecorder(){  
        if (recAudioFile!=null) {  
            mMediaRecorder.stop();  
            mMediaRecorder.release();  
        }  
    }  
    
	@Override
    protected void onResume()
    {  super.onResume();
    sm.registerListener(mySensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
  
	 protected void onStop(){
	    	sm.unregisterListener(mySensorListener);
	    	super.onStop();
	    }
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	@Override
    public boolean onKeyDown(int keyCode,KeyEvent event){   
        if (keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {   
           Intent intent1=new Intent();   
            intent1.setClass(Play.this, MainActivity.class);   
            startActivity(intent1);   
            Play.this.finish();  
        	
        }      
        return false; 
     }
	
}
