package com.example.recyclerviewwithfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdpater.ItemClicked {

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;
    DetailFragment dfrag;
    AddPersonFrag apFrag;
    //LIstFragment lfrag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAdd = findViewById(R.id.btnAdd);




        //apFrag = (AddPersonFrag) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        //lfrag = (LIstFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);


        //As we need to display Nothing when our app starts or we don't won't to display anything
        //before clicking any name
        //onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {

        Toast.makeText(this, "Clicked"+ApplicationClass.people.get(index).getName() ,Toast.LENGTH_SHORT).show();
        String name = ApplicationClass.people.get(index).getName();
        String number = ApplicationClass.people.get(index).getTelNr();

        //tvName.setText(n);
        dfrag = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        dfrag.changeText(name);
        dfrag.changeNumber(number);

        /*
        If we are directly getting the elements from detail fragment then it is closing app,
        i mean if we setText using below then it is closing the app
        The right way to do so is to create a fragment manager and classes in that fragment to change text
        As we have done above

        //tvName.setText(ApplicationClass.people.get(index).getName());
       // tvTel.setText(ApplicationClass.people.get(index).getTelNr());

         */
    }
}