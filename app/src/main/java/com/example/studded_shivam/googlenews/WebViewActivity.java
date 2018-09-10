package com.example.studded_shivam.googlenews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by StudDed_SHIVAM on 20-Sep-17.
 */

public class WebViewActivity extends AppCompatActivity {
   WebView ourBrow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        String web_url=getIntent().getStringExtra("URL");

        ourBrow=(WebView)findViewById(R.id.webview);
        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.setFocusableInTouchMode(true);
        ourBrow.setFocusableInTouchMode(true);
        ourBrow.getSettings().setDatabaseEnabled(true);
        ourBrow.getSettings().setAppCacheEnabled(true);
        ourBrow.loadUrl(web_url);
        ourBrow.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (ourBrow.canGoBack())
            ourBrow.goBack();
        else
            finish();
    }
}
