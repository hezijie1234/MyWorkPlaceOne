package androidstudy.hezijie.com.day33_okhttp_post;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient mHttpClient;
    TextView mTextView;
    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mHttpClient = new OkHttpClient.Builder().build();
        mTextView = (TextView) findViewById(R.id.activity_main_text);
        handler = new MyHandler(this);
    }

    public void click(View view) {
        postByJson();
    }

    private void postByJson(){
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType,"{name:hezijie,age:18}");
        Request request = new Request.Builder()
                .url("http://192.168.53.13:8080/OneServert/MyServlet")
                .post(body)
                .build();
        Call call = mHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = handler.obtainMessage();
                message.obj = string;
                handler.sendMessage(message);
            }
        });
    }

    private void postByForm(){
        FormBody formBody = new FormBody.Builder()
                .add("name","hezijie")
                .add("age","18")
                .build();
        Request request = new Request.Builder()
                .url("http://www.1688wan.com/majax.action?method=getGiftList")
                .post(formBody)
                .build();
        Call call = mHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = handler.obtainMessage();
                message.obj = string;
                handler.sendMessage(message);
            }
        });
    }

    static class MyHandler extends Handler{
        private WeakReference<MainActivity> activity;

        public MyHandler(MainActivity activity){
            this.activity = new WeakReference<MainActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity = activity.get();
            try{
                if(null != mainActivity){
                    mainActivity.mTextView.setText(msg.obj.toString());
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }

        }
    }
}
