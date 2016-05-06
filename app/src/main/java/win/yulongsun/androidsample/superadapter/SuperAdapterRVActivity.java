package win.yulongsun.androidsample.superadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.ArrayList;
import java.util.List;

import win.yulongsun.androidsample.R;

public class SuperAdapterRVActivity extends AppCompatActivity {

    private RecyclerView         rv;
    private ArrayList<ItemView1> itemView1s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_adapter_rv);
        rv = (RecyclerView) findViewById(R.id.rv);
        initDatas();
        ListViewAdapter listViewAdapter = new ListViewAdapter(SuperAdapterRVActivity.this, itemView1s, R.layout.item_lv);
        rv.setLayoutManager(new LinearLayoutManager(SuperAdapterRVActivity.this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(listViewAdapter);
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
