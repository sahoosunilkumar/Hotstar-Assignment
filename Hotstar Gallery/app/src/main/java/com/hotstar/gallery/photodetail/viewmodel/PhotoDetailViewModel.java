package com.hotstar.gallery.photodetail.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.hotstar.gallery.browse.model.PhotoWithSizes;

public class PhotoDetailViewModel extends ViewModel {

    public PhotoWithSizes movieDetail;

    public PhotoDetailViewModel() {
    }

    public PhotoWithSizes getPhotoDetail() {
        return this.movieDetail;
    }

    public void setMovieDetail(PhotoWithSizes movieDetail) {
        this.movieDetail = movieDetail;
    }
}
