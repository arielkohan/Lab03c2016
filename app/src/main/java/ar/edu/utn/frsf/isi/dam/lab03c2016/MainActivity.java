package ar.edu.utn.frsf.isi.dam.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{

    private Toolbar toolbar;

    private ListView listView;
    private CustomAdapter adapter;
    private ArrayList<Trabajo> listTrabajos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title);
        setSupportActionBar(toolbar);*/
        listTrabajos = new ArrayList<Trabajo>();
        listTrabajos.addAll(Arrays.asList(Trabajo.TRABAJOS_MOCK));

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, listTrabajos, getResources());
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);



    }



    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Trabajo trabajo = (Trabajo) parent.getItemAtPosition(position);
        Toast.makeText(this, trabajo.getDescripcion(), Toast.LENGTH_LONG).show();
        return false;
    }

    /*public boolean onCreateOptionsMenu(Menu menu){

    }*/
}
