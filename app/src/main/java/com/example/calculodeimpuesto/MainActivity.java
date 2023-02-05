package com.example.calculodeimpuesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ResourceCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Se definen los objetos del MainActivitu
    Button siguiente;
    EditText ingreNom, ingreMonto, ingreRenta, ingreEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Se declaran las referencias de los objetos a necesitar
        siguiente = findViewById(R.id.btnCalcular);
        ingreNom = findViewById(R.id.TvIngreNom);
        ingreMonto = findViewById(R.id.tvIngreMonto);
        ingreRenta = findViewById(R.id.tvIngreRenta);
        ingreEstado = findViewById(R.id.tvIngreEmpleo);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llamamos al método que nos almacena los datos
                // Y almacena la ruta a la otra Activity
                Empleado();
            }
        });

    }
    // Este método almacenará los datos del empleado
    // una vez terminado lo llamamos en el boton
    public void Empleado(){
        // Se crean 2 tipos de String
        String name;
        // La variable name se almacena en el objeto ingreNom
        name = ingreNom.getText().toString();
        String conocer;
        // La variable conocer se almacena en el objeto ingreEstado;
        conocer = ingreEstado.getText().toString();
        // Y estas 3 serán para su monto, Renta y el IVA 10% equivale a 0.10
        // Y crearemos 1 para el sueldo liquido del empleado
        // Como hablamos de datos de pago al empleado
        // Daremos como base inicialización en 0.
        double pago=0;
        double IVA = 0.10;
        // La variable pago se almacena en el objeto ingreMonto
        // Para ello se realiza una conversión, igual haremos con
        // la otra variable
        pago = Double.parseDouble(ingreMonto.getText().toString());
        double apagar=0;
        apagar = Double.parseDouble(ingreRenta.getText().toString());
        double SueldoLiquido=0;
        // Calculamos el sueldo Liquido
        // El sueldo Liquido será igual al pago(monto) - apagar(renta)
        // - el IVA 10% que equivale el 0.10
        SueldoLiquido = pago - apagar + IVA;
        // Este método también almacenará, que al añadir los datos y al darle clic
        // nos cambiará a la siguiente Activity
        Intent Registro = new Intent(MainActivity.this  , Detalles_Del_Empleado.class);
        Registro.putExtra("Nombre", name);
        Registro.putExtra("Monto",pago);
        Registro.putExtra("Renta", apagar);
        Registro.putExtra("Descripcion", conocer);
        Registro.putExtra("Liquido", SueldoLiquido);
        startActivity(Registro);
        // Limpiamos los datos al momento de volver a la primera Activity
        ingreNom.setText("");
        ingreMonto.setText("");
        ingreRenta.setText("");
        ingreEstado.setText("");
    }
}