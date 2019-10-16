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

   private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
   private static final String DEFAULT_URL = "jdbc:oracle:thin:@apollo.humber.ca:1521:msit";
   private static final String DEFAULT_USERNAME = "n01263842";


   private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paramed_login);

        if(Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


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
                } else {
                    int check_valid = 0;
                    try {
                        Class.forName(DEFAULT_DRIVER);
                        connection = DriverManager.getConnection(DEFAULT_URL,DEFAULT_USERNAME,DEFAULT_PASSWORD);
                        Statement stmt = connection.createStatement();
                        String query = "SELECT PARAID,PARAPASS FROM paramedics where PARAID in '" +username+"'";
                        ResultSet rs = stmt.executeQuery(query);

                        while(rs.next()) {
                            if (rs.getString("PARAID").equals(username)) {
                                if (rs.getString("PARAPASS").equals(passwd)) {
                                    Intent intent = new Intent(paramedLogin.this, Main3Activity.class);
                                    connection.close();
                                    startActivity(intent);
                                }
                         /*  else{
                               Toast toast = Toast.makeText(paramedLogin.this, "Password is incorrect", Toast.LENGTH_LONG);
                               toast.show();
                           }
                       }
                       else{
                           Toast toast = Toast.makeText(paramedLogin.this, "Username has not been registered", Toast.LENGTH_LONG);
                           toast.show();
                       }*/
                            }
                        }
                        Toast.makeText(paramedLogin.this,"Password or username is incorrect",Toast.LENGTH_LONG).show();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }


                    /*if (conName.equals(username)) {
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
                    }*/


                }
            }
        });

    }
}
