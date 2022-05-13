package com.example.recyclerviewwithfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class LIstFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;





    public LIstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //Here we are doing the same instead returning the inflator directly we first hold it in the view and returned it as it can be used in further
        view = inflater.inflate(R.layout.fragment_l_ist, container, false);


        return view ;
    }

    // This method is implemented in place of the onActivityCreated Method which is created after all initialization is completed

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);


        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);


        myAdapter = new PersonAdpater(this.getActivity(), ApplicationClass.people);
        recyclerView.setAdapter(myAdapter);




    }
    public void notifyDataChanged()
    {
        //it will notify the person adapter that Application.People is being updated and reload it again
        // we have updated this from the Detail frag where we have taken the input and added to the people list
        myAdapter.notifyDataSetChanged();
    }
}