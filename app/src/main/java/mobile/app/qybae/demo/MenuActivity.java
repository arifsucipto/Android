package mobile.app.qybae.demo;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.activity.CustomToastActivity;
import mobile.app.qybae.demo.activity.WebViewActivity;
import mobile.app.qybae.demo.activity.inputData;
import mobile.app.qybae.demo.activity.tampilData;
import mobile.app.qybae.demo.intent.fragmentActivity;
import mobile.app.qybae.demo.intent.implisitActivity;
import mobile.app.qybae.demo.parse.CONSTANT;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.sport)  //butterknife khusus sport
    LinearLayout sport;
    private String TAG = "";
    LinearLayout music;
    LinearLayout movie;
    LinearLayout news;
    LinearLayout travel;
    LinearLayout learn;
    //LinearLayout sport;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ButterKnife.bind(this);
        initview();

        //cek di log cat

        Log.d(TAG, "onCreate: tes log D");//debug
        Log.e(TAG, "onCreate: ini log e"); //error
        Log.i(TAG, "onCreate: ini log i"); //info
        Log.w(TAG, "onCreate: ini log w"); //warn
        //logcat

      //  Toast.makeText(this, "method create", Toast.LENGTH_SHORT).show();

        musictoast(); //toast biasa
        moviealert(); //alert hanya close / ok
        learntoast(); //alert hanya show
        // traveltoast();  ganti pake method click dari xml menu
        //sporttoast(); //alert yes no  ganti pake metode butterknife
        newstoast(); // alert yes no cancel

        SharedPreferences pref = getSharedPreferences(CONSTANT.REF_FILENAME,MODE_PRIVATE);
        user = pref.getString("user","");


    }

    private void musictoast() {
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampilkan toast
                Toast.makeText(MenuActivity.this, "pas di pencet music toast", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MenuActivity.this,implisitActivity.class );
                startActivity(intent);
            }
        });
    }

    private void moviealert() {
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampilkan toast
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("judul alert movie");
                builder.setMessage("isi pesan movie");
                builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });
    }

    private void learntoast() {
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampilkan toast
                // Toast.makeText(MenuActivity.this, "pas di pencet learn toast", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("judul alert learn");
                builder.setMessage("isi pesan learn");
                builder.show();

            }
        });
    }
//sporttoast() diubah menjadi didalam butterknife
    /*
    private void sporttoast() {
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampilkan toast
                // Toast.makeText(MenuActivity.this, "pas di pencet sport toast", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("judul alert sport");
                builder.setMessage("yakin yes no?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "yes yes yes yes", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "no no no no", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
*/

    /* remark karena berubah pake click dari menu xml nya pake atribut onclick
     private void traveltoast() {
         travel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //menampilkan toast
                 Toast.makeText(MenuActivity.this, "pas di pencet travel toast", Toast.LENGTH_SHORT).show();
             }
         });
     }*/
    private void newstoast() {
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampilkan toast
                //Toast.makeText(MenuActivity.this, "pas di pencet news toast", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("judul alert news");
                builder.setMessage("yakin yes no cancel?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "yes yes yes yes", Toast.LENGTH_SHORT).show();

                        moveTaskToBack(true);
                        // System.exit(0); bisa pake move task to back atay system exit
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "no no no no", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MenuActivity.this, "cel cel cel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });
    }

    private void initview() {
        music = (LinearLayout) findViewById(R.id.music);
        movie = (LinearLayout) findViewById(R.id.movie);
        news = (LinearLayout) findViewById(R.id.news);
        travel = (LinearLayout) findViewById(R.id.travel);
        learn = (LinearLayout) findViewById(R.id.learn);
        //sport = (LinearLayout) findViewById(R.id.sport); inisialisasi sport menggunakan butterknife untuk generate nya

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "method start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Toast.makeText(this, "method resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Toast.makeText(this, "method pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Toast.makeText(this, "method destroy", Toast.LENGTH_SHORT).show();
    }

    public void travelclick(View view) {
        Toast.makeText(MenuActivity.this, "travel click dr menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MenuActivity.this, fragmentActivity.class);
        startActivity(intent);

    }

    //menggunakan butterknife untuk on click nya
    @OnClick(R.id.sport)
    public void onViewClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setTitle("sport pindah activity ke input data");
        builder.setMessage("yakin pindah ke input data yes no?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
if (user == ""){
    startActivity(new Intent(MenuActivity.this, inputData.class)); // move ke activity yg lain
    Toast.makeText(MenuActivity.this, "yes yes yes yes", Toast.LENGTH_SHORT).show();
}
else
{
    startActivity(new Intent(MenuActivity.this, tampilData.class)); // move ke activity yg lain
}

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MenuActivity.this, "no no no no", Toast.LENGTH_SHORT).show();
                
            }
        });
        builder.show();


    }

    //menampilkan menu di pojokan
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mn_webview){
            startActivity(new Intent(MenuActivity.this, WebViewActivity.class));
        }
        else if (id==R.id.mn_toast){
            startActivity(new Intent(MenuActivity.this, CustomToastActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
