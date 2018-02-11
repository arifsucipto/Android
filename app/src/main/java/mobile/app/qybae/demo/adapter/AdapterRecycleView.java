package mobile.app.qybae.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.parse.RecycleView;

/**
 * Created by marif_s.i on 14/01/2018.
 */

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.MyHolder> {
    Context context;
    LayoutInflater inflate;
    String[] namaFilm = {"Film 1", "Film 2", "Film 3", "Film 4", "Film 5", "Film 6"};
    String[] versiFilm = {"1", "2", "3", "4", "5", "6"};

    public AdapterRecycleView(Context context) {
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //bagian menempelkan layout
        //buat layout di resrouce
        View view = inflate.inflate(R.layout.list_movie, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.namafilm.setText(namaFilm[position]);
        holder.versifilm.setText(versiFilm[position]);
    }

    @Override
    public int getItemCount() {
        return namaFilm.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView namafilm;
        TextView versifilm;

        public MyHolder(View itemView) {
            super(itemView);
            namafilm = (TextView) itemView.findViewById(R.id.tv_film);
            versifilm = (TextView) itemView.findViewById(R.id.tv_versi);
        }
    }
}
