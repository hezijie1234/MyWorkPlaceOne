package android.hezijie.com.day41instantmessage;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的
        //true是不需要验证，false是需要验证
        options.setAcceptInvitationAlways(true);

        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
}
