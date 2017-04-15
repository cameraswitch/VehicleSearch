package com.cameraswitch.vehiclesearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cameraswitch.vehiclesearch.endpoints.edmunds.Edmunds;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealer;
import com.cameraswitch.vehiclesearch.endpoints.edmunds.dealers.Dealers;

import java.text.DecimalFormat;

import static com.cameraswitch.vehiclesearch.Const.MAKE;
import static com.cameraswitch.vehiclesearch.Const.ZIP_CODE;

public class DealersFragment extends Fragment {
    private Edmunds mEdmunds;
    private String mMake;
    private String mZipCode;
    private InventoryAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mZipCode = getArguments().getString(ZIP_CODE);
        mMake = getArguments().getString(MAKE);

        mEdmunds = Edmunds.getInstance(getContext());
        if (mMake != null && mZipCode != null) {
            // TODO: paging the next 20 items
            mEdmunds.getDealers(mZipCode, mMake, 1, 20, mOnDealerListener);
        }
        return view;
    }

    private Edmunds.OnDealersListener mOnDealerListener = new Edmunds.OnDealersListener() {

        @Override
        public void onDealersReady(Dealers dealers) {
            mAdapter = new InventoryAdapter(getContext(), dealers);
            mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }
    };

    static public class InventoryAdapter extends
            Adapter<DealersFragment.InventoryAdapter.ViewHolder> {
        private final Context mContext;
        public Dealers mDealers;
        DecimalFormat df = new DecimalFormat("#.#");

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // each data item is just a string in this case
            public TextView mFirst;
            public TextView mSecond;
            public TextView mPhone;
            public ImageView mImageView1;
            public RatingBar mRating;
            public View mlayout;
            public String mAddress;

            public ViewHolder(View l, TextView f, TextView s, TextView p, ImageView iv1,
                              RatingBar r ) {
                super(l);
                mFirst = f;
                mSecond = s;
                mPhone = p;
                mImageView1 = iv1;
                mlayout = l;
                l.setOnClickListener(this);
                mImageView1.setOnClickListener(this);
                mRating = r;
            }

            @Override
            public void onClick(View v) {
                if (v == mlayout) {
                    int position = getAdapterPosition();
                    Dealer d = mDealers.getDealers().get(position);
                    if (d.getContactInfo() != null) {
                        String url = d.getContactInfo().getWebsite();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        mContext.startActivity(i);
                    }
                } else if (v == mImageView1) {
                    String url = "http://maps.google.com/maps?daddr="+mAddress;
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    mContext.startActivity(i);
                }
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public InventoryAdapter(Context c, Dealers dealers) {
            mDealers = dealers;
            mContext = c;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                              int viewType) {
            // create a new view
            View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dealers_item, parent, false);
            // set the view's size, margins, paddings and layout parameters
            TextView f = (TextView) layout.findViewById(R.id.first_text_view);
            TextView s = (TextView) layout.findViewById(R.id.second_text_view);
            TextView p = (TextView) layout.findViewById(R.id.price_text_view);
            ImageView iv1 = (ImageView) layout.findViewById(R.id.map);
            RatingBar r = (RatingBar) layout.findViewById(R.id.rating);
            InventoryAdapter.ViewHolder vh =
                    new InventoryAdapter.ViewHolder(layout, f, s, p, iv1, r);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(InventoryAdapter.ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Dealer d = mDealers.getDealers().get(position);
            double distance = d.getDistance();
            holder.mFirst.setText(d.getName() + " (" + df.format(distance) + " miles )");
            if (d.getAddress() != null) {
                holder.mAddress = d.getAddress().getStreet() + ", " +
                        d.getAddress().getCity() + ", " +
                        d.getAddress().getStateCode() + ", " +
                        d.getAddress().getZipcode();
                holder.mSecond.setText(holder.mAddress);
            } else {
                holder.mSecond.setText("NO VALUE");
            }
            if (d.getContactInfo() != null) {
                holder.mPhone.setText(d.getContactInfo().getPhone());
                holder.mPhone.setAutoLinkMask(Linkify.PHONE_NUMBERS);
                holder.mPhone.setLinksClickable(true);
                holder.mPhone.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                holder.mPhone.setText("NO VALUE");
                holder.mPhone.setLinksClickable(false);
            }
            float rating = (float) d.getReviews().getSales().getOverallRating().doubleValue();
            holder.mRating.setRating(rating);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDealers.getDealers().size();
        }
    }
}
