package com.example.inehemias.foddieapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<MealItemClass> mData;

    public RecyclerViewAdapter (Context mContext, List<MealItemClass> mData){
        this.mContext = mContext;
        this.mData = mData;
    }
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_meal_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.meal_title.setText(mData.get(position).getTitle());
        holder.meal_info.setText(mData.get(position).getInfo());
        holder.meal_thumbnail.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) { //remove and confirmation
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("Confirmation");
                alert.setMessage("Are you sure to delete on the Meal Item from the Card List");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MealItemClass mealItem = mData.get(position);
                        mData.remove(position);

                        notifyItemRemoved(position);

                        notifyItemRangeChanged(position,mData.size());
                        Toast.makeText(mContext, "Removed : "+mealItem,
                        Toast.LENGTH_LONG).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }


        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DescriptionActivity.class);
                //passing data to the next activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDesc());
                intent.putExtra("Thumbnail", mData.get(position).getImage());
                intent.putExtra("Url", mData.get(position).getUrl());

                //start the activity

                mContext.startActivity(intent);
            }

        });
        }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView meal_title;
        ImageView meal_thumbnail;
        CardView cardView;
        TextView meal_info;
        public MyViewHolder (View itemView){
            super(itemView);

            meal_title = (TextView) itemView.findViewById(R.id.meal_title_id);
            meal_info = (TextView)  itemView.findViewById(R.id.mealInfo);

            meal_thumbnail = (ImageView) itemView.findViewById(R.id.meal_img_id);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }
}
