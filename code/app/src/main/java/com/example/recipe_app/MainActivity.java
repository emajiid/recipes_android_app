package com.example.recipe_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    DELETE THE TEST RECIPE AFTER!!
     */

    ArrayList<String> testIngredients = new ArrayList<String>();
    ArrayList<String> testInstructions = new ArrayList<String>();



    Recipe testRecipe = new Recipe(testIngredients, testInstructions);

    ListView recipeListView;
    ArrayList<Recipe> recipeDataList = new ArrayList<Recipe>();
    RecipeArrayAdapter recipeArrayAdapter;

    private FloatingActionButton add_recipe_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recipeDataList.add(testRecipe);
        recipeListView = findViewById(R.id.recipes_list);

        recipeArrayAdapter = new RecipeArrayAdapter(this, recipeDataList);
        recipeListView.setAdapter(recipeArrayAdapter);
        add_recipe_button = findViewById(R.id.add_recipes);

        recipeListView.setAdapter(recipeArrayAdapter);


        /* Test recipe*/

        testRecipe.setRecipeTitle("Skillet Lasagna");

        testIngredients.add("1 Tbsp Olive oil");
        testIngredients.add("1/2 lb. Italian Sausage");
        testIngredients.add("2 cloves garlic");
        testIngredients.add("24 oz. pasta sauce");
        testIngredients.add("1 cup water");
        testIngredients.add("1/2 tsp Italian seasoning");
        testIngredients.add("9 lasagna noodles");
        testIngredients.add("1 cup ricotta cheese");
        testIngredients.add("1/4 cup Grated Parmesan");
        testIngredients.add("1/4 tsp salt");
        testIngredients.add("1/4 tsp freshly cracked black pepper");
        testIngredients.add("1 cup shredded mozzarella");



        testInstructions.add("Add the Italian sausage and olive oil to a large deep skillet. Cook over medium heat until the sausage is cooked through.");
        testInstructions.add("Mince the garlic, add it to the skillet with the sausage, and continue to sauté over medium for one more minute.");
        testInstructions.add("Add the pasta sauce, Italian seasoning, and water to the skillet then stir to combine.");
        testInstructions.add("Break the lasagna noodles into one to two-inch pieces, then stir them into the sauce in the skillet.");
        testInstructions.add("Place a lid on the skillet, turn the heat up to medium-high, and allow the sauce to come up to a boil.");
        testInstructions.add("Once boiling, give the skillet a brief stir, replace the lid, then turn the heat down to medium-low. Let the noodles simmer in the sauce, stirring occasionally, until tender (about 15 minutes). If the sauce becomes too dry before the noodles are tender, add more water and continue to simmer.");
        testInstructions.add("While the noodles are simmering, stir together the ricotta, Parmesan, salt, and pepper in a separate bowl.");
        testInstructions.add("Once the noodles have cooked, add the ricotta mixture on top of the noodles in small dollops. Sprinkle the shredded mozzarella over top.");
        testInstructions.add("Place the skillet under your oven's broiler for a few minutes or just until the cheese is melted and slightly browned (make sure to use an oven-safe skillet, no lid). Or, place the lid on the skillet and continue to cook over medium-low heat until the cheese is melted. Serve hot and enjoy!");


        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra("recipeClickedOn", recipeDataList.get(position));
                startActivity(intent);
            }
        });

        add_recipe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}