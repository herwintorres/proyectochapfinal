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

import com.example.proyectochat.model.RegistroModel;
import com.example.proyectochat.presenter.RegistroPresenter;
import com.example.proyectochat.view.RegistroContract;

public class Registro extends AppCompatActivity implements RegistroContract.View {
    // Componentes de la interfaz de usuario
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText  editTextPassword;
    private Button btnRegister;
    private TextView  textViewLogin;

    //Presentador
    private RegistroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        // Inicialización de componentes de la interfaz de usuario
        editTextName = findViewById(R.id.usernameEditText);
        editTextEmail = findViewById(R.id.emailEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        btnRegister = findViewById(R.id.registerButton);
        textViewLogin = findViewById(R.id.loginText);

        //creacion del presentador
        presenter = new RegistroPresenter(this, new RegistroModel());
        //Configuración de los listeners
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.registerUser();
            }
        });
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearInputFields() {
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPassword.setText("");
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public String getName() {
        return editTextName.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString().trim();
    }

}