package mobile.app.qybae.demo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.parse.CONSTANT;
import mobile.app.qybae.demo.webviewloading;

public class tampilData extends AppCompatActivity {

    @BindView(R.id.txtnama)
    TextView txtnama;
    @BindView(R.id.btnLuas)
    Button btnLuas;
    @BindView(R.id.btnwebview)
    Button btnwebview;
    @BindView(R.id.btnhtml)
    Button btnhtml;
    @BindView(R.id.btntoast)
    Button btntoast;
    @BindView(R.id.btnalert)
    Button btnalert;
    @BindView(R.id.btnkalkulator)
    Button btnkalkulator;

    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        ButterKnife.bind(this);

        SharedPreferences pref = getSharedPreferences(CONSTANT.REF_FILENAME,MODE_PRIVATE);
        String user = pref.getString("user","");

        if (user != ""){
            txtnama.setText("welcome " + user);
        }else {
            //ambil data parsing dari input data
            Intent terimaData = getIntent();

            txtnama.setText("welcome " + terimaData.getStringExtra("NAMA"));
        }


    }

    @OnClick({R.id.btnLuas, R.id.btnwebview, R.id.btnhtml, R.id.btntoast, R.id.btnalert, R.id.btnkalkulator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLuas:
                startActivity(new Intent(tampilData.this,LuasActivity.class));
                break;
            case R.id.btnwebview:
               // startActivity(new Intent(tampilData.this,webviewloading.class));
                startActivity(new Intent(tampilData.this,WebViewActivity.class));
                break;
            case R.id.btnhtml:
               startActivity(new Intent(tampilData.this,WebHtmlActivity.class));
                break;
            case R.id.btntoast:
                startActivity(new Intent(tampilData.this,CustomToastActivity.class));
                break;
            case R.id.btnalert:
                startActivity(new Intent(tampilData.this,CustomAlertActivity.class));
                break;
            case R.id.btnkalkulator:
                startActivity(new Intent(tampilData.this,KalulatorActivity.class));
                break;
        }
    }
}
