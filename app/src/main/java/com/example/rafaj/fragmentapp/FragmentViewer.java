package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

            Planetas Planeta =(Planetas)bundle.getSerializable("Key") ;


            Resources reso =getResources();
            TypedArray Icons = reso.obtainTypedArray(R.array.Icons);
            Drawable drawable = Icons.getDrawable(Integer.parseInt(Planeta.getImagen()));



            text.setText(Planeta.getNombre());
            Photo.setImageDrawable(drawable);
            text2.setText(Planeta.getPoblacion());
            text3.setText(Planeta.getColor());



        }

        return view;
    }


}
