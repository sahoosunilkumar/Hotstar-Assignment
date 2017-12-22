package com.hotstar.gallery.browse.repository;

import com.hotstar.gallery.browse.model.FetchPhotoDetailResponse;
import com.hotstar.gallery.browse.model.Photo;
import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.networkinterface.NetworkApi;
import com.hotstar.gallery.networkinterface.NetworkApiService;

import io.reactivex.Observable;

public class FetchPhotoDetailRepository {
    private NetworkApiService networkApiService;

    public FetchPhotoDetailRepository() {
        networkApiService = NetworkApi.createNetworkApiService();
    }

    public Observable<PhotoWithSizes> getDetail(Photo photo) {
        return networkApiService.getPhotoDetail(photo.getId()).to((Observable<FetchPhotoDetailResponse> photo1) -> convertTo(photo, photo1));
    }

    private Observable<PhotoWithSizes> convertTo(Photo photo, Observable<FetchPhotoDetailResponse> fetchPhotoDetailResponseObservable) {
        return Observable.just(new PhotoWithSizes(photo, fetchPhotoDetailResponseObservable.blockingFirst().getSizes()));
    }
}
