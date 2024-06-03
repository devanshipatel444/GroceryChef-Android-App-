package com.example.foodchoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.annotation.NonNull;
import com.example.foodchoice.Fragment.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MenuItem;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener  {
    //implementing a listener interface for the function onNavigationItemSelected
    //allows interface to respond to the selection event in the bottom navigation menu created
    // Hey implement a listener to the function I created, so it "listens" for the action (in this case selecting) and then runs the function




    BottomNavigationView bottomNavigationView; // creating an instance of BottomNavigationView
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView  = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnItemSelectedListener (this); // sets a listener for when any of the bottom menu tabs are selected
        // this --> current item's ID
        //setting instance of class (in this case this specific bottom nagivation menu) as the listener.
        // that means when user selects an item in that particular BottomNavigationView ---> it will change fragments
        bottomNavigationView.setSelectedItemId(R.id.groceries); // set the groceries fragment as the initial selected item
        //By default ---> UI would display the groceries tab content



    }





    groceries_fragment gFragment = new groceries_fragment();
    recipe_fragment rFragment = new recipe_fragment();
    calendar_fragment cFragment = new calendar_fragment();



    @Override

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

// Note to Self ---> when cases like R.id.recipes ---> do not use switch case ---> R is no constant and switch cases need a constant expression

        if (item.getItemId() == R.id.groceries) {

            //Fragment Manager --- is a class and below are the different methods provided by it

            getSupportFragmentManager() // FragmentManager --- performs actions on app's fragments
            //creates transactions ---> to add, remove or replace fragments
            // can access the Fragment Manager through the method above
            // getSupportFragmentManager() allows ---> to start/initiate and manage the fragment operations
                    .beginTransaction() // transaction ---> any fragment changes that are saved
                    // starts a new transaction ---> when performing fragment operations
                    .replace(R.id.flFragment, gFragment)
                    // replace is used ---> to replace existing fragment with new one .
                    // more specifically to change content when switching from one fragment to another
            //R.id.flFragment ---> container ---> hosts fragments. Replace contents of flFragment with the groceireis fragment in this case
            //here the flFragment ---> the fragment that is currently displayed ---> managed by Fragment Manager       
                    .commit(); //applies the changes made during transaction --> here is saves the replacing operations

            return true;
        }

        else if (item.getItemId() == R.id.recipes) {
            //can also put all into one line code
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, rFragment).commit();
            return true;
        }

        else if (item.getItemId() == R.id.calendar ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, cFragment).commit();
            return true;
        }

        return false;





    }





}