package mobile.app.qybae.demo.Firebase;

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
import mobile.app.qybae.demo.fragment.AddStudent;
import mobile.app.qybae.demo.fragment.PlayFragment;
import mobile.app.qybae.demo.fragment.StudentsFragment;
import mobile.app.qybae.demo.fragment.UpcomingFragment;

public class MasterStudents extends AppCompatActivity {

    @BindView(R.id.VpStudentsFragment)
    ViewPager VpStudentsFragment;
    @BindView(R.id.TabsLayoutFragStudents)
    TabLayout TabsLayoutFragStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_students);
        ButterKnife.bind(this);

        TabsLayoutFragStudents.addTab(TabsLayoutFragStudents.newTab().setText("Students").setIcon(R.drawable.ic_menu_gallery));
        TabsLayoutFragStudents.addTab(TabsLayoutFragStudents.newTab().setText("Course").setIcon(R.drawable.ic_menu_slideshow));
        TabsLayoutFragStudents.addTab(TabsLayoutFragStudents.newTab().setText("Score").setIcon(R.drawable.ic_menu_camera));
        TabsLayoutFragStudents.addTab(TabsLayoutFragStudents.newTab().setText("Setting").setIcon(R.drawable.ic_menu_manage));
        PagerAdapter pagerAdapter = new TabAdapter(getSupportFragmentManager());


        VpStudentsFragment.setAdapter(pagerAdapter);
        TabsLayoutFragStudents.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                VpStudentsFragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new PlayFragment();
                    break;
                case 1:
                    fragment = new UpcomingFragment();
                    break;
                case 2:
                    fragment = new StudentsFragment();
                    break;
                case 3:
                    fragment = new AddStudent();
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
