package com.example.recipe_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RecipeArrayAdapter extends ArrayAdapter {

    private ArrayList<Recipe> recipes;
    private Context context;

    public RecipeArrayAdapter(Context context, ArrayList<Recipe> recipes) {
        super(context, 0, recipes);
        this.recipes = recipes;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.recipe_entry, parent, false);
        }

        Recipe recipe = recipes.get(position);

        TextView recipeName = view. findViewById(R.id.browser_entry_name);

        recipeName.setText(recipe.getRecipeTitle());

        return view;
    }
}
