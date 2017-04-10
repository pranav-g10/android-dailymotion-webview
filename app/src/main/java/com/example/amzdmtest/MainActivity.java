package com.example.amzdmtest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchAndroidWebView(View view) {
        startActivity(new Intent(this, AndroidWebViewActivity.class));
    }

    public void launchAmazonWebView(View view) {
        startActivity(new Intent(this, AmazonWebViewActivity.class));
    }
}
