package com.jp.inifinite;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * A PagerAdapter that wraps around another PagerAdapter to handle paging wrap-around.
 * copy from https://github.com/antonyt/InfiniteViewPager
 */
public class InfinitePagerAdapterWrapper extends PagerAdapter implements Infinite {
    private static final String TAG = InfinitePagerAdapterWrapper.class.getSimpleName();

    private PagerAdapter adapter;

    public InfinitePagerAdapterWrapper(PagerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getCount() {
        // warning: scrolling to very high values (1,000,000+) results in
        // strange drawing behaviour
        return Integer.MAX_VALUE;
    }

    @Override
    public int getRealCount() {
        return adapter.getCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % getRealCount();
        Log.d(TAG, String.format("instantiateItem: real position: %d", position));
        Log.d(TAG, String.format("instantiateItem: virtual position: %d", virtualPosition));

        // only expose virtual position to the inner adapter
        return adapter.instantiateItem(container, virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % getRealCount();
        Log.d(TAG, String.format("destroyItem: real position: %d", position));
        Log.d(TAG, String.format("destroyItem: virtual position: %d", virtualPosition));

        // only expose virtual position to the inner adapter
        adapter.destroyItem(container, virtualPosition, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return adapter.getPageTitle(position % getRealCount());
    }

    /*
     * Delegate rest of methods directly to the inner adapter.
     */

    @Override
    public void finishUpdate(ViewGroup container) {
        adapter.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }

    @Override
    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        adapter.restoreState(bundle, classLoader);
    }

    @Override
    public Parcelable saveState() {
        return adapter.saveState();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        adapter.startUpdate(container);
    }
}