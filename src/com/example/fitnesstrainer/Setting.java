package com.example.fitnesstrainer;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends Activity {

	    private static final String[] m={"��","��","С"};
	    private static final String[] m1={"��","��","��","è��","����"};
	    private static final String[] m2={"��","��","��","è��","����"};
	    private static final String[] m3={"��","��","��","è��","����"};
	    private static final String[] m4={"�ޱ�������","����һ"};
	    private TextView view ;
	    private TextView view1 ;
	    private TextView view2 ;
	    private TextView view3 ;
	    private TextView view4 ;
	    private Spinner spinner;  
	    private ArrayAdapter<String> adapter;  
	 
        String[] result=new String[5];
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_setting);
		Button bn = (Button)findViewById(R.id.button1);
		 final Bundle bundle=new Bundle();
	    
		 final Intent intent=new Intent(Setting.this,Play.class);
		view = (TextView) findViewById(R.id.spinnerText);  
        spinner = (Spinner) findViewById(R.id.Spinner01);    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());  
          
        //����Ĭ��ֵ  
        spinner.setVisibility(View.VISIBLE);  
        ////////////////////////////////////////////////////////////////
        
        view1 = (TextView) findViewById(R.id.spinnerText1);  
        spinner = (Spinner) findViewById(R.id.Spinner02);    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m1);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener1());  
          
        //����Ĭ��ֵ  
        spinner.setVisibility(View.VISIBLE);
        ////////////////////////////////////////////////////////////////////
        
        view2 = (TextView) findViewById(R.id.spinnerText2);  
        spinner = (Spinner) findViewById(R.id.Spinner03);    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m2);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener2());  
          
        //����Ĭ��ֵ  
        spinner.setVisibility(View.VISIBLE);  
          /////////////////////////////////////////////////////////
        view3 = (TextView) findViewById(R.id.spinnerText3);  
        spinner = (Spinner) findViewById(R.id.Spinner04);    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m3);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener3());  
          
        //����Ĭ��ֵ  
        spinner.setVisibility(View.VISIBLE); 
        /////////////////////////////////////////////////////////////////
        view4 = (TextView) findViewById(R.id.textView1);  
        spinner = (Spinner) findViewById(R.id.spinner1);    
        //����ѡ������ArrayAdapter��������  
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m4);  
          
        //���������б�ķ��  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
          
        //��adapter ��ӵ�spinner��  
        spinner.setAdapter(adapter);  
          
        //����¼�Spinner�¼�����    
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener4());  
          
        //����Ĭ��ֵ  
        spinner.setVisibility(View.VISIBLE);
        
        bn.setOnClickListener(new OnClickListener() {
            @Override
        	 public void onClick(View sourse) {
            
            	
            	bundle.putStringArray("result",result); 
                intent.putExtras(bundle);
            	startActivity(intent);
                finish();
            }
        });
      
	}
	
	  class SpinnerSelectedListener implements OnItemSelectedListener{  
		  
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
                long arg3) {  
            view.setText("������С�ǣ�"+m[arg2]);
            /*Bundle bundle=new Bundle();
            Intent intent=new Intent(Setting.this,Play.class);*/
           
            switch(arg2)
            {case 0:
            	result[0]="1.3";
            	break;
            case 1:
            	/*bundle.putString("result","0.7"); 
                
                intent.putExtras(bundle); */
            	result[0]="0.7";
            	break;
            case 2:
            	/*bundle.putString("result","0.3"); 
                
                intent.putExtras(bundle); */
            	result[0]="0.1";
            	break;
            
            }
            //startActivity(intent);
           
        }  
  
        public void onNothingSelected(AdapterView<?> arg0) {  
        }  
    } 
	  
	  class SpinnerSelectedListener1 implements OnItemSelectedListener{  
		  
	        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
	                long arg3) {  
	            view1.setText("������ѡ�����ǣ�"+m1[arg2]);  
	            switch(arg2)
	            {case 0:
	            	result[1]="0";
	            	break;
	            case 1:
	            	/*bundle.putString("result","0.7"); 
	                
	                intent.putExtras(bundle); */
	            	result[1]="1";
	            	break;
	            case 2:
	            	/*bundle.putString("result","0.3"); 
	                
	                intent.putExtras(bundle); */
	            	result[1]="2";
	            	break;
	            case 3:
	            	result[1]="3";
	            	break;
	            case 4:
	            	result[1]="4";
	            	break;
	            
	            }
	        }  
	  
	        public void onNothingSelected(AdapterView<?> arg0) {  
	        }  
	    } 
	  
	  class SpinnerSelectedListener2 implements OnItemSelectedListener{  
		  
	        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
	                long arg3) {  
	            view2.setText("������ѡ�����ǣ�"+m2[arg2]);  
	            switch(arg2)
	            {case 0:
	            	result[2]="1";
	            	break;
	            case 1:
	            	/*bundle.putString("result","0.7"); 
	                
	                intent.putExtras(bundle); */
	            	result[2]="0";
	            	break;
	            case 2:
	            	/*bundle.putString("result","0.3"); 
	                
	                intent.putExtras(bundle); */
	            	result[2]="2";
	            	break;
	            case 3:
	            	result[2]="3";
	            	break;
	            case 4:
	            	result[2]="4";
	            	break;
	            
	            }
	        }  
	  
	        public void onNothingSelected(AdapterView<?> arg0) {  
	        }  
	    } 
	  
	  class SpinnerSelectedListener3 implements OnItemSelectedListener{  
		  
	        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
	                long arg3) {  
	            view3.setText("�����ѡ�����ǣ�"+m3[arg2]); 
	            switch(arg2)
	            {case 0:
	            	result[3]="2";
	            	break;
	            case 1:
	            	/*bundle.putString("result","0.7"); 
	                
	                intent.putExtras(bundle); */
	            	result[3]="1";
	            	break;
	            case 2:
	            	/*bundle.putString("result","0.3"); 
	                
	                intent.putExtras(bundle); */
	            	result[3]="0";
	            	break;
	            case 3:
	            	result[3]="3";
	            	break;
	            case 4:
	            	result[3]="4";
	            	break;
	            
	            }
	        }
	        
	  
	        public void onNothingSelected(AdapterView<?> arg0) {  
	        }  
	    } 
	  class SpinnerSelectedListener4 implements OnItemSelectedListener{  
		  
	        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
	                long arg3) {  
	            view4.setText("���������ǣ�"+m4[arg2]); 
	            switch(arg2)
	            {case 0:
	            	result[4]="2";
	            	break;
	            case 1:
	            	
	            	result[4]="1";
	            	break;
	           
	            
	            }
	        }
	        
	  
	        public void onNothingSelected(AdapterView<?> arg0) {  
	        }  
	    } 
	   
	   
	   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

}
