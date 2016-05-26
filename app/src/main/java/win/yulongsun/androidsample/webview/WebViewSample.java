package win.yulongsun.androidsample.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import win.yulongsun.androidsample.R;

public class WebViewSample extends AppCompatActivity {

    private WebView mWv;
    private String TAG=WebViewSample.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_sample);
        mWv = (WebView) findViewById(R.id.wv);

        WebSettings settings = mWv.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        mWv.setWebViewClient(new WebViewClient(){
            @Override public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.d(TAG, "onReceivedError:"+description);
            }

            @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWv.setWebChromeClient(new WebChromeClient() {

        });
        mWv.loadUrl("http://10.0.0.179/");
    }
}
