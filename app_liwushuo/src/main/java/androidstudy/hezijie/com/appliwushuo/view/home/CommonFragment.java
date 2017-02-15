package androidstudy.hezijie.com.appliwushuo.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidstudy.hezijie.com.appliwushuo.R;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class CommonFragment extends Fragment {
    private Context context;
    public static final String  FRAGMENT_TYPE = "TYPE";
    private String type;

    public static CommonFragment newInstance(String type){
        CommonFragment fragment = new CommonFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TYPE,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        type =  bundle.getString(FRAGMENT_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        return view;
    }
}
