package com.example.hi.androidtask2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    private AppCompatButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        if (mSettings.getBoolean(GeneralClass.Values.islogged, false))
        {
            goProfileActivity();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);

        buttonLogin = findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "";
                String password = "";
                if(inputEmail!=null){
                    email = inputEmail.getText().toString().toLowerCase();
                }
                if(inputEmail!=null){
                    password = inputPassword.getText().toString().toLowerCase();
                }

                if(email.isEmpty() || password.isEmpty()){
                    showErrorDialog();
                    inputEmail.setText("");
                    inputPassword.setText("");
                }
                else{
                    SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString(GeneralClass.Values.emailLogged, email);
                    editor.putBoolean(GeneralClass.Values.islogged, true);
                    editor.apply();

                    goProfileActivity();
                }
            }
        });

    }

    private void goProfileActivity()
    {
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void showErrorDialog(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.dialog_wrong_credential);
        dlgAlert.setTitle(R.string.dialog_auth_failed);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }




}
