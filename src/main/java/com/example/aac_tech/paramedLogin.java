package com.example.aac_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class paramedLogin extends AppCompatActivity {


   private final String conName = "n01263842";
   private final String conPass = "Akeem123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paramed_login);


        Button signin = (Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText uname = (EditText) findViewById(R.id.uname);
                EditText passwd = (EditText) findViewById(R.id.passwd);

                String username = uname.getText().toString();
                String password = passwd.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast toast = Toast.makeText(paramedLogin.this, "All fields are required", Toast.LENGTH_LONG);
                    toast.show();
                }


                    if (conName.equals(username)) {
                        if (conPass.equals("Akeem123")) {
                            Intent intent = new Intent(paramedLogin.this, Main3Activity.class);
                            startActivity(intent);
                        } else {
                            Toast toast = Toast.makeText(paramedLogin.this, "Password is incorrect", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    } else {
                        Toast toast = Toast.makeText(paramedLogin.this, "Username has not been registered", Toast.LENGTH_LONG);
                        toast.show();
                    }



            }
        });

    }
}
