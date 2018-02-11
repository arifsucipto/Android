package mobile.app.qybae.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mobile.app.qybae.demo.R;

/**
 * Created by marif_s.i on 13/01/2018.
 */

public class adapterListView extends BaseAdapter{
    Context con;
    String[] buah;
    int[] gambar;

    public adapterListView(Context con, String[] buah, int[] gambar) {
        this.con = con;
        this.buah = buah;
        this.gambar = gambar;
    }



    @Override
    public int getCount() {
        return buah.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    //getview ini , pertama buat xml di layout untuk isi dari txt sama image
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflate = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflate.inflate(R.layout.custom_list, null);
        TextView txt = (TextView) view.findViewById(R.id.txtlistcustom);
        ImageView img = (ImageView) view.findViewById(R.id.imglist);

        txt.setText(buah[i]);
        img.setImageResource(gambar[i]);
        return view;
    }
}
