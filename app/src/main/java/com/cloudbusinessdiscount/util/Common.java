package com.cloudbusinessdiscount.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.util.Patterns;
import android.view.Window;
import android.view.WindowManager;

import com.cloudbusinessdiscount.IApp;
import com.cloudbusinessdiscount.configparams.LogFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/10/10 0010.
 */

public class Common {
    private static int STATUS_BAR_HEIGHT;//状态栏
    private static long lastClick;
    private static final int LASTCLICKTIME = 1000;

    public static final int PHOTOHRAPH = 100;// 拍照
    public static final int ALBUM = 101;// 相册
    public static final int CUT = 102;// 裁剪
    public static final int REQUEST_CODE = 103; // 获取相机或者通讯录或者文件存储权限回调请求码

    public final static String WEIXIN_CHATTING_MIMETYPE = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile";//微信聊天

    public static final String IMAGE_UNSPECIFIED = "image/*";

    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String APP_NAME = "YunShangHui";


    public static int getStatusBarHeight(Context mContext) {
        if (STATUS_BAR_HEIGHT == 0) {
            STATUS_BAR_HEIGHT = mContext.getResources().getSystem().getDimensionPixelSize(
                    mContext.getResources().getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        }
        return STATUS_BAR_HEIGHT;
    }

    /**
     * 获取android版本
     */
    public static int getAndroidSDKVersion() {
        int version = android.os.Build.VERSION.SDK_INT;
        return version;
    }

    /**
     * 获取APK版本
     *
     * @return true 存在
     */
    public static String getVersionCode(Context context) {
        String version = null;
        try {
            PackageManager packagemanager = context.getPackageManager();
            PackageInfo info = packagemanager.getPackageInfo(
                    context.getPackageName(), 0);
            version = info.versionName;
        } catch (Exception e) {
        }
        return version;
    }

    /**
     * 按照规定的逻辑，对常见类型判断是否为空
     */
    public static boolean empty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String && (obj.equals("") || obj.equals("0") || obj.equals("[]") || obj.equals("{}") || obj.equals("false"))) {
            return true;
        } else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
            return true;
        } else if (obj instanceof Boolean && !((Boolean) obj)) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 跳轉頁面
     *
     * @param fromcontext，toClass
     * @return by Hankkin at:2015-10-07 21:16:43
     */
    public static void openActivity(Context fromcontext, Class<?> toClass) {
        openActivity(fromcontext, toClass, null);
    }

    public static void openActivity(Context fromcontext, Class<?> toClass, int requestCode) {
        openActivity(fromcontext, toClass, null, requestCode, -1, -1);
    }

    public static void openActivity(Context fromcontext, Class<?> toClass, Bundle pBundle) {
        openActivity(fromcontext, toClass, pBundle, -1, -1, -1);
    }

    public static void openActivity(Context fromcontext, Class<?> toClass, Bundle pBundle, int requestCode) {
        openActivity(fromcontext, toClass, pBundle, requestCode, -1, -1);
    }

    public static void openActivity(Context fromcontext, Class<?> toClass, Bundle pBundle, int enterAnim,
                                    int exitAnim) {
        openActivity(fromcontext, toClass, pBundle, -1, enterAnim, exitAnim);
    }

    public static void openActivity(Context fromcontext, Class<?> toClass, Bundle pBundle, int requestCode,
                                    int enterAnim, int exitAnim) {

        if (System.currentTimeMillis() - lastClick <= LASTCLICKTIME) {
            return;
        }
        lastClick = System.currentTimeMillis();
        Intent intent = new Intent(fromcontext, toClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        if (-1 == requestCode) {
            ((Activity) fromcontext).startActivity(intent);
        } else {
            ((Activity) fromcontext).startActivityForResult(intent, requestCode);
        }

        if (-1 != enterAnim && -1 != exitAnim) {
            ((Activity) fromcontext).overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * 设置状态栏图标为深色和魅族特定的文字风格，Flyme4.0以上
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 是否是miuiv6系统
     *
     * @return
     */
    public static boolean isMIUIV6() {

        boolean isV6 = false;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            String property = properties.getProperty(KEY_MIUI_VERSION_NAME, null);
            if (!Common.empty(property)) {
                if (property.contains("V")) {
                    int version = Integer.parseInt(property.split("V")[1]);
                    if (version >= 7) {
                        isV6 = true;
                    }
                }
            }
        } catch (final IOException e) {
            return isV6;
        }

        return isV6;
    }

    public static boolean isMIUIV() {//如果是小米手机并且在miuiv6及以下，则不需要透明导航栏

        boolean isV6 = false;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            String property = properties.getProperty(KEY_MIUI_VERSION_NAME, null);
            if (!Common.empty(property)) {
                if (property.contains("V")) {
                    int version = Integer.parseInt(property.split("V")[1]);
                    if (version <= 6) {
                        isV6 = true;
                    }
                }
            }
        } catch (final IOException e) {
            return isV6;
        }

        return isV6;
    }

    public static boolean isFlyme4() {
        boolean isF4 = false;
            /* 获取魅族系统操作版本标识*/
        String meizuFlymeOSFlag = getSystemProperty("ro.build.display.id", "");
        if (!Common.empty(meizuFlymeOSFlag)) {
            if (meizuFlymeOSFlag.contains("Flyme")) {
                isF4 = true;
            }
        }
        return isF4;
    }

    private static String getSystemProperty(String key, String defaultValue) {
        try {
            Class<?> clz = Class.forName("android.os.SystemProperties");
            Method get = clz.getMethod("get", String.class, String.class);
            return (String) get.invoke(clz, key, defaultValue);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * @param context
     * @param isselect
     * @param path     图片保存地址
     * @return 0 sd卡不存在 1存储空间不足2其他原因3成功
     */
    public static int selectPhotoOrPhotograph(Context context, boolean isselect, String path) {
        int result = 3;
        if (!Common.isSDcardExist()) {
            result = 0;
            return result;
        } else if (Common.getAvailableSize() / 1024 < 1024) {
            result = 1;
            return result;
        }
        try {
            if (isselect) {// 相册
                Intent intent = new Intent();
                intent.setType(IMAGE_UNSPECIFIED);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                ((Activity) context).startActivityForResult(intent, ALBUM);
            } else {// 相机
                if (Common.empty(path)) {
                    result = 2;
                    return result;
                }

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(IApp.mContext.getPackageManager()) != null) {
                    // Create the File where the photo should go
                    String authority = IApp.mContext.getApplicationInfo().packageName + ".provider";
                    File file = new File(path);
                    Uri photoFile = FileProvider.getUriForFile(IApp.mContext, authority, file);

                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile);
                    }
                }
                ((Activity) context).startActivityForResult(takePictureIntent, PHOTOHRAPH);
            }
            return result;
        } catch (android.content.ActivityNotFoundException e) {
            LogFactory.createLog().e(e);
        }
        result = 2;
        return result;
    }

    /**
     * 检测SDcard是否存在
     *
     * @return true 存在
     */
    public static boolean isSDcardExist() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    private static long getAvailableSize() {
        File sdcardDir = Environment.getExternalStorageDirectory();
        StatFs fileStats = new StatFs(sdcardDir.getPath());
        fileStats.restat(sdcardDir.getPath());
        return (long) fileStats.getAvailableBlocks() * fileStats.getBlockSize(); // 注意与fileStats.getFreeBlocks()的区别
    }

    public static String getOneImagePathName() {//生成唯一的临时图片路径
        String path = ConfigUtil.STORE_PATH + System.currentTimeMillis() + ".jpg";
        CacheDataUtil.saveObject(path, "photoPath");
        return path;
    }

    /**
     * 使用DES3算法对字符串加密
     */
    public static String encryptMode(String arg0) {
        Log.i("params=", arg0);
        String result = null;
        try {
            result = DES3.encode(arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 使用DES3算法对字符串解密
     */
    public static String decryptDES(String arg0) {
        String result = "";
        try {
            if (arg0.contains("\\")) {
                arg0 = arg0.replace("\\", "");
            }
            result = DES3.decode(URLDecoder.decode(arg0, "UTF-8"));
            if (result.contains("\\")) {
                result = result.replace("\\", "");
            }
            if (result.contains("\"[")) {
                result = result.replace("\"[", "[");
            }
            if (result.contains("]\"")) {
                result = result.replace("]\"", "]");
            }
            if (result.contains("\"{")) {
                result = result.replace("\"{", "{");
            }
            if (result.contains("}\"")) {
                result = result.replace("}\"", "}");
            }

            result = StringEscapeUtils.unescapeHtml(result);
            result = StringEscapeUtils.unescapeHtml(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getDividePhone(String number) {
        if (number.startsWith("+86")) {
            number = number.substring(3);
        }

        if (number.startsWith("+") || number.startsWith("0")) {
            number = number.substring(1);
        }
        number = number.replace(" ", "").replace("-", "");
        return number;
    }


    /**
     * 将字符串中含有的大写字母转为小写字母
     */
    public static String TransportLetter(String arg0) {
        String result = arg0.toLowerCase();
        return result;
    }


    /**
     * 使用MD5算法对字符串加密
     */
    public static String md5(String arg0) {
        return MD5Util.encode(arg0);
    }

    public static String domains(String relativeurl) {
        return ConfigUtil.COMMURL + relativeurl;
    }


    /**
     * 获取视频文件缩略图 API>=8(2.2)
     *
     * @param path 视频文件的路径
     * @param kind 缩略图的分辨率：MINI_KIND、MICRO_KIND、FULL_SCREEN_KIND
     * @return Bitmap 返回获取的Bitmap
     */
    public static Bitmap getVideoThumb(String path, int kind) {
        return ThumbnailUtils.createVideoThumbnail(path, kind);
    }

    public static Bitmap getVideoThumb(String path) {
        return getVideoThumb(path, MediaStore.Video.Thumbnails.MINI_KIND);
    }


    /**
     * 获取视频文件时长 API>=8(2.2)
     *
     * @param path 视频文件的路径
     * @return String 返回获取的时长
     */
    public static String getVedioDuration(String path) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION); // 播放时长单位为毫秒
        return duration;
    }


    /**
     * 判断电话号码是否有效
     * 移动：134、135、136、137、138、139、147、150、151、152、157、158、159、182、183、187、188
     * 联通：130、131、132、145、155、156、185、186
     * 电信：133、153、180、181、189
     * 虚拟运营商：17x
     */
    public static boolean isMobileNO(String number) {
        if (number.startsWith("+86")) {
            number = number.substring(3);
        }

        if (number.startsWith("+") || number.startsWith("0")) {
            number = number.substring(1);
        }
        number = number.replace(" ", "").replace("-", "");
        Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(18[0-9])|(17[0-1,3,5-8]))\\d{8}$");
        Matcher m = p.matcher(number);

        return m.matches();
    }

    /**
     * 密码匹配，以字母开头，长度 在8-16之间，只能包含字符、数字和下划线。
     *
     * @param pwd
     * @return
     */
    public static boolean isCorrectUserPwd(String pwd) {
        Pattern p = Pattern.compile("^((?=.*[0-9].*)(?=.*[A-Za-z].*))[0-9A-Za-z_]{6,20}$");
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

    /**
     * 检测网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (mConnectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        }

        return false;
    }

    /**
     * @param name
     * @author wry
     * @category 判断是否为中文名字
     */
    public static boolean isChineseName(String name) {
        boolean res = false;
        // 只允许输入汉字
        String regexIsHanZi = "[\\u4e00-\\u9fa5]+";
        Pattern pattern = Pattern.compile(regexIsHanZi);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();//true为全部是汉字，否则是false
    }


    /**
     * 判断是否是json结构
     */
    public static boolean isJson(String value) {
        try {
            new JSONObject(value);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是url结构
     */
    public static boolean isUrl(String value) {
        if (Patterns.WEB_URL.matcher(value).matches()) {
            return true;
            //符合标准
        } else {
            return false;
            //不符合标准
        }
    }

    public static boolean isOnTop(Context con, Class<?> classname) {
        ActivityManager activityManager = (ActivityManager) con
                .getSystemService(Context.ACTIVITY_SERVICE);
        String name = activityManager.getRunningTasks(1).get(0).topActivity
                .getClassName();
        return name.equals(classname.getName());
    }
}