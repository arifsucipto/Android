package mobile.app.qybae.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class KalulatorActivity extends AppCompatActivity {

    @BindView(R.id.et_bilangan_a)
    EditText etBilanganA;
    @BindView(R.id.btn_tambah)
    Button btnTambah;
    @BindView(R.id.btn_kurang)
    Button btnKurang;
    @BindView(R.id.btn_kali)
    Button btnKali;
    @BindView(R.id.btn_bagi)
    Button btnBagi;
    @BindView(R.id.tv_operator)
    TextView tvOperator;
    @BindView(R.id.et_bilangan_b)
    EditText etBilanganB;
    @BindView(R.id.sama_dengan)
    TextView samaDengan;
    @BindView(R.id.tv_hasil)
    TextView tvHasil;
    @BindView(R.id.btnhitungcalc)
    Button btnhitungcalc;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    String operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalulator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_tambah, R.id.btn_kurang, R.id.btn_kali, R.id.btn_bagi, R.id.btnhitungcalc})
    public void onViewClicked(View view) {
        String A = etBilanganA.getText().toString();
        String B = etBilanganB.getText().toString();
        switch (view.getId()) {
            case R.id.btn_tambah:
                operator = "+";
                tvOperator.setText(operator);
                break;
            case R.id.btn_kurang:
                operator = "-";
                tvOperator.setText(operator);
                break;
            case R.id.btn_kali:
                operator = "*";
                tvOperator.setText(operator);
                break;
            case R.id.btn_bagi:
                operator = ":";
                tvOperator.setText(operator);
                break;
            case R.id.btnhitungcalc:
                if (A.isEmpty()){
                    etBilanganA.setError("isi A dong");
                }
                else if (B.isEmpty()){
                    etBilanganB.setError("isi B dong");
                }
                else
                {
                    if (operator.isEmpty())
                    {
                        Toast.makeText(this, "Pilih operator", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    float bilA = Float.parseFloat(A);
                    float bilB = Float.parseFloat(B);
                    float hasil = 0;
                    switch (operator){
                        case "+" :
                            hasil = bilA + bilB;
                            break;
                        case "-" :
                            hasil = bilA - bilB;
                            break;
                        case "*" :
                            hasil = bilA * bilB;
                            break;
                        case ":" :
                            hasil = bilA / bilB;
                            break;

                    }
                    String hasilcalc = new DecimalFormat("#.########").format(hasil);
                    tvHasil.setText(hasilcalc);
                }

                break;
        }
    }
}
