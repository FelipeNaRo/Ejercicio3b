package com.example.felipe.ejercicio3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText nombre,dni,edad; //creamos los edittext para guardar los datos
    RadioGroup sexo;        //radio botón para elegir sexo
    Button guardar;         //botón para enviar los datos
    final String DATOS="datos";//identificador para las preferencias
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //damos contenido a cada uno de los elementos
        nombre= (EditText) findViewById(R.id.nombre);
        dni=(EditText)findViewById(R.id.dni);
        edad=(EditText)findViewById(R.id.edad);
        sexo=(RadioGroup)findViewById(R.id.sexo);
        guardar=(Button)findViewById(R.id.guardar);
        // creamos el listeneer del botón de guardar
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cogerDatos();
            }
        });
    }

    public void cogerDatos(){
        // realiza la operación de guardar datos y lanzar la segunda activity
       // se recogen los datos de los distintos textView
        String nom=nombre.getText().toString();
        String d=dni.getText().toString();
        String ed=edad.getText().toString();
        String sex="";
        switch (sexo.getCheckedRadioButtonId()){

            case R.id.mas:
                 sex="masculino";
                break;
            case R.id.fem:
                 sex="femenino";
                break;
        }
        // se crean las preferencias y el editor de las mismas, que van a permitir guardar los datos
        SharedPreferences misPreferencias=getSharedPreferences(DATOS,Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor =misPreferencias.edit();
        //se introducen los valores con su identificador
        editor.putString("nombre",nom);
        editor.putString("dni",d);
        editor.putString("edad",ed);
        editor.putString("sexo", sex);
        // se guardan los valores
        editor.commit();
        //Se realiza el intento de lanzar la siguiente activity o pantalla.
        Intent llamada=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(llamada);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
