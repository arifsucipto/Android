package mobile.app.qybae.demo.adapter;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import mobile.app.qybae.demo.Firebase.DetailStudentActivity;
import mobile.app.qybae.demo.PojoStudents.StudentsItem;
import mobile.app.qybae.demo.R;

/**
 * Created by Arisuu on 1/20/2018.
 * langkah dalam meembuat adapter recyvle view
 * 1. buat class adapter, extend RecyclerView.Adapter< nama class. method(MyHolder)>
 * 2. alt enter buat implement method recyclerview, nanti bakal muncul list method, pilih semua
 * 3. di method myholder, implement extend view holder
 */

public class AdapterStudents extends RecyclerView.Adapter<AdapterStudents.MyHolder> {


    Context context;
    LayoutInflater inflater;
    List<StudentsItem> dataallmurid;

    public AdapterStudents(Context context, List<StudentsItem> dataallmurid) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.dataallmurid = dataallmurid;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_students, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        final StudentsItem item = dataallmurid.get(position);
        holder.txtstudentname.setText(item.getNama());
        holder.txtalamatmurid.setText(item.getAlamat());
        holder.txtemailmurid.setText(item.getEmail());
        holder.txtphonemurid.setText(item.getPhone());
        holder.linmurid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "muridnya : " + holder.txtstudentname.getText(), Toast.LENGTH_SHORT).show();
                Intent kirimdata = new Intent(context, DetailStudentActivity.class);
                kirimdata.putExtra("murid", item);
                context.startActivity(kirimdata);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataallmurid.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtstudentname;
        TextView txtalamatmurid;
        TextView txtemailmurid;
        TextView txtphonemurid;
        LinearLayout linmurid;

        public MyHolder(View itemView) {
            super(itemView);
            txtalamatmurid = (TextView) itemView.findViewById(R.id.tv_studentaddress);
            txtemailmurid = (TextView) itemView.findViewById(R.id.tv_studentemail);
            txtphonemurid = (TextView) itemView.findViewById(R.id.tv_studentphone);
            txtstudentname = (TextView) itemView.findViewById(R.id.tv_studentname);
            linmurid = (LinearLayout) itemView.findViewById(R.id.linstudents);


        }
    }
}
