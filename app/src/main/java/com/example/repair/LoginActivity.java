package com.example.repair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogin;
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializaComponentes();
        eventoClicks();
    }

    public void cadastro(View view) {
        Intent chamaCadastro = new Intent(this, CadastroActivity.class);
        startActivity(chamaCadastro);
    }
    private void inicializaComponentes(){
        edtEmail = findViewById(R.id.inputEmailLogin);
        edtSenha = findViewById(R.id.inputSenhaLogin);
        btnLogin = findViewById(R.id.btnLogin);
        db = FirebaseFirestore.getInstance();

    }
    private void eventoClicks(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                login(email, senha);
            }
        });
    }

    private void login(final String email, final String senha) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("usuarios").document(email);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists()) {
                    Usuario u = documentSnapshot.toObject(Usuario.class);
                    if (u.getSenha().equals(senha)) {
                        if(u.getOcupacao().equals("Aluno")){
                            Bundle b = new Bundle();
                            b.putString("email", email);
                            Intent i = new Intent(getApplicationContext(), FragsAluActivity.class);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }else if(u.getOcupacao().equals("Professor(a)")){
                            Bundle b = new Bundle();
                            b.putString("email", email);
                            Intent i = new Intent(getApplicationContext(), FragsProfActivity.class);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }else{
                            Bundle b = new Bundle();
                            b.putString("email", email);
                            Intent i = new Intent(getApplicationContext(), FragsCoordActivity.class);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
