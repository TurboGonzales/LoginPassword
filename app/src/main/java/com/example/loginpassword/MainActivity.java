package com.example.loginpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText login;
    private EditText password;
    int attempts = 4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.editLogin);
        password = findViewById(R.id.editPassword);
        button = findViewById(R.id.btnLogin);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
               String loginText = login.getText().toString();
               String passwordText = password.getText().toString();
        if (loginText.equals("") && passwordText.equals("")) {
            Toast.makeText(getApplicationContext(), "АААА СВИНЬЯ!\n ТУТ ПУСТО ", Toast.LENGTH_SHORT).show();
        } else {
            if (loginText.equals("admin") && passwordText.equals("admin")) {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            } else {
                attempts--;
                Toast.makeText(getApplicationContext(), "Что-то не правильно!\n Осталось попыток: " + attempts, Toast.LENGTH_SHORT).show();
                password.setText("");
                if (attempts == 0) {
                    login.setText("");
                    login.setHint("Это БАН");
                    attempts = 3;
                }
            }
        }
    }
}