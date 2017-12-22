package com.hotstar.gallery.networkinterface;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkApi {

    private static final String BASE_URL = "https://api.flickr.com/services/rest/";

    public static NetworkApiService createNetworkApiService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL);

        return builder.build().create(NetworkApiService.class);
    }
}
