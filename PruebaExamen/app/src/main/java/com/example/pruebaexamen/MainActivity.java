package com.example.pruebaexamen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLimpiar, btnSiguiente, btnSalir;
    private EditText txtNombre, txtPeso, txtEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtEstatura = (EditText) findViewById(R.id.txtEstatura);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtPeso.setText("");
                txtEstatura.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor ingresar su nombre",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtPeso.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el peso",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtEstatura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la estatura",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    //Funciones
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("nombre", txtNombre.getText().toString());
                    bundle.putSerializable("peso", txtPeso.getText().toString());
                    bundle.putSerializable("estatura", txtEstatura.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar App?");
                confirmar.setMessage("Se descartara toda la informacion. ");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                }); confirmar.show();
            }
        });
    }

}
