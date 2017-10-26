package com.shily.shared_shop.Fragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.shily.shared_shop.R;
import com.shily.shared_shop.parameter.Constant;
import com.shily.shared_shop.util.MakeImage;
import com.shily.shared_shop.view.ImageTextButton;

/**
 * Created by shanlihou on 17-10-23.
 */
public class HomeFragment extends Fragment {
    RelativeLayout mArcImage;
    View mView;
    ImageTextButton mWholeBt;
    ImageTextButton mDividBt;
    ImageTextButton mShopInShopBt;
    ImageTextButton mMapBt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frag_home, container, false);
        /***test***/
        MakeImage test = new MakeImage();
        Resources res=getResources();
        Bitmap bmp= BitmapFactory.decodeResource(res, R.drawable.blue);
        Bitmap dst = test.createCircleImage(bmp, 200);
        BitmapDrawable bd = new BitmapDrawable(dst);
        /***test***/
        mArcImage = (RelativeLayout) mView.findViewById(R.id.id_arc_image);
        //mArcImage.setBackground(getResources().getDrawable(R.drawable.blue));
        mArcImage.setBackground(bd);
        initButton();
        return mView;
    }
    private void initButton(){
        mWholeBt = (ImageTextButton)mView.findViewById(R.id.id_whole_shop);
        mDividBt = (ImageTextButton)mView.findViewById(R.id.id_divide_shop);
        mShopInShopBt = (ImageTextButton)mView.findViewById(R.id.id_shop_in_shop);
        mMapBt = (ImageTextButton)mView.findViewById(R.id.id_map_shop);

        mWholeBt.setImgResource(R.drawable.zhuye1);
        mDividBt.setImgResource(R.drawable.zhuye2);
        mShopInShopBt.setImgResource(R.drawable.zhuye3);
        mMapBt.setImgResource(R.drawable.zhuye4);

        mWholeBt.setText(Constant.HOME_WHOLE_SHOP);
        mDividBt.setText(Constant.HOME_DIVIDE_SHOP);
        mShopInShopBt.setText(Constant.HOME_SHOP_IN_SHOP);
        mMapBt.setText(Constant.HOME_MAP_SHOP);
    }
}
