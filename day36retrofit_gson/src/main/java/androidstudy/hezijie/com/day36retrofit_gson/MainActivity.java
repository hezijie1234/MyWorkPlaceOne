package androidstudy.hezijie.com.day36retrofit_gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.liwushuo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService httpService = retrofit.create(HttpService.class);
        Call<SelectionBean> call = httpService.getData();
        call.enqueue(new Callback<SelectionBean>() {
            @Override
            public void onResponse(Call<SelectionBean> call, Response<SelectionBean> response) {
                SelectionBean.DataBean data = response.body().getData();
                int size = data.getItems().size();
                Log.e("111", "onResponse: "+size );
            }

            @Override
            public void onFailure(Call<SelectionBean> call, Throwable t) {
                Log.e("111", "onFailure: " );
            }
        });


    }
}
