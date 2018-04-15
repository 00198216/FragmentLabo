package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

//Llama la informacion de la arrayview para landcape, todo va en bundle.

public class FragmentViewer extends Fragment {
    TextView text;
    TextView text2;
    TextView text3;
    ImageView Photo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        text2= view.findViewById(R.id.textId2);
        text3= view.findViewById(R.id.textId3);
        Photo= view.findViewById(R.id.Img);

        Bundle bundle = this.getArguments();


        if(bundle != null){

            text.setText(bundle.getString("KEY"));
            text2.setText(bundle.getString("KEY2"));
            text3.setText(bundle.getString("KEY3"));
            Photo.setImageResource(bundle.getInt("KEY4"));


        }

        return view;
    }


}
