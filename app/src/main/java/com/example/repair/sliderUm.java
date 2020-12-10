package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
public class sliderUm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_um);
    }

    public void dois(View view) {

        Intent intent = new Intent(getBaseContext(), sliderDois.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_esquerda);
        ActivityCompat.startActivity(sliderUm.this, intent, activityOptionsCompat.toBundle());
        finish();
    }

    public void irlogin(View view) {

        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.mover_direita);
        ActivityCompat.startActivity(sliderUm.this, intent, activityOptionsCompat.toBundle());
        finish();
    }
}
