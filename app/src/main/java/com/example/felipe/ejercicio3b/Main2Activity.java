package com.example.felipe.ejercicio3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends Activity {

   //Se crea el testView donde saldrán los resultados
    TextView mostrar;
    //identificador para las preferencias
    final String DATOS="datos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //se le da cuerpo al textView
        mostrar=(TextView)findViewById(R.id.textView2);
        //Se leen las preferencias con el mismo identificador de la primera pantalla
        SharedPreferences misPreferencias= getSharedPreferences(DATOS,Activity.MODE_PRIVATE);
        //Se rellenan las distintas variables con los respectivos datos.
        String nombre=misPreferencias.getString("nombre", "");
        String dni=misPreferencias.getString("dni", "");
        String edad=misPreferencias.getString("edad","");
        String sexo=misPreferencias.getString("sexo","");
        //Se muestra en el textView los datos guardados
        mostrar.setText("Nombre: "+nombre+"\nDNI: "+dni+"\nFecha de nacimiento: "+edad+"\nSexo: "+sexo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
