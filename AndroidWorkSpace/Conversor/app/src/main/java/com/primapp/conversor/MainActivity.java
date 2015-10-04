package com.primapp.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Definimos las variables de entrada
    private EditText preuInm;
    private EditText estalvis;
    private EditText plazo;
    private EditText euribor;
    private EditText diferencial;

    //Definimos las variables de salida
    private TextView mes, total;

    //Definimos boton de inicio del calculo
    private Button Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preuInm = (EditText)findViewById(R.id.etPreuInm);
        preuInm.addTextChangedListener(onWatch);

        estalvis = (EditText)findViewById(R.id.etEstalvis);
        preuInm.addTextChangedListener(onWatch);

        plazo = (EditText)findViewById(R.id.etPlazo);
        preuInm.addTextChangedListener(onWatch);

        euribor = (EditText)findViewById(R.id.etEuribor);
        preuInm.addTextChangedListener(onWatch);

        diferencial = (EditText)findViewById(R.id.etDiferencial);
        preuInm.addTextChangedListener(onWatch);


        mes = (TextView)findViewById(R.id.tvMes);
        total = (TextView)findViewById(R.id.tvTotal);

        //ocultamos los resultados inicialmente ya que no hay valores que calcular
        mes.setVisibility (View.GONE);
        total.setVisibility(View.GONE);

        //referenciamos el botón
        Calc = (Button)findViewById(R.id.btnCal);

        //ajustamos los valores a 0 al crearse
        setValues ("0","0");
    }

    /*public void initilize(){
        estalvis, plazo, euribor, diferencial;

        preuInm = 0;
        estalvis = 0;

    }*/

    public final TextWatcher onWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {    }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            total.setVisibility(View.VISIBLE);
            mes.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 0){
                total.setVisibility(View.GONE);
                mes.setVisibility(View.GONE);
            }else{
                //onCalcular();
            }


        }
    };


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

    public void calcHipoteca (){

        //Parseamos a double
        double preuInmDb = Double.valueOf(preuInm.getText().toString());
        double estalvisDb = Double.valueOf(estalvis.getText().toString());
        double plazoDb = Double.valueOf(plazo.getText().toString());
        double euriborDb = Double.valueOf(euribor.getText().toString());
        double diferencialDb = Double.valueOf(diferencial.getText().toString());


        double capital = preuInmDb - estalvisDb;
        double interes = (euriborDb+diferencialDb)/12;

        double total = capital + interes;
        double potencia = Math.pow(((1+interes)/100),(-plazoDb));
        double mes = (capital*(interes))/(100*potencia);

        String mesStr = String.valueOf(mes);
        String totalStr = String.valueOf(total);

        setValues(mesStr, totalStr);
    }

    public void onCalcular(View view) {
        calcHipoteca();
    }

    public void setValues (String mesCal, String totalCal) {
        mes.setText("Mes: "+mesCal);
        total.setText("Total: "+totalCal);
    }

}
