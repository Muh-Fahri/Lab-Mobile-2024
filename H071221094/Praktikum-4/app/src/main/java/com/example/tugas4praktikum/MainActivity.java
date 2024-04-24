package com.example.tugas4praktikum;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.container_fragment);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               int menu = menuItem.getItemId();

               if (menu == R.id.navigation_home) {
                   loadFragment(new HomeFragment(), false);
               } else if (menu == R.id.navigation_posting) {
                   loadFragment(new PostingFragment(), false);
               } else {
                   loadFragment(new AkunFragment(),false);
               }
               return true;
            }
        });

        loadFragment(new HomeFragment(), true);
    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.container_fragment, fragment);
        }
        else {
            fragmentTransaction.replace(R.id.container_fragment, fragment);
        }

        fragmentTransaction.commit();
    }
}



