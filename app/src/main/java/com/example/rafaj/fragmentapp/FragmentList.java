package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    ArrayList<Planetas> array = new ArrayList<Planetas>();
    Planetas Sol;
    Planetas Mercurio;
    Planetas Marte;
    Planetas Venus;
    Planetas Tierra;
    Planetas Jupiter;
    Planetas Saturno;
    Planetas Neptuno;
    Planetas Urano;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InstanciarPlanetas();


        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();

            bundle.putString("KEY",array.get(i).getNombre());
            bundle.putString("KEY2", array.get(i).getPoblacion());
            bundle.putString("KEY3", array.get(i).getColor());
            newIntent.setType("*/*");
            newIntent.putExtras(bundle);
            newIntent.putExtra("Photo",array.get(i).getImagen());


            startActivity(newIntent);

        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("KEY", array.get(i).getNombre());
            bundle.putString("KEY2", array.get(i).getPoblacion());
            bundle.putString("KEY3", array.get(i).getColor());
            bundle.putInt("KEY4",array.get(i).getImagen());

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }

    public void InstanciarPlanetas(){

        Sol= new Planetas("Sol","El color del planeta es Naranja","Poblacion total del planeta: 0",R.drawable.sol);
        Mercurio= new Planetas("Mercurio","El color del planeta es Marrón","Poblacion total del planeta: 0",R.drawable.mercurio);
        Venus= new Planetas("Venus","El color del planeta es Amarillo","Poblacion total del planeta: 0",R.drawable.venus);
        Tierra= new Planetas("Tierra","El color del planeta es Azul y Verde","Poblacion total del planeta: 7.442 mm",R.drawable.tierra);
        Marte= new Planetas("Marte","El color del planeta es Rojo","Poblacion total del planeta: 0",R.drawable.marte);
        Jupiter= new Planetas("Jupiter","El color del planeta es Naranja y Blanco","Poblacion total del planeta: 0",R.drawable.jupiter);
        Saturno= new Planetas("Saturno","El color del planeta es Beige","Poblacion total del planeta: 0",R.drawable.saturno);
        Urano= new Planetas("Urano","El color del planeta es Morado","Poblacion total del planeta: 0",R.drawable.urano);
        Neptuno= new Planetas("Neptuno","El color del planeta es Azul","Poblacion total del planeta: 0",R.drawable.neptuno);



        array.add(Sol);
        array.add(Mercurio);
        array.add(Venus);
        array.add(Tierra);
        array.add(Marte);
        array.add(Jupiter);
        array.add(Saturno);
        array.add(Urano);
        array.add(Neptuno);

    }
}
