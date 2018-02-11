package mobile.app.qybae.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.app.qybae.demo.PojoStudents.ResponseStudents;
import mobile.app.qybae.demo.PojoStudents.StudentsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.AdapterStudents;
import mobile.app.qybae.demo.parse.APIStudent;
import mobile.app.qybae.demo.parse.CONSTANT;
import mobile.app.qybae.demo.parse.IStudentInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentsFragment extends Fragment {


    @BindView(R.id.progressbarstudents)
    ProgressBar progressbarstudents;
    @BindView(R.id.txtprogstudents)
    TextView txtprogstudents;
    @BindView(R.id.rvfragmentstudents)
    RecyclerView rvfragmentstudents;
    Unbinder unbinder;

    public StudentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_students, container, false);
        unbinder = ButterKnife.bind(this, view);

        rvfragmentstudents.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        IStudentInterface studentservice = APIStudent.getClient().create(IStudentInterface.class);

        Call<ResponseStudents> call = studentservice.getAllStudents();
        call.enqueue(new Callback<ResponseStudents>() {
            @Override
            public void onResponse(Call<ResponseStudents> call, Response<ResponseStudents> response) {
                List<StudentsItem> data = response.body().getStudents();
                AdapterStudents adapterStudents = new AdapterStudents(getActivity(),data);
                rvfragmentstudents.setAdapter(adapterStudents);
            }

            @Override
            public void onFailure(Call<ResponseStudents> call, Throwable t) {

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
