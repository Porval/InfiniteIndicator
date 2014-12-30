package com.jp.infinite.indicator.demo;

import android.os.Bundle;

import com.jp.inifinite.InfinitePagerView;
import com.jp.inifinite.indicator.InfinitePageIndicator;
import com.jp.inifinite.indicator.demo.R;

public class DemoCircleInfiniteIndicatorAct extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_demo_circle);
        setTitle("Demo Circle Infinite Indicator ");
    }

    @Override
    public InfinitePagerView onCreateInfinitePagerView() {
        return (InfinitePagerView) findViewById(R.id.pager_view);
    }

    @Override
    public InfinitePageIndicator onCreateInfinitePageIndicator() {
        return (InfinitePageIndicator) findViewById(R.id.pager_indicator);
    }
}
