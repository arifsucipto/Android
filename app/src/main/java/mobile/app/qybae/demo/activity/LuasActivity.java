package mobile.app.qybae.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class LuasActivity extends AppCompatActivity {

    @BindView(R.id.txtPanjang)
    EditText txtPanjang;
    @BindView(R.id.txtLebar)
    EditText txtLebar;
    @BindView(R.id.btnhitung)
    Button btnhitung;
    @BindView(R.id.txtHasil)
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnhitung)
    public void onViewClicked() {
        String panjang = txtPanjang.getText().toString();
        String lebar = txtLebar.getText().toString();

        if (panjang.isEmpty()) {
            txtPanjang.setError("panjang harus diisi");
        }
        else if (lebar.isEmpty()) {
            txtLebar.setError("lebar harus diisi");
        } else {
            Double p = Double.parseDouble(panjang);
            Double l = Double.parseDouble(lebar);
            Double luas;
            luas = p * l;
            txtHasil.setText("luasnya :" + luas);
        }
    }
}
