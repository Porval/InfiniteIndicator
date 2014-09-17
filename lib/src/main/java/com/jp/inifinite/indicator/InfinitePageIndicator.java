package com.jp.inifinite.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.jp.inifinite.Infinite;


public abstract class InfinitePageIndicator extends View implements PageIndicator {

    protected ViewPager mViewPager;

    protected int mCurrentPage;

    public InfinitePageIndicator(Context context) {
        super(context);
    }

    public InfinitePageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InfinitePageIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setViewPager(ViewPager view) {
        if (mViewPager == view) {
            return;
        }
        if (mViewPager != null) {
            mViewPager.setOnPageChangeListener(null);
        }
        if (view.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        mViewPager = view;
        mViewPager.setOnPageChangeListener(this);
        invalidate();
    }

    /**
     * 获取page adapter count
     *
     * @return page adapter中数量
     */
    public int getPageCount() {
        PagerAdapter adapter = mViewPager.getAdapter();
        if (adapter instanceof Infinite) {
            return ((Infinite) adapter).getRealCount();
        }
        return adapter.getCount();
    }


    public void setCurrentPage(int position) {
        PagerAdapter adapter = mViewPager.getAdapter();
        if (adapter instanceof Infinite) {
            int count = getPageCount();
            if (count > 0) {
                mCurrentPage = position % getPageCount();
                return;
            }
        }

        mCurrentPage = position;
    }

    /**
     * Bind the indicator to a ViewPager.
     *
     * @param view
     * @param initialPosition
     */
    @Override
    public void setViewPager(ViewPager view, int initialPosition) {
        mViewPager = view;
        setCurrentItem(initialPosition);
    }

    @Override
    public void setCurrentItem(int item) {
        if (mViewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }

        mViewPager.setCurrentItem(item);
        mCurrentPage = mViewPager.getCurrentItem();

        invalidate();
    }
}
