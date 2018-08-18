package com.example.furkan.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//shared örnek
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.furkan.storingdata", Context.MODE_PRIVATE);

        int age = 30;
        //sharedPreferences.edit().putInt("userAge",age).apply();

        int savedAge = sharedPreferences.getInt("userAge",0);

        System.out.println("Kaydedilmiş yaş: "+savedAge);

        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long mil) {
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(mil/1000+"");
            }

            @Override
            public void onFinish() {
                TextView textView = (TextView)findViewById(R.id.textView);
                TextView textView1 = (TextView)findViewById(R.id.textView2);
                textView.setText("0");
                textView1.setText("The Away Days - Layers");
                MediaPlayer cal= MediaPlayer.create(MainActivity.this,R.raw.theaways);
                cal.start();
               Toast toast = Toast.makeText(getApplicationContext(),"Müzik başladı...",Toast.LENGTH_SHORT);
               toast.show();
            }
        }.start();

    }
}
