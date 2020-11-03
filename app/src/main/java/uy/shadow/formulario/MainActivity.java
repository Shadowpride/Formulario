package uy.shadow.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnEditar = findViewById(R.id.ButtonR);

        final EditText Nom = findViewById(R.id.NombreR);
        final EditText Fech = findViewById(R.id.FechaR);
        final EditText Tel = findViewById(R.id.TelefonoR);
        final EditText Eml = findViewById(R.id.EmailR);
        final EditText Desc = findViewById(R.id.DescripcionR);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creo el intent para ir a la otra activity
                Intent enviarDatos = new Intent(MainActivity.this, DetallesFormulario.class);

                //Agrego los datos al intent
                enviarDatos.putExtra("Nombre", Nom.getText().toString());
                enviarDatos.putExtra("Fecha", Fech.getText().toString());
                enviarDatos.putExtra("Telefono", Tel.getText().toString());
                enviarDatos.putExtra("Email", Eml.getText().toString());
                enviarDatos.putExtra("Descripcion", Desc.getText().toString());

                //Inicio la activity
                startActivity(enviarDatos);
            }
        });
    }
}
