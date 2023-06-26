package unal.todosalau.ecomodelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import unal.todosalau.ecomodelo.modelos.Usuario;

public class RegistroUsuario extends AppCompatActivity {
private EditText nombreEditText;
private EditText correoEditText;
private EditText contrasenaEditText;
private EditText repetirContrasenaEditText;
private Button botonRegistrarse;
private boolean terminosAceptados;
private boolean datosAceptados;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registro_usuario);

    // Inicializar vistas
    nombreEditText = findViewById(R.id.nombreEditText);
    correoEditText = findViewById(R.id.correoEditText);
    contrasenaEditText = findViewById(R.id.contrasenaEditText);
    repetirContrasenaEditText = findViewById(R.id.repetirContrasenaEditText);
    botonRegistrarse = findViewById(R.id.botonRegistrarse2);

    botonRegistrarse.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            registrarUsuario();
        }
    });
}

private void registrarUsuario() {
    String nombre = nombreEditText.getText().toString().trim();
    String correo = correoEditText.getText().toString().trim();
    String contrasena = contrasenaEditText.getText().toString().trim();
    String repetirContrasena = repetirContrasenaEditText.getText().toString().trim();
    terminosAceptados = ((CheckBox) findViewById(R.id.checkBoxTerminos)).isChecked();
    datosAceptados = ((CheckBox) findViewById(R.id.checkBoxDatos)).isChecked();

    // Validar los campos
    if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || repetirContrasena.isEmpty()) {
        Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
    }else{
        if (!contrasena.equals(repetirContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }else{
            if (!terminosAceptados || !datosAceptados) {
                Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            }else{
                // Crear una instancia de la clase Usuario con los datos ingresados
                Usuario usuario = new Usuario(nombre, correo, contrasena);

                // Aquí puedes realizar la lógica adicional, como enviar los datos a un servidor o guardarlos localmente

                // Mostrar un mensaje de éxito
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            }
        }
    }






}
}
