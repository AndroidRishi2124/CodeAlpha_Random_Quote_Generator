package com.example.newsplash;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsplash.categories.CategoriesAdapter;
import com.example.newsplash.categories.CategoriesList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private final List<CategoriesList> categoriesLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final RecyclerView Catrec = findViewById(R.id.catrec);

        Catrec.setHasFixedSize(true);
        Catrec.setLayoutManager(new GridLayoutManager(MainActivity2.this,2));

        //add category to category list
        CategoriesList loveCategory = new CategoriesList("Love",R.drawable.bob_marley);
        categoriesLists.add(loveCategory);

        CategoriesList motivationCategory = new CategoriesList("Motivation",R.drawable.brucelee);
        categoriesLists.add(motivationCategory);

        CategoriesList EnglishCategory = new CategoriesList("English",R.drawable.simon);
        categoriesLists.add(EnglishCategory);

        CategoriesList LifeCategory = new CategoriesList("Life",R.drawable.krishna);
        categoriesLists.add(LifeCategory);

        CategoriesList SuccessCategory = new CategoriesList("Success",R.drawable.stanlee);
        categoriesLists.add(SuccessCategory);

        //set adapter to recyclerview
        Catrec.setAdapter(new CategoriesAdapter(categoriesLists,MainActivity2.this));
    }
}