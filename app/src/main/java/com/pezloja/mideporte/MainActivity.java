package com.pezloja.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_tipo;
    RadioButton rb_individual, rb_enPareja, rb_grupal;
    Spinner sp_cambia;
    TextView str_resultado;
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_tipo = findViewById(R.id.rg_tipo);
        rb_individual = findViewById(R.id.rb_individual);
        rb_enPareja = findViewById(R.id.rb_enPareja);
        rb_grupal = findViewById(R.id.rb_grupal);
        sp_cambia = findViewById(R.id.sp_cambia);
        str_resultado = findViewById(R.id.str_resultado);

        rg_tipo.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_individual) {
                mostrarSpinner(1);
            } else if (checkedId == R.id.rb_enPareja) {
                mostrarSpinner(2);
            } else if (checkedId == R.id.rb_grupal) {
                mostrarSpinner(3);
            }
        });

        mostrarSpinner(1);
        resultado = sp_cambia.getSelectedItem().toString();
        mostrarTexto();

    }
        private void mostrarSpinner(int num) {
        switch (num) {
            case 1:
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.individual, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_cambia.setAdapter(adapter);
                break;
            case 2:
                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.enPareja, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_cambia.setAdapter(adapter2);
                break;
            case 3:
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.grupal, android.R.layout.simple_spinner_item);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_cambia.setAdapter(adapter3);
                break;

        }

        sp_cambia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultado = sp_cambia.getSelectedItem().toString();
                mostrarTexto();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    private void mostrarTexto() {
        str_resultado.setText(resultado);
    }
}