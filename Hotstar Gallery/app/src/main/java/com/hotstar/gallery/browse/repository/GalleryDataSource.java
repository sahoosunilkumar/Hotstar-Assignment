package com.hotstar.gallery.browse.repository;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.browse.viewmodel.FetchPhotoViewModel;

public class GalleryDataSource implements DataSource.Factory<Integer, PhotoWithSizes> {
    private MutableLiveData<FetchRepository> sourceLiveData = new MutableLiveData<>();

    private FetchPhotoViewModel fetchRepositoryViewModel;

    public GalleryDataSource(FetchPhotoViewModel fetchRepositoryViewModel) {
        this.fetchRepositoryViewModel = fetchRepositoryViewModel;
    }

    @Override
    public DataSource<Integer, PhotoWithSizes> create() {
        FetchRepository fetchRepository = new FetchRepository(fetchRepositoryViewModel);
        sourceLiveData.postValue(fetchRepository);
        return fetchRepository;
    }

    public void retry() {
        sourceLiveData.getValue().retry();
    }
}