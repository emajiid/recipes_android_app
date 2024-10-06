package com.example.recipe_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    Recipe recipeClickedOn;

    TextView recipeTitleTextView;

    ListView ingredientsListView;
    ArrayAdapter<String> ingredientsAdapter;

    ListView instructionsListView;
    ArrayAdapter<String> instructionsAdapter;

    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recipes_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            recipeClickedOn = (Recipe)getIntent().getSerializableExtra("recipeClickedOn");
        }

        recipeTitleTextView = findViewById(R.id.recipe_name_main);
        ingredientsListView = findViewById(R.id.ingredients_list);
        instructionsListView = findViewById(R.id.instructions_list);
        back_button = findViewById(R.id.back_button_recipe);

        recipeTitleTextView.setText(recipeClickedOn.getRecipeTitle());

        instructionsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeClickedOn.getSteps());
        instructionsListView.setAdapter(instructionsAdapter);
        ingredientsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeClickedOn.getIngredients());
        ingredientsListView.setAdapter(ingredientsAdapter);


        instructionsAdapter.notifyDataSetChanged();
        ingredientsAdapter.notifyDataSetChanged();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button", "CLICKED BUTTON");
                finish();
            }
        });


    }
}