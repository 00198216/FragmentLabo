package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.app.FragmentContainer;
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

    //From a Previus build
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

    private String[] Nombres;
    private String[] Color;
    private String[] Photo;
    private String[] Poblacion;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        //Agarrando Datos

        Nombres = getResources().getStringArray(R.array.Nombre);
        Photo =  getResources().getStringArray(R.array.Imagenes);
        Poblacion = getResources().getStringArray(R.array.Poblacion);
        Color = getResources().getStringArray(R.array.Color);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //InstanciarPlanetas();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        Planetas PlanetaObjeto = new Planetas(Nombres[i],Color[i],Poblacion[i],Photo[i]);

        // Si es Portrait

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            //Mandamos datos atravez de un Intent

            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            Bundle bundle= new Bundle();
            bundle.putSerializable("Key",PlanetaObjeto);

            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            newIntent.putExtras(bundle);



            startActivity(newIntent);

        }
        // Si es Landscape
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            //Mandando el Bundle atravez de Fragment Transaction


            FragmentViewer fragment = new FragmentViewer();
            Bundle bundle= new Bundle();
            bundle.putSerializable("Key",PlanetaObjeto);
            fragment.setArguments(bundle);
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.viewer, fragment);
            ft.commit();




        }



    }

    // Instancia y agrega la info de planetas

  //  public void InstanciarPlanetas(){

        //Sol= new Planetas("Sol","El color del planeta es Naranja","Poblacion total del planeta: 0",R.drawable.sol);
       // Mercurio= new Planetas("Mercurio","El color del planeta es Marrón","Poblacion total del planeta: 0",R.drawable.mercurio);
       // Venus= new Planetas("Venus","El color del planeta es Amarillo","Poblacion total del planeta: 0",R.drawable.venus);
        //Tierra= new Planetas("Tierra","El color del planeta es Azul y Verde","Poblacion total del planeta: 7.442 mm",R.drawable.tierra);
       // Marte= new Planetas("Marte","El color del planeta es Rojo","Poblacion total del planeta: 0",R.drawable.marte);
        //Jupiter= new Planetas("Jupiter","El color del planeta es Naranja y Blanco","Poblacion total del planeta: 0",R.drawable.jupiter);
        //Saturno= new Planetas("Saturno","El color del planeta es Beige","Poblacion total del planeta: 0",R.drawable.saturno);
       // Urano= new Planetas("Urano","El color del planeta es Morado","Poblacion total del planeta: 0",R.drawable.urano);
       // Neptuno= new Planetas("Neptuno","El color del planeta es Azul","Poblacion total del planeta: 0",R.drawable.neptuno);



        //array.add(Sol);
       // array.add(Mercurio);
       // array.add(Venus);
       //array.add(Tierra);
       // array.add(Marte);
       // array.add(Jupiter);
       // array.add(Saturno);
       // array.add(Urano);
       // array.add(Neptuno);

   // }


}
