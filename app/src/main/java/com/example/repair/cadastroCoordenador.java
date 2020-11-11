package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class cadastroCoordenador extends AppCompatActivity {

    private EditText rmCoordenador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_coordenador);

        rmCoordenador= findViewById(R.id.inputRmCoordenador);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNNNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(rmCoordenador, smf);
        rmCoordenador.addTextChangedListener(mtw);
    }
}
