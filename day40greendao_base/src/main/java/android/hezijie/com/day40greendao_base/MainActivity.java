package android.hezijie.com.day40greendao_base;

import android.database.sqlite.SQLiteDatabase;
import android.hezijie.com.greendap.AndroidDaoMaster;
import android.hezijie.com.greendap.AndroidDaoSession;
import android.hezijie.com.greendap.User;
import android.hezijie.com.greendap.UserDao;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidDaoMaster.DevOpenHelper devOpenHelper = new AndroidDaoMaster.DevOpenHelper(this, "android");
        SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
        AndroidDaoMaster daoMaster = new AndroidDaoMaster(readableDatabase);
        AndroidDaoSession androidDaoSession = daoMaster.newSession();
        userDao = androidDaoSession.getUserDao();
        update();
        delete();
        query();
    }

    private void insert(){
        User user = new User();
        user.setUser_name("hezijie");
        user.setUser_age(18);
        userDao.insert(user);
    }

    private  void query(){
        List<User> users = userDao.loadAll();
        for (int i = 0; i < users.size(); i++) {
            Log.e(TAG, "query: "+users.get(i).getUser_name() );
        }
    }

    private void update(){
        userDao.update(new User(1L,"he",19));
    }
    private void delete(){
        userDao.deleteByKey(2L);
    }
}
