package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;


public class cadastroAluno extends AppCompatActivity {

    private EditText edtRm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);


        edtRm =  findViewById(R.id.inputRmAluno);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(edtRm, smf);
        edtRm.addTextChangedListener(mtw);

    }

    public void cadastro(View view) {


        Intent etapa = new Intent(this, cadastroAluno.class);
        startActivity(etapa);

    }
}
