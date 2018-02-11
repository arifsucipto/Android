package mobile.app.qybae.demo.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

import mobile.app.qybae.demo.R;

/**
 * Created by marif_s.i on 13/01/2018.
 */

public class AdapterViewPager extends PagerAdapter{
    Context context;
    String[] buah;
    int[] gambar;
    public AdapterViewPager(Context context, String[] buah, int[] gambar) {
        this.context = context;
        this.buah = buah;
        this.gambar = gambar;
    }


    @Override
    public int getCount() {
        return buah.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.customviewpager,null);
        TextView txtviewpager = (TextView) view.findViewById(R.id.txtviewpager);
        ImageView imgviewpager = (ImageView) view.findViewById(R.id.imgviewpagercustom);

        txtviewpager.setText(buah[position]);
        imgviewpager.setImageResource(gambar[position]);

        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
