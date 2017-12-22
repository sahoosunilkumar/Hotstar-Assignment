package com.hotstar.gallery.networkinterface;

import com.hotstar.gallery.browse.model.FetchPhotoDetailResponse;
import com.hotstar.gallery.browse.model.FetchPhotosResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkApiService {


    @GET("?method=flickr.people.getPublicPhotos&api_key=227be805b3d6e934926d049533bb938a&user_id=135487628%40N06&format=json&nojsoncallback=1")
    Observable<FetchPhotosResponse> getPublicPhotos(@Query("page") int pageNumber, @Query("per_page") int count);

    @GET("?method=flickr.photos.getSizes&api_key=227be805b3d6e934926d049533bb938a&user_id=135487628%40N06&format=json&nojsoncallback=1")
    Observable<FetchPhotoDetailResponse> getPhotoDetail(@Query("photo_id") String photoId);
}
