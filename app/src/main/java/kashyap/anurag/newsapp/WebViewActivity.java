package kashyap.anurag.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        toolbar = findViewById(R.id.toolBar);
        webView = findViewById(R.id.webView);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        loadUrl(url);


    }

    private void loadUrl(String url) {

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}