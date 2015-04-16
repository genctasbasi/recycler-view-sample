package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by genctasbasi on 16/04/15.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public ImageViewHolder(ImageView imageView) {
        super(imageView);
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
