package com.example.repair;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TesteNome extends AppCompatActivity {

    TextView txvNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_nome);

        String email = getBundle(getIntent());

        txvNome = findViewById(R.id.txvNome);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("usuarios").document(email);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {
                    Usuario u = documentSnapshot.toObject(Usuario.class);

                    txvNome.setText(u.getNome());
                }
            }
        });
    }

    private String getBundle(Intent intent) {
        Bundle extras = intent.getExtras();
        return extras.getString("email");

    }

}