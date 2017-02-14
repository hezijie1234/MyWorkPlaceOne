package android.hezijie.com.day39event_clash_base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class MyButto extends Button {


    private static final String TAG = "111";

    public MyButto(Context context) {
        this(context,null);
    }

    public MyButto(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyButto onTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyButto onTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyButto dispatchTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyButto dispatchTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
