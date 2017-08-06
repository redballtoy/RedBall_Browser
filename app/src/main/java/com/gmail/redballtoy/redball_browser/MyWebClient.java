package com.gmail.redballtoy.redball_browser;

//обработчик веб страниц

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MyWebClient extends WebViewClient {


    public String TAG = "MyLog";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        Log.d(TAG, "мы здесь shouldOverrideUrlLoading :" + url);
        return true;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Log.e(TAG, "мы здесь: onReceivedError" + description);
    }



}
