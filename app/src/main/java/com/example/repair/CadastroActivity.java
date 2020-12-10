package com.example.repair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastroActivity extends AppCompatActivity {

    EditText inputNome, inputEmail, inputSenha, inputConfirmaSenha, inputRM;
    Spinner spnOcupacao;
    FirebaseAuth auth;
    public Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(CadastroActivity.this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inputRM = findViewById(R.id.RM);

        spnOcupacao = findViewById(R.id.spnOcupacao);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.ocupacoes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnOcupacao.setAdapter(adapter);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(inputRM, smf);


    }



    public void login(View view) {

        Intent chamaLogin = new Intent(this, LoginActivity.class);
        startActivity(chamaLogin);
    }

    public void cadastrar(View view) {

        inputNome = findViewById(R.id.inputNome);
        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputSenha);
        inputConfirmaSenha = findViewById(R.id.inputConfirmaSenha);
        String nome = inputNome.getText().toString();
        String email = inputEmail.getText().toString();
        String senha = inputSenha.getText().toString();
        String ocupacao = spnOcupacao.getSelectedItem().toString();
        String rm = inputRM.getText().toString();

        if (inputSenha.getText().toString().equals(inputConfirmaSenha.getText().toString())){
            u = new Usuario();
            u.cadastrarUsuario(nome, email, senha, ocupacao, rm);
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);

        }

        else {
            Toast.makeText(this, "As senhas precisam ser iguais", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}

