package com.example.park;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerlayout;
    NavigationView navigationView;
    Toolbar toolbar,slot2,slot3,slot4,slot5;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        loadFragemnt1(new Afragment());
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        SharedPreferences sharedPreferences;

        sharedPreferences = getSharedPreferences("autoLogin", Context.MODE_PRIVATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "My notification";
            CharSequence channelName = "My Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homes) {
                    loadFragemnt1(new Afragment());
                } else if (id == R.id.apartment) {
                    loadFragemnt2(new Bfragment());
                } else if (id == R.id.about) {
                    loadFragemnt3(new Cfragment());
                } else if(id == R.id.exit) {

                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putInt("key", 0);
                    editor.apply();
                    Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                drawerlayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
    }
    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void loadFragemnt3(Fragment fragment3) {
        FragmentManager fm3 = getSupportFragmentManager();
        FragmentTransaction ft3 = fm3.beginTransaction();
        ft3.replace(R.id.container, fragment3);
        ft3.commit();
    }


    private void loadFragemnt2(Fragment fragment2) {
        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();
        ft2.replace(R.id.container, fragment2);
        ft2.commit();
    }

    private void loadFragemnt1(Fragment fragment1) {
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.container, fragment1);
        ft1.commit();
    }

}

