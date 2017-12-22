package com.hotstar.gallery.browse.viewmodel;

import android.databinding.ObservableBoolean;

import com.hotstar.gallery.common.repository.State;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FetchPhotoViewModelTest {
    @Mock
    public ObservableBoolean showProgress = new ObservableBoolean();
    @Mock
    public ObservableBoolean showError = new ObservableBoolean();
    @InjectMocks
    private FetchPhotoViewModel subject;

    @Before
    public void setUp() throws Exception {
        subject = new FetchPhotoViewModel();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void onStateChangedSuccess() throws Exception {
        subject.onStateChanged(State.SUCCESS);
        then(showProgress).should(times(1)).set(false);
        then(showError).should(times(1)).set(false);
    }

    @Test
    public void onStateChangedInProgress() throws Exception {
        subject.onStateChanged(State.IN_PROGRESS);
        then(showProgress).should(times(1)).set(true);
        then(showError).should(times(1)).set(false);
    }

    @Test
    public void onStateChangedFailure() throws Exception {
        subject.onStateChanged(State.FAILURE);
        then(showProgress).should(times(1)).set(false);
        then(showError).should(times(1)).set(true);
    }
}
