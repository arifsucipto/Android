package mobile.app.qybae.demo.drawer;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.helper.MyFunction;
import mobile.app.qybae.demo.helper.dataBuah;

public class SpinnerACtivity extends MyFunction {

    @BindView(R.id.imgspin)
    ImageView imgspin;
    @BindView(R.id.txtspin)
    TextView txtspin;
    @BindView(R.id.spinbuah)
    Spinner spinbuah;

    String[] buah;
    TypedArray gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_activity);
        ButterKnife.bind(this);
        buah = getResources().getStringArray(R.array.buah);
        gambar = getResources().obtainTypedArray(R.array.gambar);
        ArrayAdapter adapter = new ArrayAdapter(con, android.R.layout.simple_spinner_item, buah);
        spinbuah.setAdapter(adapter);

        spinbuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtspin.setText(buah[i]);
                imgspin.setImageResource(gambar.getResourceId(i,-1));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
