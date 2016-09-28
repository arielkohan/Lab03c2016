package ar.edu.utn.frsf.isi.dam.lab03c2016;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CrearOfertaActivity extends AppCompatActivity  {

    private Spinner spinnerCategoria;
    private ArrayAdapter<Categoria> spinnerAdapter;
    private ArrayList<Categoria> categoriasArrayList;

    private RadioGroup radioGroupMoneda ;
    private EditText editTextOferta;
    private Button guardarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_oferta);

        spinnerCategoria= (Spinner) findViewById(R.id.spinner_categoria);
        categoriasArrayList = new ArrayList<Categoria>();
        categoriasArrayList.addAll(Arrays.asList(Categoria.CATEGORIAS_MOCK));
        spinnerAdapter = new ArrayAdapter<Categoria>(this, android.R.layout.simple_dropdown_item_1line, categoriasArrayList);
        spinnerCategoria.setAdapter(spinnerAdapter);

        editTextOferta = (EditText) findViewById(R.id.editText_oferta);
        radioGroupMoneda = (RadioGroup) findViewById(R.id.radioGroupFlag);

        guardarButton = (Button) findViewById(R.id.buttonGuardar);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextOferta.getText().toString().isEmpty()) {
                    Toast.makeText(CrearOfertaActivity.this, "Llene la descripcion de oferta", Toast.LENGTH_SHORT).show();
                } else {

                    Categoria categoria;
                    int monedaPago;
                    switch (radioGroupMoneda.getCheckedRadioButtonId()){
                        case R.id.radiomoneda_ar: monedaPago = Trabajo.MONEDA_AR; break;
                        case R.id.radiomoneda_eu: monedaPago = Trabajo.MONEDA_EU; break;
                        case R.id.radiomoneda_us: monedaPago = Trabajo.MONEDA_US; break;
                        case R.id.radiomoneda_uk: monedaPago = Trabajo.MONEDA_UK; break;
                        case R.id.radiomoneda_br: monedaPago = Trabajo.MONEDA_BR; break;
                        default: monedaPago = Trabajo.MONEDA_AR;
                    }
                    categoria = (Categoria) spinnerCategoria.getSelectedItem();

                    Trabajo resultado = new Trabajo(Trabajo.cuentaId, editTextOferta.getText().toString(),categoria, monedaPago);

                    Intent i = getIntent();
                    i.putExtra("resultado",resultado);
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });

    }


}
