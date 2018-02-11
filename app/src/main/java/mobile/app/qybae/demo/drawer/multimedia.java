package mobile.app.qybae.demo.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.helper.MyFunction;

public class multimedia extends MyFunction {

    @BindView(R.id.btnradio)
    Button btnradio;
    @BindView(R.id.btnvideo)
    Button btnvideo;
    @BindView(R.id.btnvideooff)
    Button btnvideooff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnradio)
    public void onBtnradioClicked() {
        aksesAktifitas(Radio.class);
    }

    @OnClick(R.id.btnvideo)
    public void onBtnvideoClicked() {
        aksesAktifitas(VideoStreaming.class);
    }

    @OnClick(R.id.btnvideooff)
    public void onBtnvideooffClicked() {
        aksesAktifitas(RadioAnimation.class);
    }
}
