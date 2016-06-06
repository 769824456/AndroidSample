package win.yulongsun.androidsample.jni;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import win.yulongsun.androidsample.R;


public class JNIActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        TextView tvJni = (TextView) findViewById(R.id.tv_jni);
        tvJni.setText(JniTest.get());
    }
}
