package win.yulongsun.androidsample.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import win.yulongsun.androidsample.R;


//在子线程中发送消息，在主线程中接受消息
public class Handler1Activity extends AppCompatActivity {


    private TextView tv_main_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler1);
        tv_main_msg = (TextView) findViewById(R.id.tv_main_msg);

    }

    private Handler mHandler = new Handler() {
        @Override public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_main_msg.setText((String) msg.obj);

        }
    };


    /*子线程发送消息*/
    public void sendMsg(View view) {
        new ChildThread().start();
    }

    class ChildThread extends Thread {
        @Override public void run() {
            super.run();
            Message message = new Message();
            message.what = 1;
            message.obj = "你好，我是子线程";
            mHandler.sendMessage(message);
        }
    }
}
