package trainedge.majorproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InstagramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView wvInstagram = (WebView) findViewById(R.id.wvInstagram);
        wvInstagram.getSettings().setJavaScriptEnabled(true);
        wvInstagram.setWebViewClient(new InstagramCallback());
        wvInstagram.loadUrl("https://www.instagram.com");
    }
    public class InstagramCallback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
        }
}
