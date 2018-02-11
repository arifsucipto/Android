package mobile.app.qybae.demo.drawer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;

public class DetailBuah extends AppCompatActivity {

    @BindView(R.id.imgbuah)
    ImageView imgbuah;
    @BindView(R.id.txtlistbuah)
    TextView txtlistbuah;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        ButterKnife.bind(this);
        Intent terimadata = getIntent();
        txtlistbuah.setText(terimadata.getStringExtra("nama"));
        imgbuah.setImageResource(terimadata.getIntExtra("gambar", 0));

        Uri lokasi = Uri.parse("android.resource://" + getPackageName() + "/" + terimadata.getIntExtra("sound",0));
        try {
            mediaPlayer.setDataSource(this, lokasi);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
