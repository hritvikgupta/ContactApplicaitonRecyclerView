package com.example.recyclerviewwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    TextView tvName, tvTel;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        tvName = v.findViewById(R.id.tvName);
        tvTel = v.findViewById(R.id.tvTel);

        return v;

    }

    public void changeText(String s)
    {
        tvName.setText(s);
    }
    public void changeNumber(String s){
        tvTel.setText(s);

    }
}