package com.gmail.redballtoy.redball_browser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class web extends AppCompatActivity {

    WebView showWeb;
    public String TAG = "MyLog";

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

