package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.escmobile.recyclerviewsample.R;

/**
 * Created by genctasbasi on 16/04/15.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public ImageViewHolder(LinearLayout linearLayout) {
        super(linearLayout);

        this.imageView = (ImageView) linearLayout.findViewById(R.id.row_image_view);
        this.textView = (TextView) linearLayout.findViewById(R.id.row_text_view);

        Log.w("GNC", "ImageViewHolder");
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}
