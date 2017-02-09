package androidstudy.hezijie.com.day31dagger2_basedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
     Human human;
    @Inject
    Car man;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerAppComponent.create().inject(this);
        human.say();
        man.drive();
    }
}
