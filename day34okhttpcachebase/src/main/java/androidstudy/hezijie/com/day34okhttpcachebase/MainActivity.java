package androidstudy.hezijie.com.day34okhttpcachebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";
    private static final String URL_PATH = "http://api.liwushuo.com/v2/item_categories/tree";
    private OkHttpClient mHttpClient;
    private File mCacheDir;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.activity_main_text);
        HttpInterupter httpInterupter = new HttpInterupter();
        mCacheDir = getCacheDir();
        Cache cache = new Cache(mCacheDir, 4 * 1024 * 1024);
        mHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(httpInterupter)
                .cache(cache)
                .build();
    }

    public void click(View view) {
        Request request = new Request.Builder()
                .url(URL_PATH)
                .cacheControl(new CacheControl.Builder().maxAge(3600, TimeUnit.SECONDS).build())
                .build();
        Call call = mHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e(TAG, "onResponse: "+string );
            }
        });

    }
}
