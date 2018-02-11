package mobile.app.qybae.demo.intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;

public class outImplisitActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_implisit);
        ButterKnife.bind(this);

        if (getIntent().getData() !=null){
            textView2.setText(getIntent().getData().toString());
        }
        else{
            textView2.setText("no data inputttt");
        }
    }
}
