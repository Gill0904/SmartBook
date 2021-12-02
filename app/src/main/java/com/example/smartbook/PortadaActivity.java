package com.example.smartbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class PortadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        //Instanciamos nuestras animaciones de la carpeta /anim
        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.right_in);
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.down_in);
        Animation animacion3= AnimationUtils.loadAnimation(this,R.anim.left_in);
        Animation animacion4= AnimationUtils.loadAnimation(this,R.anim.up_in);

        //Instanciamos nuestros componesntes de la vista y les asignamos una animación
        ImageView imageView= findViewById(R.id.imageBook);
        imageView.setAnimation(animacion1);
        View separador= findViewById(R.id.separador);
        separador.setAnimation(animacion2);
        TextView sbShort= findViewById(R.id.textSBShort);
        sbShort.setAnimation(animacion3);
        TextView SB= findViewById(R.id.textSB);
        SB.setAnimation(animacion4);

        //Después de las animaciones iniciamos nuestro Activity main
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PortadaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}