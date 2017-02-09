package androidstudy.hezijie.com.day36retrofitbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.liwushuo.com/")
                .build();
        HttpService httpService = retrofit.create(HttpService.class);
        Call<ResponseBody> call = httpService.getData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                String s = body.toString();
                Log.e("111", "onResponse: "+s );
                Log.e("111", "onResponse: "+Thread.currentThread().getName() );
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("111", "onFailure: " );
                Log.e("111", "onResponse: "+Thread.currentThread().getName() );
            }
        });

    }
}
