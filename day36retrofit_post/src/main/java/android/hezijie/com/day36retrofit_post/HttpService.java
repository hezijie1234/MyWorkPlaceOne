package android.hezijie.com.day36retrofit_post;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public interface HttpService {
    @FormUrlEncoded
    @POST("/majax.action?method=getGiftList")
    Call<ResponseBody> getData(@Field("pageno")int num);
}
