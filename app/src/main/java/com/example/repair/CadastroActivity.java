package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class CadastroActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final Spinner spnOcupacao = findViewById(R.id.spnOcupacao);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.ocupacoes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnOcupacao.setAdapter(adapter);
    }

    public void login(View view) {

        Intent chamaLogin = new Intent(this, LoginActivity.class);
        startActivity(chamaLogin);
    }

    public void cadastrar(View view) {

        Intent etapa = new Intent(this, fragment_InicioCoordenador.class);
        startActivity(etapa);

        }
    }

