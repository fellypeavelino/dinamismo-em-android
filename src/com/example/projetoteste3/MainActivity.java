package com.example.projetoteste3;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
//http://stackoverflow.com/questions/10845172/android-running-a-method-periodically-using-postdelayed-call
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	private Handler recursivo;
	
	public void mudar(View v){
		setContentView(R.layout.layout2);
		this.horas();
		handler.post(sendData);
	}

	public void horas(){
		try{
			Calendar data = Calendar.getInstance();
			TextView text = (TextView)findViewById(R.id.horas);
			text.setText(data.get(Calendar.HOUR)+":"+data.get(Calendar.MINUTE)+":"+data.get(Calendar.SECOND));
			//Thread.sleep(1000);
			//horas();
		}catch(Exception e){
			
		}
		//recursivo.postDelayed(r, delayMillis)
	}
	
	Handler handler = new Handler();
	
	private final Runnable sendData = new Runnable(){
	    public void run(){
	        try {
	            //prepare and send the data here..
	        	//Calendar data = Calendar.getInstance();
				//TextView text = (TextView)findViewById(R.id.horas);
				//text.setText(data.get(Calendar.HOUR)+":"+data.get(Calendar.MINUTE)+":"+data.get(Calendar.SECOND));
	        	horas();
	            handler.postDelayed(this, 1000);    
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }   
	    }
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
