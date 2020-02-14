package com.example.cinemaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private ClickListenerMovie clickListener;
    private List<Movie> myList;

    public MovieAdapter(List<Movie> myList) {
        this.myList = myList;
    }

    public void setClickListener(ClickListenerMovie clickListener){
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view=(TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myTextView.setText(myList.get(position).getWhichHour()+" "+myList.get(position).getName());
        holder.myTextView.setTag(myList.get(position));
        holder.myTextView.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myTextView;

        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            myTextView=itemView;
        }

        @Override
        public void onClick(View view) {
            clickListener.OnItemClick((Movie) view.getTag());
        }
    }
}

