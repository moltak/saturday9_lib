package com.saturday9.share_lib;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;

public class SDHelperClasses {
	public static void shareImages(Activity activity, String imagePath) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/png");
		intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imagePath));
		activity.startActivity(intent);
	}
	
	public static void saveBitmapFromView(View view, String path) {
		if(view != null) {
			Bitmap  bitmap = view.getDrawingCache();
			
			try {
				FileOutputStream fos = new FileOutputStream(path);
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
