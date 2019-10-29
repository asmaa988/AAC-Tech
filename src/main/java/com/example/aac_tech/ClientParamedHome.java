package com.example.aac_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Team-Name: AAC-Tech

 */
public class ClientParamedHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button paramedic = (Button)findViewById(R.id.homescreenB1);
        Button client = (Button)findViewById(R.id.homescreenB2);


        paramedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientParamedHome.this,paramedLogin.class);
                startActivity(intent);


            }
        });

        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientParamedHome.this,client_Activity.class);
                startActivity(intent);
            }
        });
    }
}
