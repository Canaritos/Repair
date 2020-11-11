package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjudaUsuario extends AppCompatActivity {

    private EditText etPara;
    private EditText etAssunto;
    private EditText etMensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda_usuario);

        etPara = findViewById(R.id.et_para);
        etAssunto = findViewById(R.id.et_assunto);
        etMensagem = findViewById(R.id.et_mensagem);

        Button btnSend = findViewById(R.id.btnsend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
                etAssunto.setText("");
                etMensagem.setText("");

            }

        });
    }
    private void sendMail(){
        String recipientList =  etPara.getText().toString();
        String [] recipients = recipientList.split(",");

        String assunto = etAssunto.getText().toString();
        String mensagem = etMensagem.getText().toString();

        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensagem);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Nos envie um E-mail"));



    }

    public void voltaPerfil(View view) {
        Intent etapa = new Intent(this, fragment_perfil.class);
        startActivity(etapa);
    }
}
