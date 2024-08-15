package com.example.proyectochat.presenter;

import com.example.proyectochat.model.LoginModel;
import com.example.proyectochat.view.LoginContract;
import com.google.firebase.auth.FirebaseUser;


public class LoginPresenter {
    private LoginContract.View view;
    private LoginModel model;

    public LoginPresenter(LoginContract.View view, LoginModel model){
        this.view = view;
        this.model = model;
    }
    // Método para iniciar sesión
    public void loginUser(){
        // Obtener el email y la contraseña ingresados por el usuario desde la vista
        String email = view.getEmail();
        String password = view.getPassword();
        // Validar que el email y la contraseña no estén vacíos
        if(email.isEmpty() || password.isEmpty()){
            view.showToast("Por favor complete todos los campos");
            return;
        }
        // Llamar al método del modelo para iniciar sesión, pasando un callback para manejar el resultado
        model.loginUser(email, password, new LoginModel.LoginCallback(){
            @Override
            public void onSuccess(FirebaseUser user){
                view.showToast("Inicio de sesión exitoso");
                view.navigateToHome();
            }
            @Override
            public void onFailure(Exception e){
                view.showToast("Error de inicio de sesión: "+e.getMessage());
            }
        });
    }
}
