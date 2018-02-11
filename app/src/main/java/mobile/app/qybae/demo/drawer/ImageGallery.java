package mobile.app.qybae.demo.drawer;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.adapter.AdapterViewPager;
import mobile.app.qybae.demo.helper.MyFunction;

public class ImageGallery extends MyFunction {

    String[] buah;

    CarouselView carouselView;

    int[] sound = {R.raw.strawberry, R.raw.manggis
            , R.raw.jambuair, R.raw.durian,
            R.raw.ceri, R.raw.apel
            , R.raw.alpukat};

    int[] gambarbuah = {R.drawable.strawberry, R.drawable.manggis
            , R.drawable.jambuair, R.drawable.durian,
            R.drawable.ceri, R.drawable.apel
            , R.drawable.alpukat};
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);
        ButterKnife.bind(this);

        buah = getResources().getStringArray(R.array.buah);
        AdapterViewPager adapterViewPager = new AdapterViewPager(con, buah, gambarbuah );
        viewpager.setAdapter(adapterViewPager);
        carouselView = (CarouselView) findViewById(R.id.carouselView);

        carouselView.setPageCount(gambarbuah.length);

        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(con, buah[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(gambarbuah[position]);
        }
    };


}
