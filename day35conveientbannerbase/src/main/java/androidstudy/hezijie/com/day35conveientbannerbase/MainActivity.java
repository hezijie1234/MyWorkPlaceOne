package androidstudy.hezijie.com.day35conveientbannerbase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConvenientBanner mBanner;
    private List<Integer> localImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBanner = (ConvenientBanner) findViewById(R.id.main_convenientBanner);
        localImages.add(R.drawable.a1);
        localImages.add(R.drawable.a2);
        localImages.add(R.drawable.a3);
        localImages.add(R.drawable.a4);
        localImages.add(R.drawable.abc);
        mBanner.setPages(new CBViewHolderCreator<ImageViewHolder>() {

            @Override
            public ImageViewHolder createHolder() {
                return new ImageViewHolder();
            }
        }, localImages)
                .setPageIndicator(new int[]{R.drawable.btn_check_disabled,R.drawable.btn_check_disabled_nightmode})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    class ImageViewHolder implements Holder<Integer>{
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;

        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}
