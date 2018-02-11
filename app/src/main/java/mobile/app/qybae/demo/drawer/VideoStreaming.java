package mobile.app.qybae.demo.drawer;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;

public class VideoStreaming extends AppCompatActivity {

    @BindView(R.id.videoview)
    VideoView videoview;


    //manggil video mediacontroller dan soundpool
    MediaController media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        ButterKnife.bind(this);

        media = new MediaController(this);
        media.setAnchorView(videoview);

        videoview.setMediaController(media);

       // videoview.setVideoURI(Uri.parse("http://idn.id/semarang/tes/tatacara.mp4"));  //kalo mau streaming modelnya kayak gini
       videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.adyan)); // kalo mau offline
        videoview.requestFocus();
        videoview.start();

    }
}
