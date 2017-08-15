package com.cloudbusinessdiscount.util;

import android.content.Context;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.cloudbusinessdiscount.IApp;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class ConfigUtil {

    // 所需的全部权限
    public static final String PERMISSIONS_CAMERA = "Manifest.permission.CAMERA";
    public static final String PERMISSIONS_AUDIO = "Manifest.permission.RECORD_AUDIO";
    public static final String PERMISSIONS_CONTACTS = "Manifest.permission.READ_CONTACTS";
    public static final String PERMISSIONS_STORAGE_READ = "Manifest.permission.READ_EXTERNAL_STORAGE";
    public static final String PERMISSIONS_STORAGE_WRITE = "Manifest.permission.WRITE_EXTERNAL_STORAGE";


    public static final String COMMURL = "https://api.ac57.cn/";//请求数据域名
    public static final String STORE_PATH = Environment.getExternalStorageDirectory() + "/云商惠/";//图片保存文件夹

    public static Integer getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) (IApp.mContext.getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay().getMetrics(dm);
        int screenwidth = dm.widthPixels;
        return screenwidth;
    }

    public static Integer getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) (IApp.mContext.getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay().getMetrics(dm);
        int screenheight = dm.heightPixels;
        return screenheight;
    }
}
