package mobile.app.qybae.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mobile.app.qybae.demo.PojoStudents.ResponseStudents;
import mobile.app.qybae.demo.PojoStudents.StudentsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.parse.APIStudent;
import mobile.app.qybae.demo.parse.IStudentInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudent extends Fragment {


    @BindView(R.id.namamurid)
    EditText namamurid;
    @BindView(R.id.ttlmurid)
    EditText ttlmurid;
    @BindView(R.id.emailmurid)
    EditText emailmurid;
    @BindView(R.id.txtalamatmurid)
    EditText txtalamatmurid;
    @BindView(R.id.txtphonemurid)
    EditText txtphonemurid;
    @BindView(R.id.txtumurmurid)
    EditText txtumurmurid;
    @BindView(R.id.btnregistermurid)
    Button btnregistermurid;
    Unbinder unbinder;

    public AddStudent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnregistermurid)
    public void onViewClicked() {
           String nama,alamat,umur,phone,email,ttl;
           nama = namamurid.getText().toString();
        alamat = txtalamatmurid.getText().toString();
        umur = txtumurmurid.getText().toString();
        email = emailmurid.getText().toString();
        phone = txtphonemurid.getText().toString();
        ttl = ttlmurid.getText().toString();

        if(nama.isEmpty() || alamat.isEmpty() || umur.isEmpty() || email.isEmpty() || phone.isEmpty() || ttl.isEmpty()){
            Toast.makeText(getContext(), "Please isi semua", Toast.LENGTH_SHORT).show();
        }else {
            IStudentInterface studentservice = APIStudent.getClient().create(IStudentInterface.class);

            Call<StudentsItem> call = studentservice.postStudent(nama,alamat,ttl,email,phone,umur);
            call.enqueue(new Callback<StudentsItem>() {
                @Override
                public void onResponse(Call<StudentsItem> call, Response<StudentsItem> response) {
                    Toast.makeText(getContext(), "Sukses", Toast.LENGTH_SHORT).show();

                    namamurid.setText("");
                    txtalamatmurid.setText("");
                    txtumurmurid.setText("");
                    emailmurid.setText("");
                    ttlmurid.setText("");
                    txtphonemurid.setText("");

                }

                @Override
                public void onFailure(Call<StudentsItem> call, Throwable t) {
                    Toast.makeText(getContext(), "Gagal Insert", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
