package com.shily.shared_shop.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shily.shared_shop.R;

/**
 * Created by shanlihou on 17-10-23.
 */
public class ContentFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content, container, false);
    }
}
