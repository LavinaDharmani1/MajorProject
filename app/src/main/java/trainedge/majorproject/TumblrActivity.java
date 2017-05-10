package trainedge.majorproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class TumblrActivity extends AppCompatActivity {

    WebView wvTumblr;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumblr);
        bar=(ProgressBar) findViewById(R.id.progressBar2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wvTumblr = (WebView) findViewById(R.id.wvTumblr);
        wvTumblr.getSettings().setJavaScriptEnabled(true);
        wvTumblr.loadUrl("https://www.tumblr.com");
        wvTumblr.setWebViewClient(new TumblrCallback());
    }

    private class TumblrCallback extends WebViewClient {


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            bar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if((keyCode==KeyEvent.KEYCODE_BACK) && wvTumblr.canGoBack()){
                wvTumblr.goBack();
                return true;
            }

            return super.onKeyDown(keyCode, event);
        }
    }

