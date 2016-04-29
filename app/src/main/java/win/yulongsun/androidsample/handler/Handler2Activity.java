package win.yulongsun.androidsample.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import win.yulongsun.androidsample.R;

public class Handler2Activity extends AppCompatActivity {

    private static final String TAG = Handler2Activity.class.getSimpleName();
    private Handler  mHandler1;
    private TextView tv_msg_to_main;
    private Thread2  thread2;
    private TextView tv_msg_to_child;
    private Thread1  thread1;
    private Handler  mHandler4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler2);
        tv_msg_to_main = (TextView) findViewById(R.id.tv_msg_to_main);
        tv_msg_to_child = (TextView) findViewById(R.id.tv_msg_to_child);

        thread1 = new Thread1();
        thread2 = new Thread2();
        thread2.start();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 1.主线程向子线程发消息
    ///////////////////////////////////////////////////////////////////////////

    private int count = 0;

    public void sendMsgToChildThread(View view) {
//        Message message = new Message();
//        message.obj = "我是主线程消息" + count;
//        count++;
//        mHandler1.sendMessage(message);
        thread1.start();
    }


    //Handler不传给他Looper的话他默认使用当前线程的Looper.myLoop();
    class Thread1 extends Thread {
        @Override public void run() {
            super.run();
            //一定要加下面两句
//            Looper.prepare();
//            mHandler1 = new Handler(Looper.myLooper()) {
//                @Override public void handleMessage(Message msg) {
//                    super.handleMessage(msg);
//                    Log.d(TAG, "handleMessage: " + msg.obj + ",thread:" + currentThread().getName());
////                    tv_msg_to_child.setText((String) msg.obj);
//                    Toast.makeText(Handler2Activity.this, "handleMessage: " + msg.obj, Toast.LENGTH_SHORT).show();
//                }
//            };
//            Looper.loop();


            Looper.prepare();
            //不加Looper.prepare()会爆一下错： java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()
            Toast.makeText(Handler2Activity.this, "handleMessage: ", Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    // 总结：
    //
    // 场景：
    // 1。在子线程中不能更新UI，但是可以弹出土司
    //  解释：
    //      Toast内部有new了一个Handler,没有给Looper。但是Looper默认构造方法中没有指定线程的话，直接用的是当前线程的Looper
    //      所以，show土司的时候post内容到ui了，所以能更新ui
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // 2.子线程向主线程发送消息
    ///////////////////////////////////////////////////////////////////////////

    private Handler mHandler2 = new Handler(Looper.getMainLooper()) {
        @Override public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_msg_to_main.setText((String) msg.obj);
        }
    };

    public void sendMsgToMainThread(View view) {

        thread2.run();
    }

    class Thread2 extends Thread {
        int count = 0;

        @Override public void run() {
            super.run();
            Log.d(TAG, "run: " + currentThread().getName());
            Message msg2 = Message.obtain(mHandler2);
            msg2.obj = "子线程2发送的消息：" + count;
            count++;
            mHandler2.sendMessage(msg2);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //3.子线程3向子线程4发消息
    ///////////////////////////////////////////////////////////////////////////
    class Thread3 extends Thread {
        @Override public void run() {
            super.run();
            Message msg4 = Message.obtain(mHandler4);
            msg4.obj = "Thread3的发送消息";
            mHandler4.sendMessage(msg4);
        }
    }

    class Thread4 extends Thread {
        @Override public void run() {
            super.run();
            Looper.prepare();
            mHandler4 = new Handler(Looper.myLooper()) {
                @Override public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Log.d(TAG, "Thread4 handleMessage: " + msg.obj);
                }
            };
            Looper.loop();
        }
    }


    public void sendMsgFromThread3ToThread4(View v) {
        new Thread4().start();
        new Thread3().start();
    }
}
