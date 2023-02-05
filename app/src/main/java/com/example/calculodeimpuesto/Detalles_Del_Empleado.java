package com.example.calculodeimpuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalles_Del_Empleado extends AppCompatActivity {

    // Declaramos los objetos a necesitar de la Segunda activity
    // Y declaramos el boton
    Button Nuevo;
    // Serán de tipo TextView
    TextView mostrarNom, mostrarDesc, mostrarMonto, mostrarRenta, mostrarLiquido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_del_empleado);
        // Referencias de los TextView Con los id correspondientes
        mostrarNom = findViewById(R.id.textMostrarNom);
        mostrarDesc = findViewById(R.id.textMostrarDes);
        mostrarMonto = findViewById(R.id.textMonto);
        mostrarRenta = findViewById(R.id.textRenta);
        mostrarLiquido = findViewById(R.id.textLiquido);
        Nuevo = findViewById(R.id.btnNuevo);
        // Agregamos la funcion del boton clic
        // Nos permitirá regresar como añadir
        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llamamos el método que creamos que nos permite
                // solo observar 1 ventana. De las Activities
                BackToBack();
            }
        });
    }
    public void BackToBack(){
        finish();
    }
    // Creamos el método onResume
    @Override
    protected void onResume() {
        super.onResume();
        // Averiguemos si tenemos datos escondidos
        Bundle Mostrar = getIntent().getExtras();
        if (Mostrar != null){
            // Creamos una variable de tipo de dato que necesitamos
            // con su respectiva llave asignada en el primer Activity
            String name = Mostrar.getString("Nombre");
            double pago = Mostrar.getDouble("Monto");
            double apagar = Mostrar.getDouble("Renta");
            String conocer = Mostrar.getString("Descripcion");
            double SueldoLiquido = Mostrar.getDouble("Liquido");
            // Le asignamos datos a los TextView
            mostrarNom.setText(name);
            mostrarMonto.setText("$ " + pago);
            mostrarRenta.setText("$ " + apagar);
            mostrarDesc.setText(conocer);
            mostrarLiquido.setText("$ "+ SueldoLiquido);
        }
    }
}