package com.cloudbusinessdiscount.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudbusinessdiscount.R;

import butterknife.ButterKnife;

/**
 * 作者：wry
 * 邮箱：977649708@qq.com
 * 时间：2017/08/15 16:36
 */

public class FragmentThree extends BaseFragment {
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ButterKnife.bind(this, mRootView);
            return mRootView;
        }
        mRootView = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }
}
