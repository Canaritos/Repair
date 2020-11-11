package com.example.repair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class fragment_InicioCoordenador extends AppCompatActivity {

    private int [] mImages = new int []{
            R.drawable.qrcode, R.drawable.profile, R.drawable.img, R.drawable.noti,
            R.drawable.didi

    };

    private String [] mImagesTitle = new String []{
            "Beatriz", "Camila", "Emily", "Davi", "Gustavo"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_iniciocoordenador);

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);


            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(fragment_InicioCoordenador.this, mImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
