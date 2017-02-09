package androidstudy.hezijie.com.day36retrofit_gson;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hezijie on 2017/2/9.
 */

public interface HttpService {
    @GET("v2/channels/101/items?ad=2&gender=1&generation=2&limit=20&offset=0")
    Call<SelectionBean> getData();
}
