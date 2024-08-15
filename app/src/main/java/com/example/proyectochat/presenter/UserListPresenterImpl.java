package com.example.proyectochat.presenter;

import com.example.proyectochat.model.UserModel;
import com.example.proyectochat.view.UserListContract;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UserListPresenterImpl implements UserListPresenter{
    private UserListContract view; // Interfaz de vista que maneja la interacción con la interfaz de usuario
    private FirebaseFirestore db; // Instancia de Firebase Firestore para acceder a la base de datos

    // Constructor del presentador que recibe la vista
    public UserListPresenterImpl(UserListContract view){
        this.view = view;
        this.db = FirebaseFirestore.getInstance();
    }
    // Método para cargar la lista de usuarios desde Firestore
    @Override
    public void loadUsers() {
        // Obtén la referencia a la colección de usuarios en Firestore
        db.collection("usuarios")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<UserModel> userList = new ArrayList<>();
                    for(DocumentSnapshot document : queryDocumentSnapshots.getDocuments()){
                        UserModel user = document.toObject(UserModel.class);
                        userList.add(user);
                    }
                    view.displayUsers(userList);
                })
                .addOnFailureListener(e ->{
                    view.showError("Error al cargar los usuarios: "+e.getMessage());
                });
    }
}
