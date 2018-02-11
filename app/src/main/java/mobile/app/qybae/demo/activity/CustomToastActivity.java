package mobile.app.qybae.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class CustomToastActivity extends AppCompatActivity {

    @BindView(R.id.btntoastcustom)
    Button btntoastcustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btntoastcustom)
    public void onViewClicked() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast_layout,null);
        //gunakan view inflater untuk ambil view activity yg lain
        TextView tvToast = (TextView) view.findViewById(R.id.txtcustomtoast);
        tvToast.setText("isi dari custom toast dari layout custom");

        Toast toastcustom = new Toast(CustomToastActivity.this);
        toastcustom.setView(view);
        toastcustom.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0,0);
        toastcustom.setDuration(Toast.LENGTH_LONG);
        toastcustom.show();

        //Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();
    }
}
