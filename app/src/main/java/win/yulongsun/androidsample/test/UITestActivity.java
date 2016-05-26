package win.yulongsun.androidsample.test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

import win.yulongsun.androidsample.R;

public class UITestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);
    }

    public void sayHello(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        textView.setText("Hello, " + editText.getText().toString() + "!");
    }
}
