package com.cloudbusinessdiscount.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cloudbusinessdiscount.R;
import com.cloudbusinessdiscount.fragment.FragmentFour;
import com.cloudbusinessdiscount.fragment.FragmentOne;
import com.cloudbusinessdiscount.fragment.FragmentThree;
import com.cloudbusinessdiscount.fragment.FragmentTwo;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wry
 * @date 2017/8/15 0015 15:43
 */
public class MainActivity extends BaseActivity {

    @BindArray(R.array.tabhostarray)
    String[] array;
    @BindView(android.R.id.tabhost)
    FragmentTabHost fragmentTabHost;

    private Class fragmentArray[] = {FragmentOne.class, FragmentTwo.class, FragmentThree.class, FragmentFour.class};
    private int[] imageRes = {R.drawable.selector_tabhost_homepage, R.drawable.selector_tabhost_infomation, R.drawable.selector_tabhost_shoppingcar, R.drawable.selector_tabhost_mine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);//写上这一句就不会出现夹在fragment时候出现黑色闪屏
        ButterKnife.bind(this);
        addActToGroup(LOGINED_TAG, this);

        fragmentTabHost.setup(MainActivity.this, getSupportFragmentManager(), R.id.maincontent);
        for (int i = 0; i < array.length; i++) {
            TabHost.TabSpec spec = fragmentTabHost.newTabSpec(array[i]).setIndicator(getView(i));
            fragmentTabHost.addTab(spec, fragmentArray[i], null);
        }
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
    }

    private View getView(int i) {
        //取得布局实例
        final View view = View.inflate(MainActivity.this, R.layout.tabcontent, null);

        //取得布局对象
        TextView textView = (TextView) view.findViewById(R.id.text);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);

        //设置图标
        textView.setText(array[i]);
        imageView.setImageResource(imageRes[i]);
        return view;
    }
}
