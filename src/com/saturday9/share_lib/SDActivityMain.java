package com.saturday9.share_lib;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;

public class SDActivityMain extends Activity implements OnClickListener {
	
	private View mLayoutMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sdactivity_main);
		
		findViewById(R.id.btn_image_save).setOnClickListener(this);
		findViewById(R.id.btn_share).setOnClickListener(this);
		
		// if you want to save a image from main view, you must set 
		mLayoutMain = findViewById(R.id.layout_main);
		mLayoutMain.setDrawingCacheEnabled(true);
		// background color
		mLayoutMain.setDrawingCacheBackgroundColor(0x00);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			
		case R.id.btn_share:
			SDHelperClasses.shareImages(this, Environment.getExternalStorageDirectory() + "/downloads/test_image.jpg");
			break;

		case R.id.btn_image_save:
			SDHelperClasses.saveBitmapFromView(mLayoutMain, Environment.getExternalStorageDirectory() + "/downloads/save_test.png");
			break;
		default:
			break;
		}
	}
}
