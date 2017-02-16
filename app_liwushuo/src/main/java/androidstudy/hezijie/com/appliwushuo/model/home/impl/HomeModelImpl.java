package androidstudy.hezijie.com.appliwushuo.model.home.impl;

import com.google.gson.Gson;

import androidstudy.hezijie.com.appliwushuo.model.home.IhomeModel;
import androidstudy.hezijie.com.appliwushuo.model.home.bean.SelectBean;
import androidstudy.hezijie.com.appliwushuo.utils.Constants;
import androidstudy.hezijie.com.okhttp_tool.OkHttpTools;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class HomeModelImpl implements IhomeModel {


    @Override
    public void querySelectData(int pageno, final IHomeModelCallBack callBack) {
        OkHttpTools.Builder().url(Constants.SELECTION_URL).get().callBack(new OkHttpTools.OkHttpCallBack() {
            @Override
            public void getData(String data) {
                Gson gson = new Gson();
                SelectBean selectBean = gson.fromJson(data, SelectBean.class);
                callBack.getSelectData(selectBean);
            }
        });
    }

}
