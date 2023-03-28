package com.example.foodjunkie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DefaultRecipeList extends AppCompatActivity {

    private static final String TAG = "";
    ListView lv_recipeList;

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_recipe_list);

        //sets title depending on button clicked in default recipes fragment
        TextView title = findViewById(R.id.defaultTitle);
        String titleText = getIntent().getStringExtra("title");
        title.setText(titleText);



        Log.d(TAG, "onCreate: Started");
        lv_recipeList = (ListView) findViewById(R.id.lv_recipeList);

        dataBaseHelper = new DataBaseHelper(DefaultRecipeList.this);

        List<RecipeModel> recipeList = dataBaseHelper.getAll(getIntent().getStringExtra("title"));

        if(dataBaseHelper.checkEmpty(getIntent().getStringExtra("title"), "DefaultRecipes")){
            RecipeListAdapter adapter = new RecipeListAdapter(this, R.layout.adapter_view_layout, this.dataBaseHelper.getAll(getIntent().getStringExtra("title")));
            lv_recipeList.setAdapter(adapter);
        }
        else{
            Toast.makeText(DefaultRecipeList.this, "No Recipes Found! Create your own, or go to 'FJ Recipes'", Toast.LENGTH_LONG).show();
            //new recipe button here?
            return;
        }



/*
        String i1 = "info 1";
        String i2 = "info 2";

        Food john = new Food("Chicken a la mode", "info 1", "Info 2", "drawable://" + R.drawable.food);
        Food jerry = new Food("Applesauce", i1, i2, "drawable://" + R.drawable.food);
        Food jason = new Food("Mac and Cheese", i1, i2, "drawable://" + R.drawable.food);
        Food jimbo = new Food("Ceasar Salad", i1, i2, "drawable://" + R.drawable.food);
        Food james = new Food("Pasta Carbinara", i1, "Male", "drawable://" + R.drawable.food);
        Food jeff = new Food("Food Name 1", i1, i2, "drawable://" + R.drawable.food);
        Food matt1 = new Food("Food Name 2", i1, i2, "drawable://" + R.drawable.food);
        Food matt2 = new Food("Food Name 3", i1, i2, "drawable://" + R.drawable.food);
        Food matt3 = new Food("Food Name 4", i1, i2, "drawable://" + R.drawable.food);
        Food matt4 = new Food("Food Name 5", i1, i2, "drawable://" + R.drawable.food);
        Food matt5 = new Food("Food Name 6", i1, i2, "drawable://" + R.drawable.food);
        Food matt6 = new Food("Food Name 7", i1, i2, "drawable://" + R.drawable.food);
        Food matt7 = new Food("Food Name 8", i1, i2, "drawable://" + R.drawable.food);
        Food matt8 = new Food("Food Name 9", i1, i2, "drawable://" + R.drawable.food);
        Food matt9 = new Food("Food Name 10", i1, i2, "drawable://" + R.drawable.food);



        ArrayList<Food> peopleList = new ArrayList<>();

        peopleList.add(john);
        peopleList.add(jerry);
        peopleList.add(jason);
        peopleList.add(jimbo);
        peopleList.add(james);
        peopleList.add(jeff);
        peopleList.add(matt1);
        peopleList.add(matt2);
        peopleList.add(matt3);
        peopleList.add(matt4);
        peopleList.add(matt5);
        peopleList.add(matt6);
        peopleList.add(matt7);
        peopleList.add(matt8);
        peopleList.add(matt9);
        peopleList.add(matt1);
        peopleList.add(matt2);
        peopleList.add(matt3);
        peopleList.add(matt4);
        peopleList.add(matt5);
        peopleList.add(matt6);
        peopleList.add(matt7);
        peopleList.add(matt8);
        peopleList.add(matt9);



        RecipeListAdapter adapter = new RecipeListAdapter(this, R.layout.adapter_view_layout, this.dataBaseHelper(getIntent().getStringExtra("title")));

        lv_recipeList.setAdapter(adapter);

 */

        lv_recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DefaultRecipeList.this, DefaultRecipeDisplay.class);
                //RecipeModel recipeModel = lv_recipeList.get(position)
                String item = recipeList.get(i).getRecipeName();
                Bundle extras = new Bundle();
                extras.putString("Recipe", item);
                extras.putString("Title", titleText);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }


}