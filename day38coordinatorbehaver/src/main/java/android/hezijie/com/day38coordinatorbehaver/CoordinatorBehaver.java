package android.hezijie.com.day38coordinatorbehaver;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public class CoordinatorBehaver extends CoordinatorLayout.Behavior<View> {

    public CoordinatorBehaver() {
    }

    public CoordinatorBehaver(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY());
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if(dependency.getId() == R.id.first_btn){
            return true;
        }
        return false;
    }
}
