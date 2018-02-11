package mobile.app.qybae.demo.indoactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.app.qybae.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationIndoFragment extends Fragment {


    public LocationIndoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_indo, container, false);
    }

}
