package uy.shadow.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnEditar = findViewById(R.id.ButtonR);

        final EditText Nom = findViewById(R.id.NombreR);
        final View Fech = findViewById(R.id.FechaR);
        final EditText Tel = findViewById(R.id.TelefonoR);
        final EditText Eml = findViewById(R.id.EmailR);
        final EditText Desc = findViewById(R.id.DescripcionR);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviarDatos = new Intent(MainActivity.this, DetallesFormulario.class);
                enviarDatos.putExtra("Nombre", Nom.getText().toString());
                enviarDatos.putExtra("Fecha", Fech.toString());
                enviarDatos.putExtra("Telefono", Tel.getText().toString());
                enviarDatos.putExtra("Email", Eml.getText().toString());
                enviarDatos.putExtra("Descripcion", Desc.getText().toString());
                startActivity(enviarDatos);
                finish();
            }
        });
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
