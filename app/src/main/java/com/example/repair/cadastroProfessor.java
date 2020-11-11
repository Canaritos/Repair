package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class cadastroProfessor extends AppCompatActivity {

    private EditText rmProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        rmProfessor = findViewById(R.id.inputRmAluno);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(rmProfessor, smf);
       // rmProfessor.addTextChangedListener(mtw);

    }

    public void cadastro(View view) {

        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }
}
