package android.hezijie.com.day39event_clash_base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class MyLinearLayout extends LinearLayout {
    private static final String TAG = "111";

    public MyLinearLayout(Context context) {
        this(context,null);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyLinearLayout onInterceptTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyLinearLayout onInterceptTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyLinearLayout onTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyLinearLayout onTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyLinearLayout dispatchTouchEvent:ACTION_UP ");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyLinearLayout dispatchTouchEvent: ACTION_DOWN" );
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
