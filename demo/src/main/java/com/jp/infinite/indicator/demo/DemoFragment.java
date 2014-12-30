package com.jp.infinite.indicator.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DemoFragment extends Fragment {

    private String mTitleStr;

    public DemoFragment title(String title) {
        mTitleStr = title;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_demo, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView title = (TextView) view.findViewById(R.id.title);
        if (mTitleStr != null && !mTitleStr.isEmpty() && title != null) {
            title.setText(mTitleStr);
        }
    }
}
