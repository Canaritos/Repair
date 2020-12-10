package com.example.repair;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authListener;
    private static FirebaseUser firebaseUser;

    private Conexao(){}

    public static FirebaseAuth getFirebaseAuth(){
        if(firebaseAuth == null){
            startFirebaseAuth();
        }
        return firebaseAuth;
    }

    private static void startFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user == null){
                    firebaseUser = user;
                }
            }
        };
        firebaseAuth.addAuthStateListener(authListener);
    }

    public static FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }

    public static void logOut(){
        firebaseAuth.signOut();
    }
}
