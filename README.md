Infinite
===
---

Infinite lib based on [JakeWharton/ViewPageIndicator](https://github.com/JakeWharton/Android-ViewPagerIndicator) support view pager indicator can scroll infinitely

Feature
===
---
* support custom circle indicator
* support custom title indicator

Gradle Dependencies
===
---

    dependencies {
        compile 'com.github.porval:infiniteindicator:1.0.0'
    }


Sample Usage
===
---

1. Include one of the widgets in your view. This should usually be placed adjacent to the ViewPager it represents.

    ```
      <com.jp.inifinite.indicator.InfiniteCirclePagerIndicator
        android:id="@+id/pager_indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        />
      <com.jp.inifinite.InfinitePagerView
        android:id="@+id/pager_view"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        android:layout_above="@id/pager_indicator"
        />
    ```
2. In your onCreate method (or onCreateView for a fragment), bind the indicator to the ViewPager.

   ```
	mDemoPageAdapter = new DemoPagerAdapter(getSupportFragmentManager());
    mInfinitePagerView.setAdapter(mDemoPageAdapter);
    mInfinitePageIndicator.setViewPager(mInfinitePagerView);
   ```

License
=====

    Copyright @2015 Jiang peng

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
