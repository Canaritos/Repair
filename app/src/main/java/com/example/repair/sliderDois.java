package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sliderDois extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_dois);
    }

    public void tres(View view) {
        Intent intent = new Intent(getBaseContext(), sliderTres.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_esquerda);
        ActivityCompat.startActivity(sliderDois.this, intent, activityOptionsCompat.toBundle());
        finish();
    }

    public void voltaum(View view) {

        Intent intent = new Intent(getBaseContext(), sliderUm.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderDois.this, intent, activityOptionsCompat.toBundle());
        finish();
    }

    public void exit(View view) {


        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderDois.this, intent, activityOptionsCompat.toBundle());
        finish();
    }
}
