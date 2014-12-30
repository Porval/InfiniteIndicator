package com.jp.infinite.indicator.demo;

import android.os.Bundle;

import com.jp.inifinite.InfinitePagerView;
import com.jp.inifinite.indicator.InfinitePageIndicator;

public class DemoTitleInfiniteIndicatorAct extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo_title);
        setTitle("Demo Title Infinite");
    }

    @Override
    public InfinitePageIndicator onCreateInfinitePageIndicator() {
        return (InfinitePageIndicator) findViewById(R.id.pager_indicator);
    }

    @Override
    public InfinitePagerView onCreateInfinitePagerView() {
        return (InfinitePagerView) findViewById(R.id.pager_view);
    }
}
