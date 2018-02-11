package mobile.app.qybae.demo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class CustomAlertActivity extends AppCompatActivity {

    @BindView(R.id.btncustomalert)
    Button btncustomalert;
    @BindView(R.id.txtnamahasil)
    TextView txtnamahasil;
    @BindView(R.id.txtpasswordhasil)
    TextView txtpasswordhasil;
    //remark -  pake butterknife di layout inflatter bikin force close
//    @BindView(R.id.txtcustomalert)
//    TextView txtcustomalert;
//    @BindView(R.id.txtalertname)
//    EditText txtalertname;
//    @BindView(R.id.txtalertpassword)
//    EditText txtalertpassword;
//    @BindView(R.id.btnCancelAlert)
//    Button btnCancelAlert;
//    @BindView(R.id.btnSaveAlert)
//    Button btnSaveAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btncustomalert)
    public void onViewClicked() {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_alert_layout, null);
        //generate butterknife dari custom alert layour.. bukan dr activity
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlertActivity.this);
        builder.setCancelable(false);
        builder.setView(view);

        final EditText txtalertusername = (EditText) view.findViewById(R.id.txtalertname);
        final EditText txtalertpassword = (EditText) view.findViewById(R.id.txtalertpassword);
        final Button btnsavealert = (Button) view.findViewById(R.id.btnSaveAlert);
        final Button btnCancel = (Button) view.findViewById(R.id.btnCancelAlert);
         builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
           }
       });

        btnsavealert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtalertusername.getText().toString();
                String password = txtalertpassword.getText().toString();

                if (username.isEmpty()) {
                    txtalertusername.setError("harus di iisi");
                } else if (password.isEmpty()) {
                    txtalertpassword.setError("haris di isi pass");
                } else if (password.length() < 6) {
                    txtalertpassword.setError("haris lebih atau sama dengan 6");
                } else {
                    Toast.makeText(CustomAlertActivity.this, username + password, Toast.LENGTH_SHORT).show();
                    txtnamahasil.setText(username);
                    txtpasswordhasil.setText(password);


                 /*   Intent KirimData = new Intent(CustomAlertActivity.this, CustomToastActivity.class);
                    KirimData.putExtra("NAMA", username);
                    KirimData.putExtra("PASS", password);*/
                }
            }
        });

        builder.show();


    }


}
