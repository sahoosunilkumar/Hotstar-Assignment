package com.hotstar.gallery.photodetail.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hotstar.gallery.R;
import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.common.utils.ImageLoader;
import com.hotstar.gallery.databinding.ActivityPhotoDetailBinding;
import com.hotstar.gallery.photodetail.viewmodel.PhotoDetailViewModel;

public class PhotoDetailActivity extends AppCompatActivity {

    private static final String EXTRA_INFO = "extra_info";
    private PhotoDetailViewModel viewModel;

    public static void launch(Context context, PhotoWithSizes result) {
        Intent intent = new Intent(context, PhotoDetailActivity.class);
        intent.putExtra(EXTRA_INFO, result);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PhotoDetailViewModel.class);
        setData();
        ActivityPhotoDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_detail);
        binding.setPhoto(viewModel.getPhotoDetail());
        ImageLoader.loadOriginalImage(binding.icon, binding.getPhoto());
    }

    private void setData() {
        PhotoWithSizes result = getIntent().getExtras().getParcelable(EXTRA_INFO);
        if (result != null) {
            viewModel.setMovieDetail(result);
        }
    }

}
