package com.example.recyclerviewwithfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdpater extends RecyclerView.Adapter<PersonAdpater.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(int index);

    }
    public PersonAdpater(Context context, ArrayList<Person> list)
    {
        this.people = list;
        activity = (ItemClicked) context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        //Declare all the items here which we have created in rawlayout for the recyclerview
        TextView tName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(people.indexOf((Person) view.getTag()));

                }
            });

        }
    }
    @NonNull
    @Override
    public PersonAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //As we are returning the personAdapter.viewholder type because of we gave function return type for the same
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdpater.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));
        holder.tName.setText(people.get(position).getName());



    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
