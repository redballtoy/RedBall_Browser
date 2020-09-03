package com.gmail.redballtoy.redballbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class web extends AppCompatActivity {

    final int MENU_ID_RELOAD = 1;
    final int MENU_ID_BACK = 2;
    final int MENU_ID_SETTINGS = 3;
    final int MENU_ID_QUIT = 4;

    WebView showWeb;
    public String TAG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        showWeb = (WebView) findViewById(R.id.wv_show_web);
        showWeb.setWebViewClient(new MyWebClient());
        //включить поддержку JavaScript
        showWeb.getSettings().setJavaScriptEnabled(true);
        Uri data = getIntent().getData();
        Log.d(TAG, "Web class " + data.toString());
        showWeb.loadUrl(data.toString());
    }

    @Override
    public void onBackPressed() {
        if (showWeb.canGoBack()) {
            showWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_ID_BACK, 0, "Back");
        menu.add(0, MENU_ID_RELOAD, 0, "Reload");
        menu.add(0, MENU_ID_SETTINGS, 0, "Settings");
        menu.add(0, MENU_ID_QUIT, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ID_RELOAD:
                showWeb.reload();
                break;
            case MENU_ID_BACK:
                if (showWeb.canGoBack()) {
                    showWeb.goBack();
                } else {
                    finish();
                }
                break;
            case MENU_ID_SETTINGS:
                startActivity(new Intent(this, Settings.class));
                showWeb.reload();
                break;
            case MENU_ID_QUIT:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

