package android.hezijie.com.day38qq_listviewdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class SpecificListView extends ListView{
    public SpecificListView(Context context) {
        super(context);
    }

    public SpecificListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpecificListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(ev);
    }
}
