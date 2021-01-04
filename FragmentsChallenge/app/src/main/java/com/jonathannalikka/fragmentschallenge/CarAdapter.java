package com.jonathannalikka.fragmentschallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//this class is the list adapter

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    //instance variable for list of cars

    private ArrayList<Car> cars;
    ItemClicked activity;

    /**
     *
     * @param context-context where adapter is created
     * @param list-instance variable holding list of car objects
     */
    public CarAdapter(Context context, ArrayList<Car> list){

        cars = list;
        activity = (ItemClicked) context;

    }

    //interface implemented in ListFrag that changes details when clicked
    public interface ItemClicked{
        void onItemClicked(int index);
    }

    //view holder class below edits text in owner info and car info fragment

    public class ViewHolder extends RecyclerView.ViewHolder {

        //instance variables represent views to be displayed in recycler view

        TextView tvOwner;
        TextView tvModel;
        ImageView ivMake;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvOwner = itemView.findViewById(R.id.tvOwner);
            tvModel = itemView.findViewById(R.id.tvModel);
            ivMake = itemView.findViewById(R.id.ivMake);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(cars.indexOf((Car) itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //here we attach car_layout.xml to adapter

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

        //here we set the text views to the car model and owner, and the image to the car make

        holder.itemView.setTag(cars.get(position));

        holder.tvOwner.setText(cars.get(position).getOwner());
        holder.tvModel.setText(cars.get(position).getModel());

        //set image called "ivMake" to appropriate image

        String make = cars.get(position).getMake();
        if (make.equals("mercedes")){
            holder.ivMake.setImageResource(R.drawable.mercedes);
        }else if (make.equals("nissan")){
            holder.ivMake.setImageResource(R.drawable.nissan);
        }else if (make.equals("volkswagen")){
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        }

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
