package mobile.app.qybae.demo.intent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mobile.app.qybae.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    @BindView(R.id.btnwhite)
    Button btnwhite;
    @BindView(R.id.btnblack)
    Button btnblack;
    Unbinder unbinder;
    @BindView(R.id.lay_detail_frag)
    LinearLayout layDetailFrag;

    String warna;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null)
        {
            warna = savedInstanceState.getString("warna" , "oren");

            if (warna == "oren")
            {
                layDetailFrag.setBackgroundColor(getResources().getColor(R.color.amber_200));
            }
            else
            {
                layDetailFrag.setBackgroundColor(getResources().getColor(R.color.green_300));
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.detail_frag, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("warna", warna);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnwhite)
    public void onBtnwhiteClicked() {
        layDetailFrag.setBackgroundColor(getResources().getColor(R.color.amber_200));
        warna = "oren";
    }

    @OnClick(R.id.btnblack)
    public void onBtnblackClicked() {
        layDetailFrag.setBackgroundColor(getResources().getColor(R.color.green_300));
        warna = "ijo";
    }


}
