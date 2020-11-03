package uy.shadow.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class DetallesFormulario extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvEmail;
    private TextView tvTelefono;
    private TextView tvDescripcion;
    private TextView tvButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_formulario);

        //Obtengo los parametros del intent
        Bundle parametros = getIntent().getExtras();

        //Asigno cada parametro a una variable
        String nombre = parametros.getString("Nombre");
        String fecha = parametros.getString("Fecha");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        String button  = parametros.getString(getResources().getString(R.string.pbutton));//

        tvNombre         = (TextView) findViewById(R.id.tvNombre);
        tvFecha          = (TextView) findViewById(R.id.tvFecha);
        tvTelefono       = (TextView) findViewById(R.id.tvTelefono);
        tvEmail          = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion    = (TextView) findViewById(R.id.tvDescripcion);
        tvButton         = (TextView) findViewById(R.id.tvButton);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        //tvButton.setText(button);

        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesFormulario.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}