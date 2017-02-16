package androidstudy.hezijie.com.appliwushuo.presenter.home.impl;

import androidstudy.hezijie.com.appliwushuo.model.home.IhomeModel;
import androidstudy.hezijie.com.appliwushuo.model.home.bean.SelectBean;
import androidstudy.hezijie.com.appliwushuo.model.home.impl.HomeModelImpl;
import androidstudy.hezijie.com.appliwushuo.presenter.home.IHomePresenter;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class HomePresenter implements IHomePresenter,IhomeModel.IHomeModelCallBack {
    private IhomeModel ihomeModel;
    private IHomePresenterCallBack presenterCallBack;

    public HomePresenter(IHomePresenterCallBack presenterCallBack){
        ihomeModel = new HomeModelImpl();
        this.presenterCallBack = presenterCallBack;
    }
    @Override
    public void querySelectData(int pageno) {
        ihomeModel.querySelectData(pageno,this);
    }

    @Override
    public void getSelectData(SelectBean selectBean) {
        presenterCallBack.getSelectData(selectBean);
    }
}
