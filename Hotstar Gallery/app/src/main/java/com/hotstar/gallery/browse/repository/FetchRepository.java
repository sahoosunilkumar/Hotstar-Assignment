package com.hotstar.gallery.browse.repository;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.hotstar.gallery.browse.model.FetchPhotosResponse;
import com.hotstar.gallery.browse.model.Photo;
import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.common.repository.State;
import com.hotstar.gallery.networkinterface.NetworkApi;
import com.hotstar.gallery.networkinterface.NetworkApiService;

import java.util.ArrayList;
import java.util.List;

public class FetchRepository extends PageKeyedDataSource<Integer, PhotoWithSizes> {
    private static final int PAGE_SIZE = 10;
    private static final int INITIAL_PAGE = 1;
    private NetworkApiService networkApiService;

    private IFetchRepositoryCallback fetchRepositoryCallback;
    private LoadParams<Integer> retryParams;
    private LoadCallback<Integer, PhotoWithSizes> retryCallback;
    private FetchPhotoDetailRepository fetchPhotoDetailRepository;

    public FetchRepository(IFetchRepositoryCallback callback) {
        networkApiService = NetworkApi.createNetworkApiService();
        this.fetchRepositoryCallback = callback;
        this.fetchPhotoDetailRepository = new FetchPhotoDetailRepository();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, PhotoWithSizes> callback) {
        fetchRepositoryCallback.onStateChanged(State.IN_PROGRESS);
        networkApiService.getPublicPhotos(INITIAL_PAGE, PAGE_SIZE).subscribe(fetchPhotosResponse -> getPhotoDetail(fetchPhotosResponse, callback));

    }

    private void getPhotoDetail(FetchPhotosResponse fetchPhotosResponse, LoadInitialCallback<Integer, PhotoWithSizes> callback) {
        List<PhotoWithSizes> photoList = new ArrayList<>();
        for (Photo photo : fetchPhotosResponse.getPhotos().getPhoto()) {
            photoList.add(fetchPhotoDetailRepository.getDetail(photo).blockingSingle());
        }
        onInitialized(photoList, callback);
    }

    private void getPhotoDetail(int currentPage, FetchPhotosResponse fetchPhotosResponse, LoadCallback<Integer, PhotoWithSizes> callback) {
        List<PhotoWithSizes> photoList = new ArrayList<>();
        for (Photo photo : fetchPhotosResponse.getPhotos().getPhoto()) {
            photoList.add(fetchPhotoDetailRepository.getDetail(photo).blockingSingle());
        }
        onInitialized(currentPage, photoList, callback);
    }

    private void onInitialized(List<PhotoWithSizes> photoList, @NonNull LoadInitialCallback<Integer, PhotoWithSizes> callback) {
        callback.onResult(photoList, INITIAL_PAGE, INITIAL_PAGE + 1);
        fetchRepositoryCallback.onStateChanged(State.SUCCESS);
    }

    private void onInitialized(int currentPage, List<PhotoWithSizes> photoList, @NonNull LoadCallback<Integer, PhotoWithSizes> callback) {
        callback.onResult(photoList, currentPage + 1);
        fetchRepositoryCallback.onStateChanged(State.SUCCESS);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, PhotoWithSizes> callback) {

    }

    public void retry() {
        loadAfter(retryParams, retryCallback);
    }


    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, PhotoWithSizes> callback) {
        fetchRepositoryCallback.onStateChanged(State.IN_PROGRESS);
        networkApiService.getPublicPhotos(params.key, params.requestedLoadSize).subscribe(fetchPhotosResponse -> getPhotoDetail(params.key, fetchPhotosResponse, callback));

    }

    private void onFailure(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, PhotoWithSizes> callback) {
        fetchRepositoryCallback.onStateChanged(State.FAILURE);
        retryParams = params;
        retryCallback = callback;
    }
}
