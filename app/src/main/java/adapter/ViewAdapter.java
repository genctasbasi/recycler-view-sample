package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.escmobile.recyclerviewsample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by genctasbasi on 16/04/15.
 */
public class ViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private static final int TARGET_SIZE = 500;
    private Context context;
    private String[] imageUrls;

    public ViewAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        ImageView imageView = (ImageView) LayoutInflater.from(context)
                .inflate(R.layout.recycler_view_row, viewGroup, false);

        ImageViewHolder vh = new ImageViewHolder(imageView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {

        // replace the content of the view.
        // if you don't know what Picasso is, please don't worry about it for now.
        // it's a 3rd party lib that makes image downloading & caching so easy.
        Picasso
                .with(context)
                .load(imageUrls[i])
                .resize(TARGET_SIZE, TARGET_SIZE)
                .into(imageViewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return imageUrls == null ? 0 : imageUrls.length;
    }
}
