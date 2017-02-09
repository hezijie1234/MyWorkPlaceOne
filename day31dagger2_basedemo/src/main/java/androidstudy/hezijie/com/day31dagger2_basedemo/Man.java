package androidstudy.hezijie.com.day31dagger2_basedemo;

import android.util.Log;

/**
 * Created by hezijie on 2017/2/7.
 */
public class Man implements Car {
    Human man;

    public Man(Human man) {
        this.man = man;
    }

    @Override
    public void drive() {
        man.say();
        Log.e("111", "drive: 人在开车" );
    }
}
