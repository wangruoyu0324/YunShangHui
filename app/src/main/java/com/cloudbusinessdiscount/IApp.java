package com.cloudbusinessdiscount;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.cloudbusinessdiscount.configparams.AppConfigPB;
import com.cloudbusinessdiscount.fresco.ImagePipelineConfigFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * 作者：wry
 * 邮箱：977649708@qq.com
 * 时间：2017/08/15 16:02
 */

public class IApp extends MultiDexApplication {
    public static Context mContext;
    public static AppConfigPB appConfigPB;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(getApplicationContext());
        Fresco.initialize(this, imagePipelineConfig);
    }

}
