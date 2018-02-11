package mobile.app.qybae.demo.Firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.PojoStudents.StudentsItem;
import mobile.app.qybae.demo.R;

public class DetailStudentActivity extends AppCompatActivity {

    @BindView(R.id.namamuriddetail)
    EditText namamuriddetail;
    @BindView(R.id.ttlmuriddetail)
    EditText ttlmuriddetail;
    @BindView(R.id.emailmuriddetail)
    EditText emailmuriddetail;
    @BindView(R.id.txtalamatmuriddetail)
    EditText txtalamatmuriddetail;
    @BindView(R.id.txtphonemuriddetail)
    EditText txtphonemuriddetail;
    @BindView(R.id.txtumurmuriddetail)
    EditText txtumurmuriddetail;
    @BindView(R.id.btnupdatemurid)
    Button btnupdatemurid;
    @BindView(R.id.btnsimpanmurid)
    Button btnsimpanmurid;
    @BindView(R.id.btndelmurid)
    Button btndelmurid;

    String idmurid = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_student);
        ButterKnife.bind(this);

        StudentsItem studentsItem = getIntent().getExtras().getParcelable("murid");

        namamuriddetail.setText(studentsItem.getNama());
        txtalamatmuriddetail.setText(studentsItem.getAlamat());
        txtphonemuriddetail.setText(studentsItem.getPhone());
        emailmuriddetail.setText(studentsItem.getEmail());
        txtumurmuriddetail.setText(studentsItem.getUmur());
        ttlmuriddetail.setText(studentsItem.getTanggalLahir());
        idmurid = studentsItem.getId().toString();



    }

    @OnClick(R.id.btnupdatemurid)
    public void onBtnupdatemuridClicked() {
        btnsimpanmurid.setVisibility(View.VISIBLE);
        btnupdatemurid.setVisibility(View.GONE);
        btndelmurid.setVisibility(View.GONE);

        namamuriddetail.setEnabled(true);
        txtalamatmuriddetail.setEnabled(true);
        txtphonemuriddetail.setEnabled(true);
        emailmuriddetail.setEnabled(true);
        txtumurmuriddetail.setEnabled(true);
        ttlmuriddetail.setEnabled(true);
    }

    @OnClick(R.id.btnsimpanmurid)
    public void onBtnsimpanmuridClicked() {
        btnupdatemurid.setVisibility(View.VISIBLE);
        btnsimpanmurid.setVisibility(View.GONE);
        btndelmurid.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btndelmurid)
    public void onBtndelmuridClicked() {
    }
}
