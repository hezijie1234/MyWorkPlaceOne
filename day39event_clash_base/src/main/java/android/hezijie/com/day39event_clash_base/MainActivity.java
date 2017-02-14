package android.hezijie.com.day39event_clash_base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MainActivity onTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MainActivity onTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MainActivity dispatchTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MainActivity dispatchTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


}
