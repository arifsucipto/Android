package mobile.app.qybae.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.Firebase.FirebaseActivity;
import mobile.app.qybae.demo.activity.SplashScreen;
import mobile.app.qybae.demo.drawer.ImageGallery;
import mobile.app.qybae.demo.drawer.ListBuahActivity;
import mobile.app.qybae.demo.drawer.SpinnerACtivity;
import mobile.app.qybae.demo.drawer.multimedia;
import mobile.app.qybae.demo.fragment.MovieFragment;
import mobile.app.qybae.demo.fragment.SearchMovieActivity;
import mobile.app.qybae.demo.helper.MyFunction;
import mobile.app.qybae.demo.parse.RecycleView;

//extend myfunction untuk akses method
public class Main2Activity extends MyFunction
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.txtmaincontent2)
    TextView txtmaincontent;
    public static final String REF_FILENAME = "mobile.app.qybae.demo.activity.login";
    @BindView(R.id.btnlogout2)
    Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getSharedPreferences(REF_FILENAME, MODE_PRIVATE);
        String user = pref.getString("user", "");

        if (user == "") {
            txtmaincontent.setText("Please Login");
        } else {
            txtmaincontent.setText("Welcome again" + user);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            // Handle the camera action
            toastKelas("gallery nya nih");
            aksesAktifitas(ImageGallery.class);
        } else if (id == R.id.nav_spinner) {
            toastKelas("spinner nya nih");
            aksesAktifitas(SpinnerACtivity.class);

        } else if (id == R.id.nav_list) {
            toastKelas("list nya nih");
            aksesAktifitas(ListBuahActivity.class);

        } else if (id == R.id.nav_multimedia) {
            //canti start activty pake myfunction
            aksesAktifitas(multimedia.class);

        } else if (id == R.id.nav_share) {
            // startActivity(new Intent(Main2Activity.this, MenuActivity.class));
            aksesAktifitas(MenuActivity.class);

        } else if (id == R.id.nav_send) {
            String movie = "upcoming";
            Intent kirimdata = new Intent(Main2Activity.this, RecycleView.class);
            kirimdata.putExtra("movie", movie);
            startActivity(kirimdata);

        } else if (id == R.id.nav_movie) {
            String movie = "play";
            Intent kirimdata = new Intent(Main2Activity.this, RecycleView.class);
            kirimdata.putExtra("movie", movie);
            startActivity(kirimdata);

        } else if (id == R.id.nav_fragment) {

            aksesAktifitas(MovieFragment.class);

        } else if (id == R.id.nav_searchmovie) {

            aksesAktifitas(SearchMovieActivity.class);

        }else if (id == R.id.nav_register) {

            aksesAktifitas(MainActivity.class);

        }else if (id == R.id.nav_firebase) {

            aksesAktifitas(FirebaseActivity.class);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.btnlogout2)
    public void onViewClicked() {
        SharedPreferences removepref = getSharedPreferences(REF_FILENAME, MODE_PRIVATE);
        removepref.edit().remove("user").commit();
        aksesAktifitas(SplashScreen.class);

    }
}
