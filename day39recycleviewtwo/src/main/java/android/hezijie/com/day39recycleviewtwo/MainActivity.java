package android.hezijie.com.day39recycleviewtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> list = new ArrayList<>();
    private RecyclerView mRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(R.drawable.a1);
        list.add(R.drawable.a2);
        list.add(R.drawable.a3);
        list.add(R.drawable.a4);
        list.add(R.drawable.a5);
        list.add(R.drawable.a11);
        list.add(R.drawable.a22);
        list.add(R.drawable.a33);
        list.add(R.drawable.a44);
        list.add(R.drawable.a514341420201145107_200x200_3);
        list.add(R.drawable.abc);
        list.add(R.drawable.abc1);
        list.add(R.drawable.adbccc);
        mRecycle = (RecyclerView) findViewById(R.id.main_recycle_view);
        GridLayoutManager manager = new GridLayoutManager(this,2);

        MyAdapter adapter = new MyAdapter();
        mRecycle.setLayoutManager(manager);
        mRecycle.setAdapter(adapter);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.main_item_iv);
        }
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.imageView.setImageResource(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }
    }
}
