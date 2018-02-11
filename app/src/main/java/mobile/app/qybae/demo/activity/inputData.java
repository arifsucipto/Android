package mobile.app.qybae.demo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class inputData extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.autotext)
    AutoCompleteTextView autotext;

    public static final String REF_FILENAME = "mobile.app.qybae.demo.activity.login";
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        ButterKnife.bind(this);
        String[] auto = {"evi", "arif", "cahya", "delta", "ibu", "array", "deni"};

        // layout untuk dropdwon nya bisa di ganti, buat layout di xml, textview, atur. kemudian hapus liear layoutnya. cuman  textview doang yg di ambil
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, auto);
        autotext.setThreshold(1);
        autotext.setAdapter(adapter);

    }


    @OnClick(R.id.button)
    public void onButtonClicked() {
        String nama = editText.getText().toString();

        if (nama.isEmpty()) {
            Toast.makeText(this, "kosong", Toast.LENGTH_SHORT).show();
            editText.setError("data wajib diisi");  //textview menampilkan pesan error
        } else {
            SharedPreferences.Editor editor = getSharedPreferences(REF_FILENAME, MODE_PRIVATE).edit();
            editor.putString("user", nama);
            editor.commit();
            Toast.makeText(this, nama, Toast.LENGTH_SHORT).show();
            Intent kirimData = new Intent(inputData.this, tampilData.class);
            kirimData.putExtra("NAMA", nama);
            startActivity(kirimData); // move ke activity yg lain
            finish();
        }
    }

    @OnClick(R.id.button2)
    public void onButton2Clicked() {

    }
}
