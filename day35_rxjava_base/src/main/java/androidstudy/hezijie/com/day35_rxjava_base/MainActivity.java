package androidstudy.hezijie.com.day35_rxjava_base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.Observers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Observer<String> observer = new Observer<String>() {
            /**
             *
             */
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: "+s );
            }
        };

        Observable.OnSubscribe<String> subscribe = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onCompleted();
            }
        };
        Observable<String> stringObservable = Observable.create(subscribe);
        stringObservable.subscribe(observer);

    }
}
