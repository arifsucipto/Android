package mobile.app.qybae.demo.fragment;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.app.qybae.demo.Pojo.ResponseMovie;
import mobile.app.qybae.demo.Pojo.ResultsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.AdapterMovie;
import mobile.app.qybae.demo.parse.ApiClient;
import mobile.app.qybae.demo.parse.CONSTANT;
import mobile.app.qybae.demo.parse.IMovieInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {


    private static final String TAG = "" ;
    @BindView(R.id.rvfragmentupcoming)
    RecyclerView rvfragmentupcoming;
    Unbinder unbinder;

    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        unbinder = ButterKnife.bind(this, view);
       if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) //potrait
        {
            rvfragmentupcoming.setLayoutManager(new GridLayoutManager(getActivity(), 6));
        }else
       {
           rvfragmentupcoming.setLayoutManager(new GridLayoutManager(getActivity(), 3));
       }

        getMovie();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void getMovie() {
        IMovieInterface movieservice = ApiClient.getClient().create(IMovieInterface.class);

        Call<ResponseMovie> call = movieservice.getUpcomingMovie(CONSTANT.APIKEY,CONSTANT.LANGUAGE);

        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                try
                {
                    List<ResultsItem> data = response.body().getResults();
                   /* for ( i = 0; i < data.size();i++)
                    {
                        Log.d(TAG, "onResponse: " + data.get(i).getTitle());
                    }*/
                    AdapterMovie adapterMovie = new AdapterMovie(getActivity(),data);
                    rvfragmentupcoming.setAdapter(adapterMovie);
                }
                catch (IllegalStateException e) {
                    Log.e(TAG, "onerror: " + e.toString());
                }

            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Log.d(TAG, "onFailure: gagal ambil data" + t.toString());
            }
        });
    }
}
