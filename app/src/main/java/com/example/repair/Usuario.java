package com.example.repair;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static android.content.ContentValues.TAG;

public class Usuario {
    private String uid;
    private String nome;
    private String email;
    private String senha;
    private String ocupacao;
    private String rm;

    public Usuario() {
    }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getOcupacao() { return ocupacao; }

    public void setOcupacao(String ocupacao) { this.ocupacao = ocupacao; }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public void cadastrarUsuario(String nome, String email, String senha, String ocupacao, String rm){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        final Usuario u = new Usuario();

        u.setUid(UUID.randomUUID().toString());
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        u.setOcupacao(ocupacao);
        u.setRm(rm);

        db.collection("usuarios").document(email).set(u);

    }

}
