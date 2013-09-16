package com.example.testprog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


public class CustumProgress extends LinearLayout {
//    @SuppressWarnings("unused")
    private static final String TAG = CustumProgress.class.getSimpleName();
    
    static int WIDTH_PROG  =116;
    static int HEIGHT_PROG = 76;
    static int HEIGHT_TXT  = 30;
    
    private ProgressBar mProgress;
    private TextView    mTextView;
    private Context     mContext;
    //View mViewProg;
    
    /**
     * コンストラクタ
     * 
     * @param context context
     */
    public CustumProgress(Context context) {
        this(context, null);
    }
    
    /**
     * コンストラクタ
     * 
     * @param context context
     * @param attrs attributeset
     */
    public CustumProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOrientation(VERTICAL);
        setBackgroundColor(Color.argb(128, 0, 0, 0));
        this.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
        mContext = context;
        
        init_progress(context);
    }
    
    void init_progress(Context context){
    	mProgress= new ProgressBar(context);
    	int i_w   = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  WIDTH_PROG, this.getResources().getDisplayMetrics());
    	int i_h   = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  HEIGHT_PROG, this.getResources().getDisplayMetrics());
    	int i_ht  = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  HEIGHT_TXT, this.getResources().getDisplayMetrics());
    	
        LinearLayout.LayoutParams llp =  new LinearLayout.LayoutParams(i_w, i_h);
        mProgress.setLayoutParams(llp);
        mProgress.setBackgroundColor(Color.BLACK );
        this.addView(mProgress);
        
        mTextView= new TextView(context);
        LinearLayout.LayoutParams llt =  new LinearLayout.LayoutParams(i_w, i_ht);
        mTextView.setLayoutParams(llt);
        mTextView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        mTextView.setBackgroundColor(Color.BLACK );
        mTextView.setTextColor(Color.WHITE);
        addView(mTextView);
        
        setVisibility(View.INVISIBLE);
    }

    public void set_titie(String msg){
    	mTextView.setText(msg);
    }
    
	public void start()
	{
		setVisibility(View.VISIBLE);
	}

	public void cancel()
	{
		setVisibility(View.INVISIBLE);
	}

  
}
