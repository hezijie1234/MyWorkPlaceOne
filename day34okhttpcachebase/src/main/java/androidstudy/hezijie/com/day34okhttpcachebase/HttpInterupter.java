package androidstudy.hezijie.com.day34okhttpcachebase;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hezijie on 2017/2/7.
 */
public class HttpInterupter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        Response response1 = response.newBuilder()
                .removeHeader("pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "max-age=3600")
                .build();
        return response1;
    }
}
