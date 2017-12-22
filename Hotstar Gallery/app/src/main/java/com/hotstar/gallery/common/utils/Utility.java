package com.hotstar.gallery.common.utils;

import com.hotstar.gallery.browse.model.PhotoWithSizes;
import com.hotstar.gallery.browse.model.Size;

public class Utility {
    private static final String IMAGE_TYPE_THUMBNAIL = "Thumbnail";

    private Utility() {

    }

    public static String getThumbnailImageUrl(PhotoWithSizes photoAndSizes) {
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
}
