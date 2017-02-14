package android.hezijie.com.day38snackbar_base;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout  = (CoordinatorLayout) findViewById(R.id.activity_main);
    }

    public void onClick(View view) {
        Snackbar.make(coordinatorLayout,"hello",Snackbar.LENGTH_LONG)
                .setAction("i know", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }
}
