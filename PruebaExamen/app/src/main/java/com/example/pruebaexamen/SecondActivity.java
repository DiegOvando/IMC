package com.example.pruebaexamen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btnCalcular, btnRegresar;
    private TextView lblNombre, lblPeso, lblEstatura, lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle datos = getIntent().getExtras();

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblPeso = (TextView) findViewById(R.id.lblPeso);
        lblEstatura = (TextView) findViewById(R.id.lblEstatura);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        lblNombre.setText(datos.getString("nombre"));
        lblPeso.setText(datos.getString("peso"));
        lblEstatura.setText(datos.getString("estatura"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float peso = Float.parseFloat(lblPeso.getText().toString());
                final float estatura = Float.parseFloat(lblEstatura.getText().toString());
                Imc imc = new Imc(peso, estatura);
                lblResultado.setText("Su IMC es: " +imc.calcularImc());
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(SecondActivity.this);
                confirmar.setTitle("¿Regresar?");
                confirmar.setMessage("Se descartará toda la información ingresada");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //nada
                    }
                });
                confirmar.show();
            }
        });
    }
}
