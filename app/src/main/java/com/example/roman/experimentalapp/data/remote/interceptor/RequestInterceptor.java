package com.example.roman.experimentalapp.data.remote.interceptor;

//import com.example.roman.experimentalapp.BuildConfig;
import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    String BASE_URL = "https://api.themoviedb.org/3/";
    String IMAGE_URL = "https://image.tmdb.org/t/p/w500%s";

    String TMDB_API_KEY = "5e74ee79280d770dc8ed5a2fbdda955a";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalUrl = originalRequest.url();
        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key", TMDB_API_KEY)
                .build();

        Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
