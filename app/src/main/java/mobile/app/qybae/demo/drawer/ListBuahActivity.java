package mobile.app.qybae.demo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.adapterListView;
import mobile.app.qybae.demo.helper.MyFunction;
import mobile.app.qybae.demo.helper.dataBuah;

public class ListBuahActivity extends MyFunction {

    String[] buah;

    private ArrayList<dataBuah> dataBuahArrayList;

    int[] sound = {R.raw.strawberry, R.raw.manggis
       ,R.raw.jambuair, R.raw.durian,                             
       R.raw.ceri, R.raw.apel
       ,R.raw.alpukat};

    int[] gambarbuah = {R.drawable.strawberry, R.drawable.manggis
    ,R.drawable.jambuair, R.drawable.durian,
    R.drawable.ceri, R.drawable.apel
    ,R.drawable.alpukat};

    Context context;
    @BindView(R.id.listviewbuah)
    ListView listviewbuah;


    TypedArray music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBuahArrayList = new ArrayList<>();
        dataBuahArrayList.add(new dataBuah(R.drawable.manggis,R.raw.manggis,"manggis"));

        setContentView(R.layout.activity_list_buah);
        ButterKnife.bind(this);
        final MediaPlayer mp = new MediaPlayer();
        buah = getResources().getStringArray(R.array.buah);
        music = getResources().obtainTypedArray(R.array.music);
        adapterListView adapterlistView = new adapterListView(con, buah, gambarbuah );
        listviewbuah.setAdapter(adapterlistView);
        listviewbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListBuahActivity.this, buah[i], Toast.LENGTH_SHORT).show();

                      Intent kirimbuah = new Intent(ListBuahActivity.this, DetailBuah.class);
                      kirimbuah.putExtra("nama", buah[i]);
                      kirimbuah.putExtra("gambar", gambarbuah[i]);
                      kirimbuah.putExtra("sound", music.getResourceId(i,-1));
                       startActivity(kirimbuah);

            }
        });
    }


}
