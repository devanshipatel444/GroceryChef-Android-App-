package com.example.foodchoice.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodchoice.R;
import com.example.foodchoice.GroceryItem;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link recipe_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recipe_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<GroceryItem> groceryItems;

    List<GroceryItem> groceryItemList;

    public recipe_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recipe_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static recipe_fragment newInstance(String param1, String param2) {
        recipe_fragment fragment = new recipe_fragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);

        groceryItems= getArguments().getParcelableArrayList("groceryItemList");


        return rootView;
    }
/*
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String commonIngrediants = loadJSONFromAsset(requireContext(), "commonIngrediants.json");

        if (commonIngrediants != null) {
            //createa new array for this

            ArrayList <String> commonIngredients = parseCommonIngredients(commonIngrediants);

            for (String ingredient : commonIngredients) {
                System.out.println("Ingredient: " + ingredient);
            }
        }
    }

    public String loadJSONFromAsset(Context context, String fileName) {

        String json = null;

        try {

            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);
        }

        catch (IOException error) {
            error.printStackTrace();
        }

        return json;

    }

    public ArrayList<String> parseCommonIngredients(String json) {
        ArrayList<String> commonIngredients = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray commonIngredientsArray = jsonObject.getJSONArray("commonIngredients");

            for (int i = 0; i < commonIngredientsArray.length(); i++) {
                commonIngredients.add(commonIngredientsArray.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return commonIngredients;



    } */
}