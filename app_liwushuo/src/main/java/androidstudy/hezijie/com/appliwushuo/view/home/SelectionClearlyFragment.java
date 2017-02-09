package androidstudy.hezijie.com.appliwushuo.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidstudy.hezijie.com.appliwushuo.R;

/**
 * Created by hezijie on 2017/2/8.
 */
public class SelectionClearlyFragment extends Fragment {

    public static SelectionClearlyFragment newInstance(){
        return new SelectionClearlyFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        return view;
    }
}
