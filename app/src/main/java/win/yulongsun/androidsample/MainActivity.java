package win.yulongsun.androidsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import win.yulongsun.androidsample.handler.Handler1Activity;
import win.yulongsun.androidsample.handler.Handler2Activity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        init();
    }

    public void init() {
        String[]             str     = {"handler1", "handler2"};
        List<String>         mDatas  = Arrays.asList(str);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mDatas);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }


    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, Handler1Activity.class);
                break;
            case 1:
                intent = new Intent(this, Handler2Activity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
