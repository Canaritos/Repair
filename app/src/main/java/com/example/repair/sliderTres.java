package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sliderTres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_tres);
    }

    public void entrar(View view) {

        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderTres.this, intent, activityOptionsCompat.toBundle());
        finish();
    }

    public void voltardois(View view) {

        Intent intent = new Intent(getBaseContext(), sliderDois.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderTres.this, intent, activityOptionsCompat.toBundle());
        finish();
    }

    public void saia(View view) {

        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderTres.this, intent, activityOptionsCompat.toBundle());
        finish();
    }
}
