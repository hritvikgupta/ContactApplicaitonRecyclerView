package com.example.recyclerviewwithfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonFrag extends Fragment {

    Button btnAdd;
    EditText etName, etTel;
    LIstFragment lfrag;
    FragmentManager fragmentManager;



    public AddPersonFrag() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_person, container, false);
        btnAdd = v.findViewById(R.id.btnAdd);
        etName = v.findViewById(R.id.etName);
        etTel  = v.findViewById(R.id.etTel);

        //Here we Need to Update the list fragment everytime we develop add a new item
        // for that we need to connect the detail fragment to the list fragment using the fragment manager
        fragmentManager = getActivity().getSupportFragmentManager();
        lfrag = (LIstFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty() || etTel.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Person p  = new Person(etName.getText().toString(), etTel.getText().toString());
                    ApplicationClass.people.add(p);
                    Toast.makeText(getActivity(), "Successfull", Toast.LENGTH_SHORT).show();

                    //To again make the entry fields blank to be able to add another one again
                    etName.setText(null);
                    etTel.setText(null);

                    //we Notified the person adapter from the list fragment that applicaion class for people has been updated
                    lfrag.notifyDataChanged();



                }

            }
        });
        return v;

    }

}