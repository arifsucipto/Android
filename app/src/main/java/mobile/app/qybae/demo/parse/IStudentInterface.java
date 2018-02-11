package mobile.app.qybae.demo.parse;

import mobile.app.qybae.demo.PojoStudents.ResponseStudents;
import mobile.app.qybae.demo.PojoStudents.StudentsItem;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Arisuu on 1/20/2018.
 */

public interface IStudentInterface {

    @GET("readallstudents.php")
    Call<ResponseStudents> getAllStudents();

    @FormUrlEncoded
    @POST("createstudent.php")
    Call<StudentsItem> postStudent(@Field("nama") String nama,
                                   @Field("alamat") String alamat,
                                   @Field("Tanggal_Lahir") String Tanggal_Lahir,
                                   @Field("email") String email,
                                   @Field("phone") String phone,
                                   @Field("Umur") String Umur);

}
