package com.gmail.redballtoy.redballbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText enterAdress;
    String adress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAdress = (EditText) findViewById(R.id.et_address);
        //Более копмактный код объявления кнопки
        findViewById(R.id.btn_go).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        adress = "http://" + enterAdress.getText().toString();
        if (adress.equals("http://")) {

            Toast.makeText(this,
                    "Введите адрес", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent("com.gmail.redballtoy.action.show", Uri.parse(adress)));

    }


}