package com.cloudbusinessdiscount.dialog;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;

import com.cloudbusinessdiscount.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoadingDialog extends Dialog {
    private SimpleDraweeView mLoading;
    private Context mContext;
    private String msg = "";

    public LoadingDialog(Context context) {
        super(context, R.style.Theme_Light_FullScreenDialogAct);
        mContext = context;
        init();
    }

    public LoadingDialog(Context context, String msg) {
        super(context, R.style.Theme_Light_FullScreenDialogAct);
        this.msg = msg;
        mContext = context;
        init();
    }


    private void init() {
        setContentView(R.layout.dialog_loading);
        mLoading = (SimpleDraweeView) findViewById(R.id.ic_loading);

        setCanceledOnTouchOutside(false);
    }


    @Override
    public void show() {//在要用到的地方调用这个方法
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res://" + mContext.getPackageName() + "/" + R.drawable.icon_loading))
                .setAutoPlayAnimations(true)
                .build();
        mLoading.setController(controller);
        super.show();
    }


    @Override
    public void setTitle(int titleId) {
        setTitle(getContext().getString(titleId));
    }


}