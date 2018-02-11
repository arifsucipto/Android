package mobile.app.qybae.demo.parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.Pojo.ResponseMovie;
import mobile.app.qybae.demo.Pojo.ResultsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.AdapterMovie;
import mobile.app.qybae.demo.adapter.AdapterRecycleView;
import mobile.app.qybae.demo.helper.MyFunction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleView extends MyFunction {

    @BindView(R.id.rv_recview)
    RecyclerView rvRecview;
    String intentmovie;
private int i = 0;
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Intent terimadata = getIntent();
        intentmovie = terimadata.getStringExtra("movie");
        ButterKnife.bind(this);
        //https://developer.android.com/reference/android/support/v7/widget/GridLayoutManager.html
        rvRecview.setLayoutManager(new GridLayoutManager(con, 2));

        //ganti adapter pake yg json
      //  AdapterRecycleView adapterRecycleView = new AdapterRecycleView(con);
       // rvRecview.setAdapter(adapterRecycleView);
        //get movie dari database dbmovie
        if (intentmovie.equals("upcoming")){
            getMovie();
        }
        else if (intentmovie.equals("play")){
            getPlay();

        }
    }

    private void getPlay() {
        IMovieInterface movieservice = ApiClient.getClient().create(IMovieInterface.class);

        Call<ResponseMovie> call = movieservice.getNowPlaying(CONSTANT.APIKEY,CONSTANT.LANGUAGE);

        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                try
                {
                    List<ResultsItem> data = response.body().getResults();
                    AdapterMovie adapterMovie = new AdapterMovie(con,data);
                    rvRecview.setAdapter(adapterMovie);
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
                    AdapterMovie adapterMovie = new AdapterMovie(con,data);
                    rvRecview.setAdapter(adapterMovie);
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
