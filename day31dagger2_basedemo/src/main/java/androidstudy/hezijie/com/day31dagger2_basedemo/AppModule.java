package androidstudy.hezijie.com.day31dagger2_basedemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hezijie on 2017/2/7.
 */
@Module
public class AppModule {
    @Provides
    public Human provideHuman(){
        return new Human();
    }
    @Provides
    public Car provideCar(Human human){
        return new Man(human);
    }
}
