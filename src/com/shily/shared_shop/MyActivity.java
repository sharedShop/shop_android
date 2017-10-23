package com.shily.shared_shop;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MyActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;

    private ContentFragment mWeixin;
    private ShopFragment mShop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        // 初始化控件和声明事件
        mTabWeixin = (LinearLayout) findViewById(R.id.tab_home_page);
        mTabFriend = (LinearLayout) findViewById(R.id.tab_local);
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);

        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWeixin = new ContentFragment();
        transaction.replace(R.id.id_content, mWeixin);
        transaction.commit();
    }

    @Override
    public void onClick(View v)
    {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId())
        {
            case R.id.tab_home_page:
                if (mWeixin == null)
                {
                    mWeixin = new ContentFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, mWeixin);
                break;
            case R.id.tab_local:
                if (mShop == null)
                {
                    mShop = new ShopFragment();
                }
                transaction.replace(R.id.id_content, mShop);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }
}
