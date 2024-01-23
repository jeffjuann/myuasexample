package com.jeffjuann.myuasexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  Fragment inputFragment, dataFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView nav = findViewById(R.id.bottomNav);

    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();

    nav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.navigation_home) {
          fm.beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();
          return true;
        } else if (id == R.id.navigation_about) {
          fm.beginTransaction().replace(R.id.mainFragment, new AboutFragment()).commit();
          return true;
        }
        return false;
      }
    });
  }
}