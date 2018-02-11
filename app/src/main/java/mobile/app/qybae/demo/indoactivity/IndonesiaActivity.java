package mobile.app.qybae.demo.indoactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;

public class IndonesiaActivity extends AppCompatActivity {

    @BindView(R.id.VpIndoFragment)
    ViewPager VpIndoFragment;
    @BindView(R.id.TabsLayoutIndo)
    TabLayout TabsLayoutIndo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia);
        ButterKnife.bind(this);

        TabsLayoutIndo.addTab(TabsLayoutIndo.newTab().setText("Register").setIcon(R.drawable.ic_menu_gallery));
        TabsLayoutIndo.addTab(TabsLayoutIndo.newTab().setText("News").setIcon(R.drawable.ic_menu_camera));
        TabsLayoutIndo.addTab(TabsLayoutIndo.newTab().setText("Location").setIcon(R.drawable.ic_menu_send));
        PagerAdapter pagerAdapter = new TabAdapter (getSupportFragmentManager());

        VpIndoFragment.setAdapter(pagerAdapter);

        TabsLayoutIndo.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                VpIndoFragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        VpIndoFragment.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabsLayoutIndo));
    }

    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0 : fragment = new RegisterFragment(); break;
                case 1 : fragment = new NewsIndoFragment(); break;
                case 2 : fragment = new LocationIndoFragment(); break;

            }
            return fragment;
        }


        @Override
        public int getCount() {
            return 3;
        }
    }
}
