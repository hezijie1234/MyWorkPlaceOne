package androidstudy.hezijie.com.appliwushuo.model.home;

import androidstudy.hezijie.com.appliwushuo.model.home.bean.SelectBean;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public interface IhomeModel {

    void querySelectData(int pageno,IHomeModelCallBack callBack);

    public interface IHomeModelCallBack{
       void getSelectData(SelectBean selectBean );
    }
}
