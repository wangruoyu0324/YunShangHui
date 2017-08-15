package com.cloudbusinessdiscount.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.cloudbusinessdiscount.R;
import com.cloudbusinessdiscount.configparams.AppConfigManager;
import com.cloudbusinessdiscount.configparams.AppConfigPB;
import com.cloudbusinessdiscount.dialog.LoadingDialog;
import com.cloudbusinessdiscount.util.Common;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * @author wry
 */

public class BaseActivity extends AppCompatActivity {
    private boolean isOffset1 = Common.isMIUIV6();//判断时都是MIUIV6以上系统，用于设置状态栏颜色为黑色
    private boolean isOffset2 = Common.isFlyme4();//判断时都是Flyme4以上系统，用于设置状态栏颜色为黑色

    public static final String REGISTER_TAG = "register";
    public static final String LOGINED_TAG = "logined";
    public AppConfigPB appConfigPB = AppConfigManager.getInitedAppConfig();

    private static Map<String, Set<WeakReference<Activity>>> activityGroup = new HashMap<String, Set<WeakReference<Activity>>>();
    private Context mContext;
    public static LoadingDialog loadingDialog;

    private boolean isSetStatusBar = false;

    /**
     * 显示加载对话框
     */
    public void showLoading() {
        if (null == loadingDialog) {
            loadingDialog = new LoadingDialog(mContext);
        }
        if (!loadingDialog.isShowing()) loadingDialog.show();
    }

    /**
     * 取消加载对话框
     */
    public void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @TargetApi(VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        if (Common.getAndroidSDKVersion() >= 14) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
        if (isOffset1) {
            Common.MIUISetStatusBarLightMode(getWindow(), true);
        } else if (isOffset2) {
            Common.FlymeSetStatusBarLightMode(getWindow(), true);
        } else {
            Android4_4Change();
        }
        if (Fresco.getImagePipeline().isPaused()) {
            Fresco.getImagePipeline().resume();
        }
    }


    protected void hideKeyBoard() {
        View curFocusView = getCurrentFocus();
        if (curFocusView != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(curFocusView.getWindowToken(), 0);
        }
    }

    @Override
    protected void onStop() {
        hideKeyBoard();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        fixInputMethodManagerLeak(mContext);
        super.onDestroy();
    }


    public static void fixInputMethodManagerLeak(Context destContext) {
        if (SDK_INT < KITKAT || SDK_INT > 22) {
            return;
        }
        if (destContext == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f;
        Object obj_get;
        for (int i = 0; i < arr.length; i++) {
            String param = arr[i];
            try {
                f = imm.getClass().getDeclaredField(param);
                if (f == null) {
                    return;
                }
                f.setAccessible(true);
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get.getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        break;
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        hideKeyBoard();
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
    }

    private void Android4_4Change() {
        if (SDK_INT >= VERSION_CODES.M) {//大于等于6.0设置状态栏字体颜色为深色
            // 透明状态栏
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (isSetStatusBar) {
                if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                    window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                } else {
                    window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
                }
            } else {
                if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                    window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                } else {
                    window.setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar_bg_color));
                }
            }
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else {
            if (SDK_INT >= VERSION_CODES.LOLLIPOP_MR1) {
                // 透明状态栏
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                // | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                // | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (isSetStatusBar) {
                    if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                    } else {
                        window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
                    }
                } else {
                    if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                    } else {
                        window.setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar_bg_color));
                    }
                }
                window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
            } else {
                if (SDK_INT >= VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//			 | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                    window.getDecorView()
                            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    // | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    if (isSetStatusBar) {
                        if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                        } else {
                            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
                        }
                    } else {
                        if (Build.MANUFACTURER.toLowerCase().contains("samsung")) {
                            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                        } else {
                            window.setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar_bg_color));
                        }
                    }
                    window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
                } else {
                    if (SDK_INT >= KITKAT) {
                        if (!Common.isMIUIV()) {
                            // 透明状态栏
                            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        }
                        // 透明导航栏
//					 getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                    }
                }
            }
        }
    }

    public synchronized void addActToGroup(String Groupname, Activity cur) {
        mContext = cur;
        Set<WeakReference<Activity>> Group = activityGroup.get(Groupname);
        if (Group == null) {
            Group = new HashSet<WeakReference<Activity>>();
            activityGroup.put(Groupname, Group);
        }
        Group.add(new WeakReference<Activity>(cur));
    }

    public synchronized void destroyGroup(String Groupname) {
        Set<WeakReference<Activity>> group = activityGroup.get(Groupname);
        if (group != null) {
            for (WeakReference<Activity> one : group) {
                if (one.get() != null) {
                    one.get().finish();
                }
            }
        }
    }

    public void setStatusBarAlpha(boolean flag) {
        isSetStatusBar = flag;
        if (isSetStatusBar) {
            if (isOffset1) {
                Common.MIUISetStatusBarLightMode(getWindow(), false);
                Android4_4Change();
            } else if (isOffset2) {
                Common.FlymeSetStatusBarLightMode(getWindow(), false);
                Android4_4Change();
            } else {
                Android4_4Change();
            }
        } else {
            if (isOffset1) {
                Common.MIUISetStatusBarLightMode(getWindow(), true);
            } else if (isOffset2) {
                Common.FlymeSetStatusBarLightMode(getWindow(), true);
            } else {
                Android4_4Change();
            }
        }
    }
}
