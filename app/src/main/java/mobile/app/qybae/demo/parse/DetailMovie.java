package mobile.app.qybae.demo.parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.helper.MyFunction;

public class DetailMovie extends MyFunction {

    @BindView(R.id.imgdetailmovie)
    ImageView imgdetailmovie;
    @BindView(R.id.txtdetailmovie)
    TextView txtdetailmovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);

        Intent terimadata = getIntent();
        txtdetailmovie.setText(terimadata.getStringExtra("desc"));
        Picasso.with(con)
                .load(terimadata.getStringExtra("img"))
                .placeholder(R.drawable.ic_launcher_foreground)
                .resize(200,200)
                .centerCrop()
                .into(imgdetailmovie);
    }
}
