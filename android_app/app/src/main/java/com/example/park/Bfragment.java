package com.example.park;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bfragment extends Fragment {
    Button firstFragmentBtn, secondFragmentBtn,thirdFragmentBtn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentManager supportFragmentManager;


    public Bfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Bfragment newInstance(String param1, String param2) {
        Bfragment fragment = new Bfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v=inflater.inflate(R.layout.fragment_b, container2, false);
        firstFragmentBtn = v.findViewById(R.id.button1);
        secondFragmentBtn = v.findViewById(R.id.button2);
        thirdFragmentBtn = v.findViewById(R.id.button3);
        Level1(new Fragment_Level1());
        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level1(new Fragment_Level1());

            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level2(new Fragment_Level1(),new Fragment_Level2());

            }
        });
        thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Level3(new Fragment_Level3());

            }
        });
        return v;
    }
    private void Level1(Fragment fragment1) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
       // transaction.setCustomAnimations(R.anim.slideinright,  R.anim.slideoutright);
        transaction.replace(R.id.fragmentblank1, fragment1); // Use a container in your activity layout
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void  Level2(Fragment fragment1,Fragment fragment2) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
       // transaction.setCustomAnimations(R.anim.slideanimator2,R.anim.slideanimator);
        transaction.replace(R.id.fragmentblank1, fragment2); // Use a container in your activity layout
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void  Level3(Fragment fragment3) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
       // transaction.setCustomAnimations(R.anim.slideinright,R.anim.slideoutright);
        transaction.replace(R.id.fragmentblank1, fragment3); // Use a container in your activity layout
        transaction.addToBackStack(null);
        transaction.commit();
    }
}