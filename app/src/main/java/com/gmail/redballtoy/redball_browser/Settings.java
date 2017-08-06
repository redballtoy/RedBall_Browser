package com.gmail.redballtoy.redball_browser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Settings extends AppCompatActivity {

    boolean JSenableSett = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(myToolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO save settings
        finish();

        return super.onOptionsItemSelected(item);
    }
}
