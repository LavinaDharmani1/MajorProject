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

public class BadooActivity extends AppCompatActivity {

    ProgressBar bar;
    WebView wvBadoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badoo);
        bar =(ProgressBar) findViewById(R.id.progressBar2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wvBadoo = (WebView) findViewById(R.id.wvBadoo);
        wvBadoo.getSettings().setJavaScriptEnabled(true);
        wvBadoo.setWebViewClient(new BadooCallback());
        wvBadoo.loadUrl("https://m.badoo.com");
    }
    public class BadooCallback extends WebViewClient {

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
        if((keyCode==KeyEvent.KEYCODE_BACK) && wvBadoo.canGoBack()){
            wvBadoo.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
