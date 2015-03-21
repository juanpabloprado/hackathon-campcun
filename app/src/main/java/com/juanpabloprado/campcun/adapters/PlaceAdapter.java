package com.juanpabloprado.campcun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.model.Place;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Juan on 3/21/2015.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    List<Place> mPlaces = new ArrayList<>();
    private Context mContext;

    public PlaceAdapter(Context context, List<Place> places) {
        mContext = context;
        mPlaces = places;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_list_item, parent, false);
        PlaceViewHolder viewHolder = new PlaceViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.bindPlace(mPlaces.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.placeNameLabel) TextView mNameLabel;
        @InjectView(R.id.priceLabel) TextView mPriceLabel;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void bindPlace(Place place) {
            mNameLabel.setText(place.getName());
            if(place.getPrice() == null) {
                mPriceLabel.setText("??");
            } else if(place.getPrice() == 0) {
                mPriceLabel.setText("Free");
            } else {
                mPriceLabel.setText(place.getPrice() + "");
            }
        }
    }
}
