package mobile.app.qybae.demo.parse;



import mobile.app.qybae.demo.indonesia.ResponseKabupaten;
import mobile.app.qybae.demo.indonesia.ResponseKecamatan;
import mobile.app.qybae.demo.indonesia.ResponseProvince;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Arisuu on 2/10/2018.
 */

public interface IIndonesiaInterface {
    @GET("allprovince.php")
    Call<ResponseProvince> getAllProvince();

    @GET("allKabupaten.php")
    Call<ResponseKabupaten> getAllKabupaten(@Query("provinsi")String provinsi);

    @GET("allKecamatan.php")
    Call<ResponseKecamatan> getAllKecamatan(@Query("kabupaten")String kabupaten);
}
