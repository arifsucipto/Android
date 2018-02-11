package mobile.app.qybae.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.Main2Activity;
import mobile.app.qybae.demo.R;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //handler untuk waktu splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SplashScreen.this, "toast spaslh screen sebelom move ke intent", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(SplashScreen.this, Main2Activity.class));

                //intent implisit dan explisit. untuk pindah activity bisa parsing data, atau akses kamera atau external lainnnya

                finish(); //destroy splash screen stelah tampil ke menu utama
            }
        }, 500);
    }
}
