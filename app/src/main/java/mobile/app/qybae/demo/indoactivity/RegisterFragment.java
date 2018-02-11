package mobile.app.qybae.demo.indoactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.indonesia.KabupatenItem;
import mobile.app.qybae.demo.indonesia.KecamatanItem;
import mobile.app.qybae.demo.indonesia.ProvincesItem;
import mobile.app.qybae.demo.indonesia.ResponseKabupaten;
import mobile.app.qybae.demo.indonesia.ResponseKecamatan;
import mobile.app.qybae.demo.indonesia.ResponseProvince;
import mobile.app.qybae.demo.parse.APIStudent;
import mobile.app.qybae.demo.parse.IIndonesiaInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    @BindView(R.id.spinprovinsi)
    Spinner spinprovinsi;
    Unbinder unbinder;
    @BindView(R.id.spinkabupaten)
    Spinner spinkabupaten;
    @BindView(R.id.spinkecamatan)
    Spinner spinkecamatan;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);

        IIndonesiaInterface indonesiaservice = APIStudent.getClient().create(IIndonesiaInterface.class);
        Call<ResponseProvince> call = indonesiaservice.getAllProvince();

        call.enqueue(new Callback<ResponseProvince>() {

            @Override
            public void onResponse(Call<ResponseProvince> call, Response<ResponseProvince> response) {
                try {
                    List<ProvincesItem> data = response.body().getProvinces();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < data.size(); i++) {
                        listSpinner.add(data.get(i).getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinprovinsi.setAdapter(adapter);

                } catch (IllegalStateException e) {
                    Log.e(TAG, "onerror: " + e.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseProvince> call, Throwable t) {

            }
        });


        spinprovinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinkecamatan.setAdapter(null);

                String provinsi = adapterView.getItemAtPosition(i).toString();
                IIndonesiaInterface indonesiaservice = APIStudent.getClient().create(IIndonesiaInterface.class);
                Call<ResponseKabupaten> call = indonesiaservice.getAllKabupaten(provinsi);

                call.enqueue(new Callback<ResponseKabupaten>() {

                    @Override
                    public void onResponse(Call<ResponseKabupaten> call, Response<ResponseKabupaten> response) {
                        try {
                            List<KabupatenItem> data = response.body().getKabupaten();
                            List<String> listSpinner = new ArrayList<String>();
                            for (int i = 0; i < data.size(); i++) {
                                listSpinner.add(data.get(i).getName());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter(getContext(),
                                    android.R.layout.simple_spinner_item, listSpinner);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinkabupaten.setAdapter(adapter);

                        } catch (IllegalStateException e) {
                            Log.e(TAG, "onerror: " + e.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseKabupaten> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinkabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String kabupaten = adapterView.getItemAtPosition(i).toString();
                IIndonesiaInterface indonesiaservice = APIStudent.getClient().create(IIndonesiaInterface.class);
                Call<ResponseKecamatan> call = indonesiaservice.getAllKecamatan(kabupaten);

                call.enqueue(new Callback<ResponseKecamatan>() {

                    @Override
                    public void onResponse(Call<ResponseKecamatan> call, Response<ResponseKecamatan> response) {
                        try {
                            List<KecamatanItem> data = response.body().getKecamatan();
                            List<String> listSpinner = new ArrayList<String>();
                            for (int i = 0; i < data.size(); i++) {
                                listSpinner.add(data.get(i).getName());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter(getContext(),
                                    android.R.layout.simple_spinner_item, listSpinner);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinkecamatan.setAdapter(adapter);

                        } catch (IllegalStateException e) {
                            Log.e(TAG, "onerror: " + e.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseKecamatan> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
