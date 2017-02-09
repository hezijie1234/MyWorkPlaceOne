package androidstudy.hezijie.com.day35rxandroid_threadswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        String [] strs = new String[]{"zhang,san","li,si","wang,wu","zao,liu"};
        Observable.from(strs)
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        String[] split = s.split(",");
                        Log.e("111", "call11111: "+s+"---"+Thread.currentThread().getName() );
                        return Observable.from(split);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e("111", "call22222: "+s+"---"+Thread.currentThread().getName() );
                    }
                });
    }
}
