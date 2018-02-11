package mobile.app.qybae.demo.intent;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import mobile.app.qybae.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.ListFragment {
    private JobListener jobListener;
    int ind = 0;
    int counter = 0;

    public ListFragment() {
        // Required empty public constructor
    }

// remark karena extend di atas nya di ganti dari fragment pake list fragment
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.list_frag, container, false);
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //ketika activity dibuat pake method ini, buat dapetin list yang ada di array
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//array adapter string karena ngikut dari string xml
        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.job)                //r.array.job = sesuai nama string di xml
        ));

        //set pas awal langsung dipilih index 0 ketika hp landscape
       // if (this.getActivity().findViewById(R.id.layoutfrag) == null) //landscape mode
        //{
            if(savedInstanceState==null)
            {
                ind = 0;
                counter = 0;
                jobListener.onJobSelected(ind, counter);
            }
            else
            {
                ind = savedInstanceState.getInt("index", 0);
                counter = savedInstanceState.getInt("count", 0);
                jobListener.onJobSelected(ind, counter);
            }

       // }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getActivity(), "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getActivity(), "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    public interface JobListener {
        public void onJobSelected(int index, int counter);
    }

    //ketika fragment nempel ke activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            jobListener = (JobListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() +
                    " must implement interface call job listener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ind = position;
        counter++;
        jobListener.onJobSelected(position, counter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("index", ind);
        outState.putInt("count", counter);
    }
}
