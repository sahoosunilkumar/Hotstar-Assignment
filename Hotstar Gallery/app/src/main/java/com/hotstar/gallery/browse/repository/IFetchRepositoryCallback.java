package com.hotstar.gallery.browse.repository;

import com.hotstar.gallery.common.repository.State;

public interface IFetchRepositoryCallback {
    void onStateChanged(@State int state);

}
