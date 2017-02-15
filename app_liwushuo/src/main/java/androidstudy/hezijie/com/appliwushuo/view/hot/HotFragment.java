package androidstudy.hezijie.com.appliwushuo.view.hot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidstudy.hezijie.com.appliwushuo.R;

/**
 * Created by hezijie on 2017/2/8.
 */
public class HotFragment  extends Fragment{

    public static HotFragment newInstance(){
        return new HotFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        return view;
    }
}
