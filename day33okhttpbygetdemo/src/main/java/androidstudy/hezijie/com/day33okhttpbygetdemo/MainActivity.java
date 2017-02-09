package androidstudy.hezijie.com.day33okhttpbygetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mOkHttpClient = new OkHttpClient.Builder().build();


    }

    public void click(View view) {
        Request request = new Request.Builder()
                .url("http://www.1688wan.com/majax.action?method=getGiftList&pageno=1")
                .get()
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"下载失败,请检查网络",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e(TAG, "onResponse: "+string);
            }
        });
    }
}
