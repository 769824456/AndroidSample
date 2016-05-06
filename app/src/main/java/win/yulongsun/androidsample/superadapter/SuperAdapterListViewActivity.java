package win.yulongsun.androidsample.superadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.ArrayList;
import java.util.List;

import win.yulongsun.androidsample.R;

public class SuperAdapterListViewActivity extends AppCompatActivity {

    private ArrayList<ItemView1> itemView1s;
    private ListView             lv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_adapter_list_view);
        lv_adapter = (ListView) findViewById(R.id.lv_adapter);
        initDatas();
        ListViewAdapter listViewAdapter = new ListViewAdapter(SuperAdapterListViewActivity.this, itemView1s, R.layout.item_lv);
        lv_adapter.setAdapter(listViewAdapter);
    }

    private void initDatas() {
        itemView1s = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ItemView1 itemView1 = new ItemView1();
            itemView1.username = "username" + i;
            itemView1.password = "password" + i;
            itemView1s.add(itemView1);
        }
    }

    class ListViewAdapter extends SuperAdapter<ItemView1> {

        public ListViewAdapter(Context context, List<ItemView1> items, int layoutResId) {
            super(context, items, layoutResId);
        }

        @Override public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ItemView1 item) {
            holder.setText(R.id.tv_item_username, item.username);
            holder.setText(R.id.tv_item_password, item.password);
        }
    }
}
