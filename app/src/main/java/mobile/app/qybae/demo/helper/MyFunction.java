package mobile.app.qybae.demo.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mobile.app.qybae.demo.R;

public class MyFunction extends AppCompatActivity {


    public Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_my_function);
        //dihapus karena untuk function


        //diinisialisasi con itu my function
        con = MyFunction.this;


    }

    //metod kelas
    public void aksesAktifitas(Class tujuan) {
        startActivity(new Intent(con, tujuan));
    }

    //method toast
    public void toastKelas(String pesan) {
        Toast.makeText(con, pesan, Toast.LENGTH_SHORT).show();
    }
}
