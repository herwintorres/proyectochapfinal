package com.example.proyectochat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectochat.model.LoginModel;
import com.example.proyectochat.presenter.LoginPresenter;
import com.example.proyectochat.view.LoginContract;

public class Login extends AppCompatActivity implements LoginContract.View {
    //Componentes de la interfaz de usuario
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;
    private TextView registerText;

    //presentador
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Inicialización de componentes de la interfaz de usuario
        editTextEmail = findViewById(R.id.emailEditTextLogin);
        editTextPassword = findViewById(R.id.passwordEditTextLogin);
        btnLogin = findViewById(R.id.loginButton);
        registerText = findViewById(R.id.registerText);
        //creación del presentador
        presenter = new LoginPresenter(this, new LoginModel());
        //Configuración del listener del botón de inicio de sesión
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginUser();
            }
        });
        // Configuración del listener para el texto de registro
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegistration();
            }
        });
    }

    @Override
    public void showToast(String message) {
        // Mostrar un mensaje de tostada
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
        finish();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString().trim();
    }
    /**
     * Método para navegar a la actividad de registro.
     */
    private void navigateToRegistration() {
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
        finish();
    }

}