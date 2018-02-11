package mobile.app.qybae.demo.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.helper.MyFunction;

public class MovieFragment extends MyFunction {

    /*@BindView(R.id.rvFragrecview)
    RecyclerView rvFragrecview;*/
    String TAG;
    @BindView(R.id.VpMovieFragment)
    ViewPager VpMovieFragment;
    @BindView(R.id.TabsLayoutFrag)
    TabLayout TabsLayoutFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_fragment);
        ButterKnife.bind(this);

        TabsLayoutFrag.addTab(TabsLayoutFrag.newTab().setText("Now Playing").setIcon(R.drawable.ic_menu_gallery));
        TabsLayoutFrag.addTab(TabsLayoutFrag.newTab().setText("Upcoming").setIcon(R.drawable.ic_menu_slideshow));
        PagerAdapter pagerAdapter = new TabAdapter (getSupportFragmentManager());

        VpMovieFragment.setAdapter(pagerAdapter);
        TabsLayoutFrag.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                VpMovieFragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        VpMovieFragment.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabsLayoutFrag));
    }


    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0 : fragment = new PlayFragment(); break;
                case 1 : fragment = new UpcomingFragment(); break;

            }
            return fragment;
        }


        @Override
        public int getCount() {
            return 2;
        }
    }
}
