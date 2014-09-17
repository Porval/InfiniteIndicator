package com.jp.inifinite;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * A {@link android.support.v4.view.ViewPager} that allows pseudo-infinite paging with a wrap-around effect. Should be used with an {@link
 * InfinitePagerAdapterWrapper}.
 * copy from https://github.com/antonyt/InfiniteViewPager
 */
public class InfinitePagerView extends ViewPager {
    public InfinitePagerView(Context context) {
        super(context);
    }

    public InfinitePagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        // offset first element so that we can scroll to the left
        setCurrentItem(0);
    }

    @Override
    public void setCurrentItem(int item) {
        // offset the current item to ensure there is space to scroll
        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        PagerAdapter pagerAdapter = getAdapter();
        if (pagerAdapter instanceof InfinitePagerAdapterWrapper) {
            int currentItem = getCurrentItem();
            int virtualCurrentItem = super.getCurrentItem();
            int realCount = ((InfinitePagerAdapterWrapper) pagerAdapter).getRealCount();
            if (virtualCurrentItem < getOffsetAmount()) {
                item = getOffsetAmount() + (item % realCount);
            } else {
                if (item > currentItem) {
                    item = virtualCurrentItem + (item - currentItem) % realCount;
                } else {
                    item = virtualCurrentItem - (currentItem - item);
                }
            }
        }
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public int getCurrentItem() {
        int position = super.getCurrentItem();
        if (getAdapter() instanceof InfinitePagerAdapterWrapper) {
            InfinitePagerAdapterWrapper infAdapter = (InfinitePagerAdapterWrapper) getAdapter();
            // Return the actual item position in the data backing InfinitePagerAdapter
            return (position % infAdapter.getRealCount());
        } else {
            return super.getCurrentItem();
        }
    }

    private int getOffsetAmount() {
        if (getAdapter() instanceof InfinitePagerAdapterWrapper) {
            InfinitePagerAdapterWrapper infAdapter = (InfinitePagerAdapterWrapper) getAdapter();
            // allow for 100 back cycles from the beginning
            // should be enough to create an illusion of infinity
            // warning: scrolling to very high values (1,000,000+) results in
            // strange drawing behaviour
            return infAdapter.getRealCount() * 100;
        } else {
            return 0;
        }
    }
}