package com.hotstar.gallery.browse.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.hotstar.gallery.R;
import com.hotstar.gallery.browse.viewmodel.FetchPhotoViewModel;
import com.hotstar.gallery.databinding.ActivityMainBinding;
import com.hotstar.gallery.photodetail.view.PhotoDetailActivity;

public class BrowseActivity extends AppCompatActivity implements BrowseView {


    private PhotoListAdapter repositoryListAdapter;
    private FetchPhotoViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(FetchPhotoViewModel.class);
        binding.setRepositoryViewModel(viewModel);
        initView();

    }

    @Override
    public void onClick(View view, int position) {
        PhotoDetailActivity.launch(this, repositoryListAdapter.getItemAt(position));
    }

    @Override
    public void initView() {
        binding.userList.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.no_of_columns)));
        binding.userList.setHasFixedSize(true);

        repositoryListAdapter = new PhotoListAdapter(this);

        viewModel.userList.observe(this, pagedList -> {
            repositoryListAdapter.setList(pagedList);
        });
        binding.userList.setAdapter(repositoryListAdapter);
    }


    public void retry(View view) {
        viewModel.retry();
    }
}
