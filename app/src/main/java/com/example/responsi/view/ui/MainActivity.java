package com.example.responsi.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.responsi.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navbar;
    private Fragment fragment = new FragmentKasus() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        navbar = findViewById(R.id.navbar);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.maincontainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_botnav_kashar:
                fragment = new FragmentKasus();
                break;

            case R.id.menu_botnav_faskes:
                fragment = new FragmentFasilitas();
        }
        return loadFragment(fragment);
    }
}