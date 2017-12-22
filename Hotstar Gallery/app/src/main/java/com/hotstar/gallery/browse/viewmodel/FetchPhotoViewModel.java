package com.hotstar.gallery.browse.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.databinding.ObservableBoolean;

import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.browse.repository.GalleryDataSource;
import com.hotstar.gallery.browse.repository.IFetchRepositoryCallback;
import com.hotstar.gallery.common.repository.State;

public class FetchPhotoViewModel extends ViewModel implements IFetchRepositoryCallback {

    public LiveData<PagedList<PhotoWithSizes>> userList;
    //    public MutableLiveData<Integer> networkState = Transformations.switchMap(userList,);
    public ObservableBoolean showProgress = new ObservableBoolean();
    public ObservableBoolean showError = new ObservableBoolean();
    private GalleryDataSource dataSource;

    public FetchPhotoViewModel() {
        init();
    }

    private void init() {
        showError.set(false);
        showProgress.set(false);
        dataSource = new GalleryDataSource(this);
        userList = new LivePagedListBuilder(dataSource, 10).build();
    }

    @Override
    public void onStateChanged(int state) {
        showProgress.set(state == State.IN_PROGRESS);
        showError.set(state == State.FAILURE);
    }

    public void retry() {
        dataSource.retry();
    }
}
