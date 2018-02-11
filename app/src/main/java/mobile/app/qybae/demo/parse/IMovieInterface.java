package mobile.app.qybae.demo.parse;

import mobile.app.qybae.demo.Pojo.ResponseMovie;
import mobile.app.qybae.demo.Pojo.ResponseSearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by marif_s.i on 14/01/2018.
 */

public interface IMovieInterface {
    @GET("movie/upcoming")
    Call<ResponseMovie> getUpcomingMovie (@Query("api_key")String apikey,
                                          @Query("language")String language);

    @GET("movie/now_playing")
    Call<ResponseMovie> getNowPlaying (@Query("api_key")String apikey,
                                          @Query("language")String language);

    @GET("search/movie")
    Call<ResponseSearch> getSearchMovie (@Query("api_key")String apikey,
                                        @Query("language")String language,
                                        @Query("query")String search);

}
