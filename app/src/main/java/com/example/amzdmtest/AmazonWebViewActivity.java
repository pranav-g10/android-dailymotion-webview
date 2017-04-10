package com.example.amzdmtest;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amazon.android.webkit.AmazonWebKitFactories;
import com.amazon.android.webkit.AmazonWebKitFactory;
import com.amazon.android.webkit.AmazonWebView;

public class AmazonWebViewActivity extends AppCompatActivity {

    private static boolean sFactoryInit = false;
    private AmazonWebKitFactory factory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!sFactoryInit) {
            factory = AmazonWebKitFactories.getDefaultFactory();
            if (factory.isRenderProcess(this)) {
                return; // Do nothing if this is on render process
            }
            factory.initialize(this.getApplicationContext());
            // factory configuration is done here, for example:
            factory.getCookieManager().setAcceptCookie(true);
            sFactoryInit = true;
        } else {
            factory = AmazonWebKitFactories.getDefaultFactory();
        }

        setContentView(R.layout.activity_amazon);
        AmazonWebView webView = (AmazonWebView) findViewById(R.id.web_view);
        factory.initializeWebView(webView, 0xFFFFFF, false, null);
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
