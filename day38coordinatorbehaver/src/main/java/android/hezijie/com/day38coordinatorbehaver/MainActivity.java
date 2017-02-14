package android.hezijie.com.day38coordinatorbehaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLickOne(View view) {
        view.setX(view.getX()+10);
    }

    public void onCLickSecond(View view) {
        view.setY(view.getY()+10);
    }
}
