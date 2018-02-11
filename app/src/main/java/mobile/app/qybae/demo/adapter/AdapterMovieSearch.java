package mobile.app.qybae.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mobile.app.qybae.demo.Pojo.ResultsItem;
import mobile.app.qybae.demo.R;
import mobile.app.qybae.demo.parse.CONSTANT;
import mobile.app.qybae.demo.parse.DetailMovie;

/**
 * Created by marif_s.i on 14/01/2018.
 */

public class AdapterMovieSearch extends RecyclerView.Adapter<AdapterMovieSearch.MyHolder> {

    Context context;
    LayoutInflater inflater;


    public AdapterMovieSearch(Context context, List<ResultsItem> datamovie) {
        this.context = context;
        this.datamovie = datamovie;
        this.inflater = LayoutInflater.from(context);
    }

    List<ResultsItem> datamovie;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_db_movie, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final ResultsItem item = datamovie.get(position);
        holder.txtmoviedb.setText(item.getOriginalTitle());
        holder.txtversidb.setText(item.getReleaseDate());
        holder.txtdescmovie.setText(item.getOverview());
        Picasso.with(context)
                .load(CONSTANT.IMAGE_URL+item.getPosterPath())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.alpukat)
                .resize(50,50)
                .centerCrop()
                .into(holder.imgmoviedb);

        holder.imgmoviedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimdata = new Intent(context,DetailMovie.class);
                kirimdata.putExtra("desc",item.getOverview());
                kirimdata.putExtra("img",CONSTANT.IMAGE_URL+item.getPosterPath());
                context.startActivity(kirimdata);
            }
        });
        //holder.imgmoviedb.setImageResource(item.getPosterPath());
    }

    @Override
    public int getItemCount() {
        return datamovie.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtmoviedb;
        TextView txtversidb;
        ImageView imgmoviedb;
        TextView txtdescmovie;
        public MyHolder(View itemView) {
            super(itemView);
            txtmoviedb = (TextView) itemView.findViewById(R.id.tv_filmdb);
            txtversidb = (TextView) itemView.findViewById(R.id.tv_versidb);
            txtdescmovie = (TextView) itemView.findViewById(R.id.tvdesc);
            imgmoviedb = (ImageView) itemView.findViewById(R.id.imgmoviedb);

        }
    }
}
