package com.example.foodchoice.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.foodchoice.GroceryItem;
import com.example.foodchoice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link groceries_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class groceries_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<GroceryItem> groceryItemList;

    ArrayAdapter<GroceryItem> groceryItemAdapter;

    private EditText quantityEditText;
    private EditText itemNameEditText;
    private ListView groceryListView;
    private Button addGroceryButton;

    public groceries_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment groceries_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static groceries_fragment newInstance(String param1, String param2) {
        groceries_fragment fragment = new groceries_fragment();
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
        recipe_fragment rFragment = new recipe_fragment();

        rFragment.setArguments(prepareDataForRecipe());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_groceries, container, false);

        quantityEditText = rootView.findViewById(R.id.Quantity);
        itemNameEditText = rootView.findViewById(R.id.Item);
        addGroceryButton = rootView.findViewById(R.id.addButton);

        groceryItemList = new ArrayList<>();

        groceryItemAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, groceryItemList);

        groceryListView = rootView.findViewById(R.id.listViewItems);

        if (groceryListView != null) {
            groceryListView.setAdapter(groceryItemAdapter);
            //groceryListView.setAdapter(bro);
        }

        //groceryListView.setAdapter(groceryItemAdapter); //sets the adapter on the ListView

        if (addGroceryButton != null) {
            addGroceryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(v);
                }
            });
        } else {
            Log.e("MainActivity", "Button addButton not found in the layout");
        }

        // Inflate the layout for this fragment
        return rootView;
    }

    private void addItem(View v) {
        String quantityStr = quantityEditText.getText().toString();
        String itemName = itemNameEditText.getText().toString();
        int quantityInt = Integer.parseInt(quantityStr);
/*
        if (quantityStr.isEmpty() || itemName.isEmpty() || quantityInt == 0) {
            Toast.makeText(this, "Please enter valid quantity and item name" , Toast.LENGTH_SHORT).show();
        } */



        GroceryItem newGroceryItem = new GroceryItem(quantityInt, itemName); //Gotta create the new grocery item first

        //groceryItemList.add(newGroceryItem);
        //idk.add(itemName);

        groceryItemAdapter.add(newGroceryItem);
        //bro.add(itemName);
        groceryItemAdapter.notifyDataSetChanged();

        //We set the edit text for both input fields to empty to show the user sees an empty form ready for their next input
        //quantityEditText.setText("");
        itemNameEditText.setText("");


    }




    public ArrayList<GroceryItem> getGroceryArray() {
        return groceryItemList;
    }

    public Bundle prepareDataForRecipe() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("groceryItemList", groceryItemList);
        return bundle;
    }


}