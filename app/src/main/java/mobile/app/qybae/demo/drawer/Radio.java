package mobile.app.qybae.demo.drawer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.helper.MyFunction;

public class Radio extends MyFunction {

    @BindView(R.id.proggressbar)
    ProgressBar proggressbar;
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnStop)
    Button btnStop;


    MediaPlayer mediaPlayer;
    //    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.idRadio)
    LinearLayout idRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        ButterKnife.bind(this);
        proggressbar.setIndeterminate(true);
        btnStop.setVisibility(View.GONE);
        proggressbar.setVisibility(View.GONE);
        mediaPlayer = new MediaPlayer();

        // setSupportActionBar(toolbar); //setting toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }


    }

    @OnClick(R.id.btnPlay)
    public void onBtnPlayClicked() {
        try {

            mediaPlayer.setDataSource("http://103.16.198.36:9160/stream");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {  //alt enter alt enter aja ini

                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
            toastKelas("ga ada " + e.toString());
        }

        btnStop.setVisibility(View.VISIBLE);
        proggressbar.setVisibility(View.VISIBLE);
        btnPlay.setVisibility(View.GONE);


    }

    @OnClick(R.id.btnStop)
    public void onBtnStopClicked() {
        stop();


    }

    private void stop() {
        try {

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                proggressbar.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.GONE);
            } else {
                proggressbar.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.GONE);
            }

        } catch (IllegalStateException e) {
            toastKelas("error" + e.toString());
        }
    }

    @Override
    public void onBackPressed() {

        stop();
        super.onBackPressed();
    }

//    @OnClick(R.id.toolbar)
//    public void onViewClicked() {
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                stop();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
