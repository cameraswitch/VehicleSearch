package com.cameraswitch.vehiclesearch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cameraswitch.vehiclesearch.endpoints.edmunds.Edmunds;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.media.Photo;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.media.Photos;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.media.Source;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.cameraswitch.vehiclesearch.Const.MAKE;
import static com.cameraswitch.vehiclesearch.Const.MODEL;
import static com.cameraswitch.vehiclesearch.Const.MODEL_YEAR;
import static com.cameraswitch.vehiclesearch.endpoints.edmunds.Edmunds.MEDIA_PREFIX;

public class GalleryFragment extends Fragment {
    static final String TAG = GalleryFragment.class.getSimpleName();
    private GridLayoutManager mGridLayoutManager;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mGalleryLinks;
    private ArrayList<String> mThumbnailsLinks;
    private Edmunds mEdmunds;
    private String mYear;
    private String mMake;
    private String mModel;
    private int mMaxWidth;
    private int mThumbnailsWidth;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_fragment, container, false);

        mModel = getArguments().getString(MODEL);
        mMake = getArguments().getString(MAKE);
        mYear = getArguments().getString(MODEL_YEAR);

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        mGridLayoutManager = new GridLayoutManager(getContext(), 2);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mEdmunds = Edmunds.getInstance(getContext());
        if (mMake != null) {
            mEdmunds = Edmunds.getInstance(getContext());
            Log.d(TAG, "getPhotos() make=" + mMake + " model=" + mModel + " year=" + mYear);
            // TODO: add paging for the next 20 items
            mEdmunds.getPhotos(mMake, mModel, mYear, 1, 20, mOnPhotoListener);
        }

        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setVisibility(View.GONE);

        return view;
    }

    private Edmunds.OnPhotoListener mOnPhotoListener = new Edmunds.OnPhotoListener() {

        @Override
        public void onPhotosReady(Photos photos) {
            mGalleryLinks = new ArrayList<>();
            mThumbnailsLinks = new ArrayList<>();
            try {
                if (photos != null && photos.getPhotos() != null) {
                    mMaxWidth = 0;
                    mThumbnailsWidth = 0;
                    for (Photo p : photos.getPhotos()) {
                        if (p.getSources() != null) {
                            for (Source s : p.getSources()) {
                                int w = s.getSize().getWidth();
                                if (w > mMaxWidth) mMaxWidth = w;
                                if (w > mThumbnailsWidth && w < Const.THUMBNAILS_MAX_WIDTH)
                                    mThumbnailsWidth = w;
                            }
                        }
                    }
                    for (Photo p : photos.getPhotos()) {
                        if (p.getSources() != null) {
                            for (Source s : p.getSources()) {
                                String href = s.getLink().getHref();
                                String link = MEDIA_PREFIX + href;
                                int w = s.getSize().getWidth();
                                if (w == mThumbnailsWidth)
                                    mThumbnailsLinks.add(link);
                                if (w == mMaxWidth)
                                    mGalleryLinks.add(link);
                            }
                        }
                    }
                } else {
                    Log.e(TAG, "getPhotos() return nothing ");
                }

                mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), mGalleryLinks);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    };

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

        private List<String> mImageList;
        private Context mContext;

        public RecyclerViewAdapter(Context context, List<String> itemList) {
            mImageList = itemList;
            mContext = context;
        }

        @Override
        public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gallery_item, null);
            RecyclerViewHolders rcv = new RecyclerViewHolders(v);
            return rcv;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolders holder, int position) {
            Picasso.with(mContext)
                    .load(mImageList.get(position))
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return mImageList.size();
        }
    }

    private class RecyclerViewHolders extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(mImageItemClickListener);
        }

        private final View.OnClickListener mImageItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                mRecyclerView.setVisibility(View.GONE);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager.setAdapter(new FullScreenImageAdapter(getContext(),
                        position, mGalleryLinks));
                mViewPager.setCurrentItem(position);
                getActivity().invalidateOptionsMenu();
            }
        };
    }
}
