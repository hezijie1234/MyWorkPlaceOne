package androidstudy.hezijie.com.day33_uploadimage_post;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 111;
    private ImageView imageView;
    private OkHttpClient mHttpClient;
    private byte[] mBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.activity_main_iv);
        mHttpClient = new OkHttpClient.Builder().build();
    }

    public void click(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setAction("image/*");
        startActivityForResult(intent,REQUEST_CODE);
        if(mBytes != null){
            MediaType mediaType = MediaType.parse("image/*");
            RequestBody body = RequestBody.create(mediaType,mBytes);
            MultipartBody multipartBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file","onepicture",body)
                    .build();

            Request request = new Request.Builder()
                    .url("http://192.168.53.13:8080/androidxx/upload.do")
                    .post(multipartBody)
                    .build();
            Call call = mHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("111", "onResponse: "+"onFailure" );
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(response.code() == 200){
                        Log.e("111", "onResponse: "+"success" );
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE:
                Uri data1 = data.getData();
                InputStream inputStream = null;
                try {
                    inputStream = getContentResolver().openInputStream(data1);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte [] buffer = new byte[1024];
                    int len = 0;
                    while((len = inputStream.read(buffer)) != -1){
                        baos.write(buffer,0,len);
                    }
                    mBytes = baos.toByteArray();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);
                    imageView.setImageBitmap(bitmap);
                    baos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream != null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
        }
    }
}
