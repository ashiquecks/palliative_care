package com.example.sargamdesign.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sargamdesign.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ViewFlipper viewFlipper;

    GridView grid;
    String[] web = {"Handicraft","Fashion","Painting","Stiching",} ;


    int[] imageId = {R.drawable.hcr3,R.drawable.krt1,R.drawable.murar1, R.drawable.stichingimage1,};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        GridVewAdapter adapter = new GridVewAdapter(getContext(),web, imageId);
        grid=(GridView)root.findViewById(R.id.griditem);
        grid.setAdapter(adapter);


        Button viewcostume=(Button)root.findViewById(R.id.viewcousyumesbutton);
        Button viewmuralpaint=(Button)root.findViewById(R.id.viewmuralpaint);
        Button viewstichbutton=(Button)root.findViewById(R.id.viewstich);

        int Image []={R.drawable.slideimage2,R.drawable.murar1,R.drawable.stichingimage1,R.drawable.hcrslide };

        viewFlipper=root.findViewById(R.id.view_fliper);

        for (int Images:Image){
            fliperImages(Images);
        }

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;
                switch(position)
                {
                    case 0:
                        intent =  new Intent(getContext(), CostumesActivity.class);
                        break;

                    case 1:
                        intent =  new Intent(getContext(),MuralPainting.class);
                        break;

                    default:
                        intent =  new Intent(getContext(), Stiching.class);
                        break;
                }
                startActivity(intent);


            }
        });


        return root;
    }
    public void fliperImages(int Images) {

        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(Images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }
}