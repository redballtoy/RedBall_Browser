package com.gmail.redballtoy.redball_browser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView showWeb;
    public String TAG = "MyLog";
    public final String SAVED_URL = "saved URL";
    private boolean saveUrl = false;
    SharedPreferences sPref;
    Uri data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(myToolbar);

        showWeb = (WebView) findViewById(R.id.wv_show_web);
        showWeb.setWebViewClient(new MyWebClient());
        //включить поддержку JavaScript
        showWeb.getSettings().setJavaScriptEnabled(true);
        Log.d(TAG, "savedUrl=" + saveUrl);
        if (restoreUrl().equals("")) {//страница не была сохранена
            data = getIntent().getData();
            showWeb.loadUrl(data.toString());
            Log.d(TAG, "Первоначальная загрузка");
        } else {
            showWeb.loadUrl(restoreUrl());
            Log.d(TAG, "Восстановление страницы" + restoreUrl());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveUrl();

    }


    private void saveUrl() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        //ed.putString(SAVED_URL, showWeb.getOriginalUrl());
        ed.putString(SAVED_URL, showWeb.getUrl());
        ed.commit();
        //URL сохранен
        Log.d(TAG, "URL сохранен=" + SAVED_URL);
    }

    private String restoreUrl() {
        sPref= getPreferences(MODE_PRIVATE);
        return sPref.getString(SAVED_URL, "");
    }
    public void delUrl() {
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_URL, "");
        ed.commit();
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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reload:
                showWeb.reload();
                break;
            case R.id.action_back:
                if (showWeb.canGoBack()) {
                    showWeb.goBack();
                } else {
                    finish();
                }
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, Settings.class));
                showWeb.reload();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

