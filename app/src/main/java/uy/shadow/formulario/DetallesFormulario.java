package uy.shadow.formulario;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallesFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_formulario);
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String decripcion = parametros.getString("decripcion");
        String diaNacimiento = parametros.getString("diaNacimiento");
        String mesNacimiento = parametros.getString("mesNacimiento");
        String añoNacimiento = parametros.getString("añoNacimiento");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEMail = (TextView) findViewById(R.id.tvEMail);
        TextView tvDescripcionContacto = (TextView) findViewById(R.id.tvDescripcionContacto);

        // Log.i("nombre",nombre);
        tvNombre.setText(nombre);
        //El datapicker devuelve el mes empezando de 0 por eso hay sumarle uno, enero es el mes 0
        tvFechaNacimiento.setText(diaNacimiento+"/"+String.valueOf(Integer.parseInt(mesNacimiento)+1)+"/"+añoNacimiento);
        tvTelefono.setText(telefono);
        tvEMail.setText(email);
        tvDescripcionContacto.setText(decripcion);
        Button btnEditar= (Button) findViewById(R.id.btnVolver);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Intent intent = new Intent(MostrarDatos.this,MainActivity.class);
                onBackPressed();
                //  startActivity(intent);
            }
        });

    }
}