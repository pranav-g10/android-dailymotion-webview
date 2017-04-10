package com.example.amzdmtest;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class AndroidWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        webView.loadUrl("http://www.dailymotion.com/embed/video/x2o99yz" +
                "?app=tv.accedo.airtel.wynk" +
                "&api=location" +
                "&controls=0" +
                "&endscreen-enable=0" +
                "&autoplay=1");
    }
}
