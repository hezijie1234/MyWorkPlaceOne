package androidstudy.hezijie.com.day34okhttp_testtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidstudy.hezijie.com.okhttp_tool.OkHttpTools;

public class MainActivity extends AppCompatActivity {

    private static final String URL_PATH = "http://api.liwushuo.com/v2/search/item_by_type?limit=20&offset=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpTools.Builder().url(URL_PATH).get().callBack(new OkHttpTools.OkHttpCallBack() {
            @Override
            public void getData(String data) {
                Log.e("111", "getData: "+data );
            }
        });
    }
}
