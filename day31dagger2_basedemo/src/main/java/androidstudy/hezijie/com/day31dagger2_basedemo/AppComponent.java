package androidstudy.hezijie.com.day31dagger2_basedemo;

import dagger.Component;

/**
 * Created by hezijie on 2017/2/7.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
