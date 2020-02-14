package com.example.cinemaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.MyViewHolder> {
    private ClickListener clickListener;
    private List<Cinema> myCinemaList;

    public CinemaAdapter(List<Cinema> myCinemaList) {
        this.myCinemaList = myCinemaList;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView=(TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myTextView.setText(myCinemaList.get(position).getName());
        holder.myTextView.setTag(myCinemaList.get(position));
        holder.myTextView.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return myCinemaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myTextView;

        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            myTextView=itemView;
        }

        @Override
        public void onClick(View view) {
            clickListener.OnItemClick((Cinema)view.getTag());

        }
    }

}
