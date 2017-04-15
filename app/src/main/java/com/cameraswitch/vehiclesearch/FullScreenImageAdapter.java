package com.cameraswitch.vehiclesearch;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FullScreenImageAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private int mIndex;
    private ArrayList<String> mGalleryLinks;

    public FullScreenImageAdapter(Context c, int index, ArrayList<String> links) {
        mContext = c;
        mIndex = index;
        mGalleryLinks = links;
    }

    @Override
    public int getCount() {
        return mGalleryLinks.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.fullscreen_image, container,
                false);

        ImageView imageView = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        String imageLink =mGalleryLinks.get(position);
        Picasso.with(mContext)
                .load(imageLink)
                .into(imageView);

        container.addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}