package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context ctx;
//    LayoutInflater inflater;
    List<Modelclass> mData;

    public RecyclerViewAdapter(Context ctx, List<Modelclass> mData){
        this.ctx = ctx;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v =LayoutInflater.from(ctx).inflate(R.layout.item_list,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.RETAILER_ID.setText(mData.get(position).retailer_id);
        holder.PRODUCT_ID.setText(mData.get(position).product_id);
        holder.STATUS.setText(mData.get(position).status);
        holder.STOCK_AVAILABILITY.setText(mData.get(position).stock_availability);
        holder.PRODUCT_NAME.setText(mData.get(position).product_name);

        Picasso.get().load(mData.get(position).getProductimage()).into(holder.PRODUCT_IMAGE);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView RETAILER_ID, PRODUCT_ID,STATUS,STOCK_AVAILABILITY,PRODUCT_NAME;
        ImageView PRODUCT_IMAGE;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            RETAILER_ID = itemView.findViewById(R.id.text2);
            PRODUCT_ID = itemView.findViewById(R.id.Text3);
            STATUS = itemView.findViewById(R.id.Text4);
            STOCK_AVAILABILITY = itemView.findViewById(R.id.Text5);
            PRODUCT_NAME = itemView.findViewById(R.id.Text6);
            PRODUCT_IMAGE = itemView.findViewById(R.id.image);

        }
    }
}
