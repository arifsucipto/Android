package mobile.app.qybae.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;

public class WebHtmlActivity extends AppCompatActivity {

    @BindView(R.id.webhtmlview)
    WebView webhtmlview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_html);
        ButterKnife.bind(this);

        webhtmlview.setWebViewClient(new WebViewClient());
        webhtmlview.getSettings().setJavaScriptEnabled(true); //content java script biar kebuka
        webhtmlview.loadUrl("file:///android_asset/RsArifinAchmad.html");
    }
}
