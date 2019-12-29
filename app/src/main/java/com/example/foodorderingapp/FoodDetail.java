package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodorderingapp.Model.Food;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {

    TextView food_name, food_price, food_desc;
    ImageView food_image;
    CollapsingToolbarLayout collapToolLay;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String foodId="";

    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");

        //Init view
        numberButton = findViewById(R.id.number_button);
        btnCart = findViewById(R.id.btnCart);

        food_desc = findViewById(R.id.food_description);
        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        food_image = findViewById(R.id.img_food);

        collapToolLay = findViewById(R.id.collapsing);
        collapToolLay.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapToolLay.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //Get Food Id from Intent
        if(getIntent() != null) {
            foodId = getIntent().getStringExtra("FoodId");
        }
        if(!foodId.isEmpty()) {
            getDetailFood(foodId);
        }
    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Food food = dataSnapshot.getValue(Food.class);

                //Set Image
                Picasso.with(getBaseContext()).load(food.getImage()).into(food_image);
                collapToolLay.setTitle(food.getName());

                food_price.setText(food.getPrice());

                food_name.setText(food.getName());
                food_desc.setText(food.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
