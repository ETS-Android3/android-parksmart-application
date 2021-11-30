package com.example.speechrecognition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {

    private Context mcontext;

    private ParkingAdapter mParkingAdapter;
    public void setConfig(RecyclerView recyclerView,Context context, List<Parking> parkings, List<String> keys){

        mcontext = context;
        mParkingAdapter = new ParkingAdapter(parkings,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mParkingAdapter);

    }

    class ParkingItemView extends RecyclerView.ViewHolder{
        private TextView mParkingSpot;
        private TextView mLatitude;
        private TextView mLongitude;
        private TextView mAvailability;


        private String key;

        public ParkingItemView(ViewGroup parent){
            super(LayoutInflater.from(mcontext).inflate(R.layout.list_item,parent,false));

            mParkingSpot = (TextView) itemView.findViewById(R.id.spot_textView);
            mLatitude = (TextView) itemView.findViewById(R.id.latitude);
            mLongitude = (TextView) itemView.findViewById(R.id.longitude);
            mAvailability = (TextView) itemView.findViewById(R.id.availability_textView);

        }

        public void bind(Parking parking, String key){
            mParkingSpot.setText(parking.getParking_spot());
            mLatitude.setText(parking.getLatitude());
            mLongitude.setText(parking.getLongitude());
            mAvailability.setText(parking.getAvailability());
            this.key = key;
        }
    }

    class ParkingAdapter extends RecyclerView.Adapter<ParkingItemView>{
        private List<Parking> mParkingList;
        private List<String> mKeys;

        public ParkingAdapter(List<Parking> mParkingList, List<String>mKeys){
            this.mParkingList = mParkingList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ParkingItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ParkingItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ParkingItemView holder, int position) {
            holder.bind(mParkingList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mParkingList.size();
        }
    }



}
