package mobile.app.qybae.demo.intent;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mobile.app.qybae.demo.R;

public class fragmentActivity extends AppCompatActivity implements ListFragment.JobListener {

    TextView txtview;
    TextView txtheaderjob;
    TextView txtcounterjob;
    android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        txtview = (TextView) findViewById(R.id.txtstatusjob);
        txtheaderjob = (TextView) findViewById(R.id.txtjobheader);
        txtcounterjob = (TextView) findViewById(R.id.txtcounterview);
        //cek orientasi hp
        if (findViewById(R.id.layoutfrag) != null) //potrait
        {
                   manager.beginTransaction()
                    //.hide(manager.findFragmentById(R.id.detailfragui))
                    .show(manager.findFragmentById(R.id.detailfragui))
                    .show(manager.findFragmentById(R.id.listfragui))
                    .commit();

        }
        else if (findViewById(R.id.layoutfragland) != null)//landscape
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfragui))
                    .show(manager.findFragmentById(R.id.listfragui))
                    .commit();

        }

    }

    @Override
    public void onJobSelected(int index, int counter) {
        if (findViewById(R.id.layoutfrag) != null) //potrait
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfragui))
                    .show(manager.findFragmentById(R.id.listfragui))
                  //  .addToBackStack(null) remark karena detail di tampilkan
                    .commit();
        }

        String [] status = getResources().getStringArray(R.array.stat);
        String [] job = getResources().getStringArray(R.array.job);
        txtview.setText(status[index]);
        txtheaderjob.setText(job[index]);
        txtcounterjob.setText("visited sebanyak : " + counter);





    }
}
