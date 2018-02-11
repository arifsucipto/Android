package mobile.app.qybae.demo.activity;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.txtsearchweb)
    EditText txtsearchweb;
    @BindView(R.id.btnsearchweb)
    Button btnsearchweb;


    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        bar = (ProgressBar) findViewById(R.id.determinateBar);
        // Force links and redirects to open in the WebView instead of in a browser
        //  webview.setWebViewClient(new WebViewClient());
        webview.setWebViewClient(new MyWebViewClient());
        webview.getSettings().setJavaScriptEnabled(true); //content java script biar kebuka
        if (savedInstanceState != null) {

            ((WebView) findViewById(R.id.webview)).restoreState(savedInstanceState);

        } else {
            webview.loadUrl("https://www.desaincasing.com/");

        }

    }


    @Override
    public void onBackPressed() {

        if (webview.canGoBack()) { //biar ga langsung balik ke aplikasi
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.btnsearchweb)
    public void onViewClicked() {
        String search = txtsearchweb.getText().toString();
        if (!search.isEmpty()) {
            webview.loadUrl("https://www.youtube.com/results?search_query=" + search);
        }

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            bar.setVisibility(View.GONE);
            webview.setVisibility(View.VISIBLE);
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            webview.setVisibility(View.GONE);
            bar.setVisibility(View.VISIBLE);
        }

        //
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return super.shouldOverrideUrlLoading(view, url);
//        }
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            //Your code to do
            bar.setVisibility(View.GONE);
//            webview.loadUrl("file:///android_asset/index.html");
            Toast.makeText(getApplicationContext(), "Your Internet Connection May not be active Or " + error, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        webview.saveState(outState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
