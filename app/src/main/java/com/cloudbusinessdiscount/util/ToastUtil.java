package com.cloudbusinessdiscount.util;

import android.widget.Toast;

import com.cloudbusinessdiscount.IApp;

/**
 * @author wry
 */
public class ToastUtil {
	
    private static Toast mToast;

	public static void showShort(int resid) {
		show(IApp.mContext.getString(resid), Toast.LENGTH_SHORT);
    }

    public static void showShort(String msg) {
    	show(msg, Toast.LENGTH_SHORT);
    }

    public static void showLong(int resid) {
    	show(IApp.mContext.getString(resid), Toast.LENGTH_LONG);
    }

    public static void showLong(String msg) {
    	show(msg, Toast.LENGTH_LONG);
    }
    
    public static void show(String msg,int duration){
    	if (Common.empty(msg)) {
			return;
		}
    	if (mToast == null) {
    		mToast = Toast.makeText(IApp.mContext, msg, duration );
		}else {
			mToast.setText(msg);
			mToast.setDuration(duration);
		}
    	
    	mToast.show();
    }

}
