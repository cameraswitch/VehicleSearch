package com.cameraswitch.vehiclesearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cameraswitch.vehiclesearch.endpoints.nhtsa.DecodedVin;
import com.cameraswitch.vehiclesearch.endpoints.nhtsa.Result;

import java.util.List;

import static com.cameraswitch.vehiclesearch.Const.DECODED_VIN;

public class DecodeVinFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DecodeVinAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        DecodedVin decodedVin = getArguments().getParcelable(DECODED_VIN);
        mAdapter = new DecodeVinFragment.DecodeVinAdapter(decodedVin);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    static public class DecodeVinAdapter extends Adapter<DecodeVinAdapter.ViewHolder> {
        private final List<Result> mResults;
        private DecodedVin mDecodedVin;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mDescriptionView;
            public TextView mValueView;
            public View mlayout;
            public ViewHolder(View l, TextView d, TextView v) {
                super(l);
                mDescriptionView = d;
                mValueView = v;
                mlayout = l;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public DecodeVinAdapter(DecodedVin decodedVin) {
            mDecodedVin = decodedVin;
            mResults = mDecodedVin.getResults();
        }

        // Create new views (invoked by the layout manager)
        @Override
        public DecodeVinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View layout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.decode_item, parent, false);
            // set the view's size, margins, paddings and layout parameters
            TextView d = (TextView) layout.findViewById(R.id.description);
            TextView v = (TextView) layout.findViewById(R.id.value);
            ViewHolder vh = new ViewHolder(layout, d, v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            String desc = mResults.get(position).getVariable();
            holder.mDescriptionView.setText(desc);
            String value = (String) mResults.get(position).getValue();
            if (value != null)
                holder.mValueView.setText(value);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mResults.size();
        }
    }
}
