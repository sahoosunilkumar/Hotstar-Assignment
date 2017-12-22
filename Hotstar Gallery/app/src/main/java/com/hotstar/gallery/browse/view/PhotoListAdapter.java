package com.hotstar.gallery.browse.view;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hotstar.gallery.BR;
import com.hotstar.gallery.R;
import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.common.utils.ImageLoader;
import com.hotstar.gallery.databinding.ItemPhotoListBinding;


public class PhotoListAdapter extends PagedListAdapter<PhotoWithSizes, PhotoListAdapter.ProductItemViewHolder> {

    public static DiffCallback<PhotoWithSizes> DIFF_CALLBACK = new DiffCallback<PhotoWithSizes>() {
        @Override
        public boolean areItemsTheSame(@NonNull PhotoWithSizes oldItem, @NonNull PhotoWithSizes newItem) {
            return oldItem.photo.getId() == newItem.photo.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull PhotoWithSizes oldItem, @NonNull PhotoWithSizes newItem) {
            return oldItem.equals(newItem);
        }
    };
    private OnItemClickListener onItemClickListener;

    protected PhotoListAdapter(OnItemClickListener onItemClickListener) {
        super(DIFF_CALLBACK);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ProductItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoListBinding movieListRowBinding = ItemPhotoListBinding.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo_list, parent, false));

        return new ProductItemViewHolder(movieListRowBinding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ProductItemViewHolder holder, int position) {
        PhotoWithSizes result = getItemAt(position);
        holder.bind(result);
    }

    public PhotoWithSizes getItemAt(int position) {
        return getItem(position);
    }

    public class ProductItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemPhotoListBinding binding;

        public ProductItemViewHolder(ItemPhotoListBinding ItemPhotoListBinding, OnItemClickListener onItemClickListener) {
            super(ItemPhotoListBinding.getRoot());
            this.binding = ItemPhotoListBinding;
            ItemPhotoListBinding.getRoot().setOnClickListener(view -> onItemClickListener.onClick(view, getAdapterPosition()));
        }

        public void bind(PhotoWithSizes photo) {
            binding.setVariable(BR.photo, photo);
            binding.executePendingBindings();
            ImageLoader.loadThumbnailImage(binding.icon, binding.getPhoto());
        }
    }

}
