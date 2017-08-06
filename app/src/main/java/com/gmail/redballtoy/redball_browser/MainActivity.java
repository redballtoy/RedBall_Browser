package com.gmail.redballtoy.redball_browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText enterAdress;
    String adress;
    public Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAdress = (EditText) findViewById(R.id.et_address);
        //Более копмактный код объявления кнопки
        findViewById(R.id.btn_go).setOnClickListener(this);

        myToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(myToolbar);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu, menu);
        return true;

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
            case R.id.action_exit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}


