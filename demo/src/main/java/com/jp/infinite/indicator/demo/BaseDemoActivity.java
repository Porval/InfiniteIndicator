package com.jp.infinite.indicator.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jp.inifinite.InfinitePagerView;
import com.jp.inifinite.indicator.InfinitePageIndicator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDemoActivity extends FragmentActivity {

    private InfinitePagerView mInfinitePagerView;

    private InfinitePageIndicator mInfinitePageIndicator;

    private DemoPagerAdapter mDemoPageAdapter;

    private String mTitle;

    //在onStart中调用
    public abstract InfinitePagerView onCreateInfinitePagerView();

    //在onStart中调用
    public abstract InfinitePageIndicator onCreateInfinitePageIndicator();

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mInfinitePagerView = onCreateInfinitePagerView();
        mInfinitePageIndicator = onCreateInfinitePageIndicator();

        mDemoPageAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        mDemoPageAdapter.init();

        mInfinitePagerView.setAdapter(mDemoPageAdapter);
        mInfinitePageIndicator.setViewPager(mInfinitePagerView);
    }

    private class DemoPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;

        public DemoPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList = new ArrayList<Fragment>();
        }

        public void init() {
            for (int index = 0; index < 5; index++) {
                mFragmentList.add(
                        new DemoFragment()
                                .title(mTitle)
                );
            }
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.format("Fragment %s", position);
        }
    }
}
