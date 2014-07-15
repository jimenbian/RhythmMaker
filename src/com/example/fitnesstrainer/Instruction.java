package com.example.fitnesstrainer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.KeyEvent;
//import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Instruction extends Activity implements OnGestureListener{

	private GestureDetector gestureDetector;
	private	ViewFlipper	flipper;
	private	LinearLayout	layout;
	private	Context	context;
	private	int	now	=	0;
	private	int	pictureCounts	=	2;	//鍥犱负鍙湁鍏紶鍥剧墖婊戝姩,鎵�互瀹氫箟涓�
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_instruction);
        init();
        
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){   
        if (keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {   
           Intent intent=new Intent();   
            intent.setClass(Instruction.this, MainActivity.class);   
            startActivity(intent);   
            Instruction.this.finish();  
        	
        }      
        return false; 
     } 
    /**
     * 鍒濆鍖朥I鍜屼竴浜涘睘鎬�     * */
    private	void	init(){
    	gestureDetector=new GestureDetector(this);
    	flipper	=	(ViewFlipper) findViewById(R.id.viewFlipper1);
    	flipper.setDisplayedChild(now);	//	寮�鍏堟樉绀虹涓�紶
    	layout	=	(LinearLayout) findViewById(R.id.linearLayout);   	
    	generatePageControl();
    }
    
    /**
     * 鍒濆鍖栨粦鍔ㄥ皬鐧界偣
     * */
    private void generatePageControl() {
    	layout.removeAllViews();

        for (int i = 0; i < pictureCounts; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setPadding(0, 0, 6, 0);
                if (now  == i) {
                        imageView.setImageResource(R.drawable.page00);//閫変腑鐨勫渾鐐瑰浘鐗囦笅闈㈢殑鍙嶄箣
                } else {
                        imageView.setImageResource(R.drawable.page01);
                }
                this.layout.addView(imageView);
        }
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (e2.getX() - e1.getX() > 120) {			 // 浠庡乏鍚戝彸婊戝姩锛堝乏杩涘彸鍑猴級
			Animation rInAnim = AnimationUtils.loadAnimation(Instruction.this, R.anim.push_right_in); 	// 鍚戝彸婊戝姩宸︿晶杩涘叆鐨勬笎鍙樻晥鏋滐紙alpha  0.1 -> 1.0锛�			Animation rOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_right_out); // 鍚戝彸婊戝姩鍙充晶婊戝嚭鐨勬笎鍙樻晥鏋滐紙alpha 1.0  -> 0.1锛�
			flipper.setInAnimation(rInAnim);
			Animation rOutAnim = null;
			flipper.setOutAnimation(rOutAnim);
			flipper.showPrevious();
			now--;
			if(now	<	0){
				now	=	pictureCounts	-	1;
			}
			generatePageControl();
			return true;
		} else if (e2.getX() - e1.getX() < -120) {		 // 浠庡彸鍚戝乏婊戝姩锛堝彸杩涘乏鍑猴級
			Animation lInAnim = AnimationUtils.loadAnimation(Instruction.this, R.anim.push_left_in);		// 鍚戝乏婊戝姩宸︿晶杩涘叆鐨勬笎鍙樻晥鏋滐紙alpha 0.1  -> 1.0锛�			Animation lOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.push_left_out); 	// 鍚戝乏婊戝姩鍙充晶婊戝嚭鐨勬笎鍙樻晥鏋滐紙alpha 1.0  -> 0.1锛�
			flipper.setInAnimation(lInAnim);
			Animation lOutAnim = null;
			flipper.setOutAnimation(lOutAnim);
			flipper.showNext();
			now++;
			if(now	>	pictureCounts	-	1){
				now	=	0;
			}
			generatePageControl();
			return true;
		}
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		 Intent intent = new Intent(Instruction.this, MainActivity.class);
         startActivity(intent);
         finish();
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "长按返回菜单"	+	now, Toast.LENGTH_SHORT).show();
		return false;
	}
	/*public boolean onDoubleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "aa"	+	now, Toast.LENGTH_SHORT).show();
		return false;
	}
	*/
	
 
}

