package com.example.park;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Use the {@link Fragment_Level2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Level2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    TextView textViewBackground3,textViewBackground4,textViewBackground6;

    public Fragment_Level2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Level2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Level2 newInstance(String param1, String param2) {
        Fragment_Level2 fragment = new Fragment_Level2();
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
        View v= inflater.inflate(R.layout.fragment__level2, container2, false);

        FirebaseApp app = FirebaseApp.getApps(getContext()).stream()
                .filter(existingApp -> existingApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
                .findFirst()
                .orElseGet(() -> FirebaseApp.initializeApp(getContext(),new FirebaseOptions.Builder()
                        .setApiKey("AIzaSyBvzjE_Ca2fSHIIpO6fM95OQxpIKgOqbO8")
                        .setProjectId("park-23c0b")
                        .setApplicationId("1:312231921676:android:0e3a0dd8b170e9b1f70629")
                        .setDatabaseUrl("https://park-23c0b-default-rtdb.firebaseio.com/")
                        .build()));

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("sensor_data4"); // Replace with your database path
        // Reference to the TextView
        textViewBackground3 = v.findViewById(R.id.slot4);
        // Add a ValueEventListener to listen for changes in the database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the string value from the database
                String backgroundValue = dataSnapshot.getValue(String.class);
                if ("ON".equals(backgroundValue)){
                    textViewBackground3.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_light)); // Change to your desired color resource
                } else if ("OFF".equals(backgroundValue)) {
                    textViewBackground3.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_light)); // Change to your desired color resource
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reference = database.getReference("sensor_data5"); // Replace with your database path
        // Reference to the TextView
        textViewBackground4= v.findViewById(R.id.slot5);
        // Add a ValueEventListener to listen for changes in the database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the string value from the database
                String backgroundValue = dataSnapshot.getValue(String.class);
                if ("ON".equals(backgroundValue)){
                    textViewBackground4.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_light)); // Change to your desired color resource
                } else if ("OFF".equals(backgroundValue)) {
                    Log.e("surya", String.valueOf(textViewBackground4));
                    textViewBackground4.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_light)); // Change to your desired color resource
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reference = database.getReference("sensor_data6"); // Replace with your database path
        // Reference to the TextView
        textViewBackground6= v.findViewById(R.id.slot3);
        // Add a ValueEventListener to listen for changes in the database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the string value from the database
                String backgroundValue = dataSnapshot.getValue(String.class);
                if ("ON".equals(backgroundValue)){
                    textViewBackground6.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_light)); // Change to your desired color resource
                } else if ("OFF".equals(backgroundValue)) {
                    Log.e("surya", String.valueOf(textViewBackground6));
                    textViewBackground6.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_light)); // Change to your desired color resource
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }
}