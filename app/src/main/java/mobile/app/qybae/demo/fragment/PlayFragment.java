package mobile.app.qybae.demo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
public class PlayFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private static final String TAG = "";
    @BindView(R.id.rvfragmentplay)
    RecyclerView rvfragmentplay;
    Unbinder unbinder;
    @BindView(R.id.progressbarmovie)
    ProgressBar progressbarmovie;
    @BindView(R.id.txtprogmovie)
    TextView txtprogmovie;



    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        unbinder = ButterKnife.bind(this, view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        rvfragmentplay.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        progressbarmovie.setVisibility(View.VISIBLE);
        txtprogmovie.setVisibility(View.VISIBLE);
        getPlay();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getContext(), "sukses reload", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getPlay() {
        IMovieInterface movieservice = ApiClient.getClient().create(IMovieInterface.class);

        Call<ResponseMovie> call = movieservice.getNowPlaying(CONSTANT.APIKEY, CONSTANT.LANGUAGE);

        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                try {
                    List<ResultsItem> data = response.body().getResults();
                    AdapterMovie adapterMovie = new AdapterMovie(getActivity(), data);
                    rvfragmentplay.setAdapter(adapterMovie);

                    progressbarmovie.setVisibility(View.GONE);
                    txtprogmovie.setVisibility(View.GONE);
                } catch (IllegalStateException e) {
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
