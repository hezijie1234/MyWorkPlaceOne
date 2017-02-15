package androidstudy.hezijie.com.appliwushuo.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Selection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidstudy.hezijie.com.appliwushuo.MainActivity;
import androidstudy.hezijie.com.appliwushuo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hezijie on 2017/2/8.
 */
public class SelectionClearlyFragment extends Fragment {
    private static final String TAG = "111";
    private List<Fragment> mFragmentList;
    private String[] pageTitles = {"精选","送女票","海涛","创意生活","送基友","科技范"};
    private Context context;
    @BindView(R.id.fragment_select_tl)
    TabLayout mTabLayout;
    @BindView(R.id.fragment_select_vp)
    ViewPager mViewPager;

    private static FragmentManager fragmentManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
        fragmentManager = getChildFragmentManager();

    }

    public static SelectionClearlyFragment newInstance(){
        return new SelectionClearlyFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_clearly, container, false);
        ButterKnife.bind(this,view);
        initTabs();
        Log.e(TAG, "onCreateView: " );
        return view;
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(CommonFragment.newInstance("1"));
        mFragmentList.add(CommonFragment.newInstance("2"));
        mFragmentList.add(CommonFragment.newInstance("3"));
        mFragmentList.add(CommonFragment.newInstance("4"));
        mFragmentList.add(CommonFragment.newInstance("5"));
        mFragmentList.add(CommonFragment.newInstance("6"));
    }

    private void initTabs() {
        TabFragmentAdapter adapter = new TabFragmentAdapter(fragmentManager);
        mViewPager.setAdapter(adapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class TabFragmentAdapter extends FragmentPagerAdapter{

        public TabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            Log.e(TAG, "getCount: "+mFragmentList.size() );
            return mFragmentList == null ? 0 : mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position];
        }
    }
}
