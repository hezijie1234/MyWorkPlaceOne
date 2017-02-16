package android.hezijie.com.day40shoppingcart;

import android.database.sqlite.SQLiteDatabase;
import android.hezijie.com.cart.CartDaoMaster;
import android.hezijie.com.cart.CartDaoSession;
import android.hezijie.com.cart.Product;
import android.hezijie.com.cart.ProductDao;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView viewById;
    private ProductDao productDao;
    private List<Product> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = (ListView) findViewById(R.id.main_lv);
        CartDaoMaster.DevOpenHelper devOpenHelper = new CartDaoMaster.DevOpenHelper(this,"android");
        SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
        CartDaoMaster cartDaoMaster = new CartDaoMaster(readableDatabase);
        CartDaoSession cartDaoSession = cartDaoMaster.newSession();
        productDao = cartDaoSession.getProductDao();
        initDatas();
        initViews();
    }

    private void initViews() {
        viewById.setAdapter(new MyAdapter());
    }

    private void initDatas() {
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Product product = new Product();
            product.setProductName("美女"+i);
            product.setProductPrice(100);
            product.setProductNum(0L);
            mList.add(product);
            productDao.insert(product);
        }
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.mian_item,parent,false);
                holder = new ViewHolder(convertView);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.numTxt.setText(mList.get(position).getProductNum()+"");
            holder.nameTxt.setText(mList.get(position).getProductName());
            holder.minusTxt.setTag(position);
            holder.plusTxt.setTag(position);
            return convertView;
        }

        class ViewHolder {
            TextView nameTxt;
            TextView plusTxt;
            TextView numTxt;
            TextView minusTxt;
            public ViewHolder(View view){
               view.setTag(this);
                nameTxt = (TextView) view.findViewById(R.id.main_item_tv);
                plusTxt = (TextView) view.findViewById(R.id.main_item_plus);
                numTxt = (TextView) view.findViewById(R.id.main_item_num);
                minusTxt = (TextView) view.findViewById(R.id.main_item_minus);
                minusTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v.getId() == R.id.main_item_minus){
                            int position = Integer.parseInt(v.getTag().toString());
                            Product product = mList.get(position);
                            long proNum = product.getProductNum();
                            proNum--;
                            product.setProductNum(proNum);
                            numTxt.setText(proNum+"");
                            productDao.update(product);
                        }
                    }
                });
                plusTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v.getId() == R.id.main_item_plus){
                            int position = Integer.parseInt(v.getTag().toString());
                            Product product = mList.get(position);
                            long proNum = product.getProductNum();
                            proNum++;
                            product.setProductNum(proNum);
                            numTxt.setText(proNum+"");
                            productDao.update(product);
                        }
                    }
                });
            }

        }
    }
}
