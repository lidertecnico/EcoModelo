package unal.todosalau.ecomodelo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import unal.todosalau.ecomodelo.modelos.Usuario;

public class Login extends AppCompatActivity {
private EditText emailEditText;
private EditText passwordEditText;
private Button loginButton;
private Button registerButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    emailEditText = findViewById(R.id.paswwordEditText);
    passwordEditText = findViewById(R.id.editTextTextPassword);
    loginButton = findViewById(R.id.botonIngresar);
    registerButton = findViewById(R.id.botonRegistrarse);

    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Validar las credenciales del usuario
            if (validarCredenciales(email, password)) {
                // Credenciales válidas, realizar la acción de inicio de sesión
                iniciarSesion();
            } else {
                // Credenciales inválidas, mostrar mensaje de error
                Toast.makeText(Login.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
            }
        }
    });

    registerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Realizar la acción de registro
            registrar();
        }
    });
}

private boolean validarCredenciales(String email, String password) {
    // Aquí puedes implementar la lógica de validación de las credenciales.
    // Puedes realizar consultas a la base de datos, verificar con un API, etc.
    // Por simplicidad, aquí se valida un usuario fijo.

    // Usuario de ejemplo
    Usuario usuarioEjemplo = new Usuario("Nombre Ejemplo", "ejemplo@correo.com", "contrasena");

    return email.equals(usuarioEjemplo.getCorreo()) && password.equals(usuarioEjemplo.getContrasena());
}

private void iniciarSesion() {
    // Aquí puedes implementar la lógica para iniciar sesión.
    // Por ejemplo, puedes abrir una nueva actividad o realizar alguna acción después del inicio de sesión exitoso.
    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
}

private void registrar() {
    // Aquí puedes implementar la lógica para registrar un nuevo usuario.
    Intent Registrar = new Intent(Login.this, RegistroUsuario.class );
    startActivity(Registrar);
    // Por ejemplo, puedes abrir una actividad de registro o mostrar un formulario de registro.
    Toast.makeText(this, "Registro de usuario", Toast.LENGTH_SHORT).show();
}
}