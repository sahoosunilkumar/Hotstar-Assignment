package com.hotstar.gallery.common.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.browse.model.Size;

public class ImageLoader {
    private static final String IMAGE_TYPE_THUMBNAIL = "Thumbnail";
    private static final String IMAGE_TYPE_LARGE = "Large";

    private ImageLoader() {

    }

    public static void loadThumbnailImage(ImageView view, PhotoWithSizes photoAndSizes) {
        String endPoint = getThumbnailImageUrl(photoAndSizes);
        Glide.with(view.getContext()).load(endPoint).into
                (view);
    }

    public static void loadOriginalImage(ImageView view, PhotoWithSizes photoAndSizes) {
        String endPoint = getOriginalImageUrl(photoAndSizes);
        Glide.with(view.getContext()).load(endPoint).into
                (view);
    }

    private static String getThumbnailImageUrl(PhotoWithSizes photoAndSizes) {
        String thumbnailUrl = null;
        try {
            for (Size size : photoAndSizes.sizes.getSize()) {
                if (IMAGE_TYPE_THUMBNAIL.equalsIgnoreCase(size.getLabel())) {
                    thumbnailUrl = size.getSource();
                    break;
                }
            }
        } catch (Exception ex) {

        }
        return thumbnailUrl;
    }

    private static String getOriginalImageUrl(PhotoWithSizes photoAndSizes) {
        String thumbnailUrl = null;
        try {
            for (Size size : photoAndSizes.sizes.getSize()) {
                if (IMAGE_TYPE_LARGE.equalsIgnoreCase(size.getLabel())) {
                    thumbnailUrl = size.getSource();
                    break;
                }
            }
        } catch (Exception ex) {

        }
        if (thumbnailUrl == null) {
            thumbnailUrl = photoAndSizes.sizes.getSize().get(0).getSource();
        }
        return thumbnailUrl;
    }
}
