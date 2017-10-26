package com.shily.shared_shop.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import com.shily.shared_shop.Fragment.ContentFragment;
import com.shily.shared_shop.Fragment.HomeFragment;
import com.shily.shared_shop.R;

public class MyActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    private LinearLayout mTabHome;
    private LinearLayout mTabFriend;

    private ContentFragment mWeixin;
    private HomeFragment mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        // 初始化控件和声明事件
        mTabHome = (LinearLayout) findViewById(R.id.tab_home_page);
        mTabFriend = (LinearLayout) findViewById(R.id.tab_local);
        mTabHome.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);

        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHome = new HomeFragment();
        transaction.replace(R.id.id_content, mHome);
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
                if (mHome == null)
                {
                    mHome = new HomeFragment();
                }
                transaction.replace(R.id.id_content, mHome);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }
}
