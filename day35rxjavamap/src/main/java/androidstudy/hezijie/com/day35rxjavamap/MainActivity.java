package androidstudy.hezijie.com.day35rxjavamap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view) {
        String[] strArr = new String[]{"1","2","3","4",};
        Observable.from(strArr)
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {

                        return Integer.parseInt(s);
                    }
                })
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer == 1 ? false :true;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.e(TAG, "call: "+integer );
                    }
                });
    }
}
