package androidstudy.hezijie.com.appliwushuo.presenter.home;

import androidstudy.hezijie.com.appliwushuo.model.home.bean.SelectBean;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public interface IHomePresenter {

    void querySelectData(int pageno);

    public interface IHomePresenterCallBack{
        void getSelectData(SelectBean selectBean);
    }
}
