package com.example.repair;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FragsCoordActivity extends AppCompatActivity {

    private int [] mImages = new int []{
            R.drawable.aluno1, R.drawable.aluno2, R.drawable.aluno3
    };

    private String [] mImagesTitle = new String []{
            "", "", ""
    };


    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frags_prof);

        bottomNavigationView = findViewById(R.id.menu_aluno);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragInicioCoord()).commit();

//        CarouselView carouselView = findViewById(R.id.carousel);
//        carouselView.setPageCount(mImages.length);
//        carouselView.setImageListener(new ImageListener() {
//            @Override
//            public void setImageForPosition(int position, ImageView imageView) {
//                imageView.setImageResource(mImages[position]);
//            }
//        });
//
//        carouselView.setImageClickListener(new ImageClickListener() {
//            @Override
//            public void onClick(int position) {
//                Toast.makeText(getApplicationContext(), mImagesTitle[position], Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home_aluno:
                    selectedFragment = new FragInicioCoord();
                    break;
                case R.id.perfil_aluno:
                    selectedFragment = new FragPerfilCoord();
                    break;
                case R.id.add_aluno:
                    selectedFragment = new FragChamadoCoord();
                    break;
                case R.id.zap_aluno:
                    selectedFragment = new FragChatCoord();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
            return true;
        }
    };

    private String getBundle(Intent intent) {
        Bundle extras = intent.getExtras();
        return extras.getString("email");

    }

    public void segundaEtapaChamado(View view) {
        Intent etapa = new Intent(this, DescricaoChamado.class);
        startActivity(etapa);
    }

    public void ajudaCoord(View view){
        Intent i = new Intent(this, AjudaCoord.class);
        startActivity(i);
    }

    public void politicaPrivacidadeCoord(View view){
        Intent i = new Intent(this, PoliPrivCoord.class);
        startActivity(i);
    }

    public  void logoutCoord(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    public void solicitaChamadoCoord(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragChamadoCoord()).commit();
    }

    public void chamadosCoord(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragChamadosCoord()).commit();
    }
}