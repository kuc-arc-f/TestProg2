package com.example.testprog;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	CustumProgress mCProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progress_init( );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick_tst(View v){
		mCProgress.start();
		
		Handler hdl = new Handler();
		hdl.postDelayed(new stopHandler(), 5000);
	}
	
	void progress_init( )
	{
		View view = this.getLayoutInflater().inflate(R.layout.prog, null);
		mCProgress= (CustumProgress)view.findViewById(R.id.progress1);
		mCProgress.set_titie("Loadging..");
		
		addContentView(view, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT ));
	}
	
	class stopHandler implements Runnable {
		public void run() {
			mCProgress.cancel();
		}
	}
}
