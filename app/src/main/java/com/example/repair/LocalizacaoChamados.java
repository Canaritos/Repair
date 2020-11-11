package com.example.repair;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LocalizacaoChamados extends AppCompatActivity {

    Button btnScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao_chamados);

        btnScan = (Button) findViewById(R.id.qrcodeLocaliza);
        final Activity activity = this;

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Câmera SCAN - Repair");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });

    }

    public void segundaEtapaChamado(View view) {
        Intent etapa = new Intent(this, DescricaoChamado.class);
        startActivity(etapa);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null){
            if (result.getContents() != null){
                alert(result.getContents());
            }else{
                alert("Scan cancelado!");
            }

        }else{
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
    private void alert (String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();

    }
}
