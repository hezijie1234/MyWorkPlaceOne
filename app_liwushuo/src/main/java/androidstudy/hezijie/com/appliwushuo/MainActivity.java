package androidstudy.hezijie.com.appliwushuo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import androidstudy.hezijie.com.appliwushuo.view.category.CategoryFragment;
import androidstudy.hezijie.com.appliwushuo.view.home.SelectionClearlyFragment;
import androidstudy.hezijie.com.appliwushuo.view.hot.HotFragment;
import androidstudy.hezijie.com.appliwushuo.view.my.OwnFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList;
    @BindView(R.id.main_rg)
    RadioGroup mRadioGroup;
    @BindView(R.id.main_guide_button)
    RadioButton guideRadioBtn;
    @BindView(R.id.main_hot_button)
    RadioButton hotRadioBtn;
    @BindView(R.id.main_category_button)
    RadioButton categoryRadioBtn;
    @BindView(R.id.main_my_button)
    RadioButton myRadioBtn;
    private CategoryFragment categoryFragment;
    private SelectionClearlyFragment selectionClearlyFragment;
    private HotFragment hotFragment;
    private OwnFragment ownFragment;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragments();
        initClick();

        listener();
    }

    private void initClick() {
        fragmentManager.beginTransaction().add(R.id.main_frame_layout,selectionClearlyFragment).commit();
        guideRadioBtn.setTextColor(Color.RED);
        guideRadioBtn.setChecked(true);
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        guideRadioBtn.setTextColor(Color.RED);
        fragmentManager = getSupportFragmentManager();
        categoryFragment = CategoryFragment.newInstance();
        selectionClearlyFragment = SelectionClearlyFragment.newInstance();
        ownFragment = OwnFragment.newInstance();
        hotFragment = HotFragment.newInstance();
        fragmentList.add(categoryFragment);
        fragmentList.add(selectionClearlyFragment);
        fragmentList.add(hotFragment);
        fragmentList.add(ownFragment);
        mCurrentFragment = selectionClearlyFragment;

    }

    private void listener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_guide_button:
                        setFragment(selectionClearlyFragment);
                        setColor();
                        guideRadioBtn.setTextColor(Color.RED);
                        break;
                    case R.id.main_hot_button:
                        setColor();
                        hotRadioBtn.setTextColor(Color.RED);
                        setFragment(hotFragment);
                        break;
                    case R.id.main_category_button:
                        setColor();
                        categoryRadioBtn.setTextColor(Color.RED);
                        setFragment(categoryFragment);
                        break;
                    case R.id.main_my_button:
                        setColor();
                        myRadioBtn.setTextColor(Color.RED);
                        setFragment(ownFragment);
                        break;
                }
            }
        });
    }

    private void setColor(){
        hotRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        categoryRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        myRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        guideRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
    }

    private void setFragment(Fragment fragment){
        if(!fragment.isAdded()){
            fragmentManager.beginTransaction().hide(mCurrentFragment).add(R.id.main_frame_layout,fragment).commit();
        }else{
            fragmentManager.beginTransaction().hide(mCurrentFragment).show(fragment).commit();
        }
        mCurrentFragment = fragment;
    }

}
