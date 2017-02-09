package androidstudy.hezijie.com.day35rxjavaloop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "111";
    private String[] strs = {"a,a","bb","cc","dd","ee"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Observable.from(strs)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return "bb" == s ? false : true;
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(TAG, "call: "+s );
                    }
                });

    }
}
