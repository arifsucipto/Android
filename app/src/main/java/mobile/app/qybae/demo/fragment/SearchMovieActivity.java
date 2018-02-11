package mobile.app.qybae.demo.fragment;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.Pojo.ResponseMovie;
import mobile.app.qybae.demo.Pojo.ResponseSearch;
import mobile.app.qybae.demo.Pojo.ResultsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.AdapterMovie;
import mobile.app.qybae.demo.adapter.AdapterMovieSearch;
import mobile.app.qybae.demo.helper.MyFunction;
import mobile.app.qybae.demo.parse.ApiClient;
import mobile.app.qybae.demo.parse.CONSTANT;
import mobile.app.qybae.demo.parse.IMovieInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMovieActivity extends MyFunction {

    @BindView(R.id.pdFragmentSearch)
    ProgressBar pdFragmentSearch;
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.recycler_movie_search)
    RecyclerView recyclerMovieSearch;
    String querysearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        ButterKnife.bind(this);
        recyclerMovieSearch.setLayoutManager(new GridLayoutManager(con, 2));

        View.OnFocusChangeListener ofcListener = new MyFocusChangeListener();
        edtSearch.setOnFocusChangeListener(ofcListener);

        //savestate pas rotate pake android manifest
      /*  if(savedInstanceState==null)
        {

        }
        else
        {
            querysearch = savedInstanceState.getString("query");
            getlandscape(querysearch);
        }*/



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(con, "landscape" + newConfig.orientation, Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(con, "potrait" + newConfig.orientation, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnSearch)
    public void onViewClicked() {

        String query = edtSearch.getText().toString();
        if (query.isEmpty()){
            edtSearch.setError("Harap isi");
        }
        else
        {
            IMovieInterface movieservice = ApiClient.getClient().create(IMovieInterface.class);

            Call<ResponseSearch> call = movieservice.getSearchMovie(CONSTANT.APIKEY,CONSTANT.LANGUAGE,query);
            call.enqueue(new Callback<ResponseSearch>() {
                @Override
                public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                    List<ResultsItem> data = response.body().getResults();

                    if (data.size() > 0){
                        AdapterMovieSearch adapterMovie = new AdapterMovieSearch(con,data);
                        recyclerMovieSearch.setAdapter(adapterMovie);
                    }
                    else
                    {
                        toastKelas("movie nya kosong bos");
                    }


                }

                @Override
                public void onFailure(Call<ResponseSearch> call, Throwable t) {

                }
            });

            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(con.INPUT_METHOD_SERVICE);

            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }

    //pake android manifest
  /*  @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String querybox = edtSearch.getText().toString();
        outState.putString("query", querybox);

    }*/

    public void getlandscape(String query) {
        IMovieInterface movieservice = ApiClient.getClient().create(IMovieInterface.class);

        Call<ResponseSearch> call = movieservice.getSearchMovie(CONSTANT.APIKEY,CONSTANT.LANGUAGE,query);
        call.enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                List<ResultsItem> data = response.body().getResults();

                if (data.size() > 0){
                    AdapterMovieSearch adapterMovie = new AdapterMovieSearch(con,data);
                    recyclerMovieSearch.setAdapter(adapterMovie);

                }
                else
                {
                    toastKelas("movie nya kosong bos");
                }


            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {

            }
        });
    }

    private class MyFocusChangeListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View view, boolean b) {
            if(view.getId() == R.id.edtSearch && !b) {

                InputMethodManager imm =  (InputMethodManager) getSystemService(con.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }
        }
    }
}
