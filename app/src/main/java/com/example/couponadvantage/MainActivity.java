package com.example.couponadvantage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {
    private TextView textViewLocation;
    private RecyclerView featuredItemsRecyclerView;
    private FirebaseRecyclerAdapter<FeaturedItem, FeaturedItemViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find the TextView for location in the toolbar
        textViewLocation = toolbar.findViewById(R.id.textViewLocation);

        // Example: Set a dummy location for demonstration
        String locationn = "Indore";
        textViewLocation.setText(locationn);
        //<----------------------------------------------------->

        //<---------------------------------------------->
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Ad");
        //<--------------------------------------------->

        //searching work




        //database data retrieval work
        featuredItemsRecyclerView = findViewById(R.id.featuredItemsRecyclerView);
        featuredItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<FeaturedItem> options =
                new FirebaseRecyclerOptions.Builder<FeaturedItem>()
                        .setQuery(databaseReference, FeaturedItem.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<FeaturedItem, FeaturedItemViewHolder>(options) {
            @NonNull
            @Override
            public FeaturedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_featured_ad, parent, false);
                return new FeaturedItemViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FeaturedItemViewHolder holder, int position, @NonNull FeaturedItem model) {
                holder.bind(model);
            }
        };

        featuredItemsRecyclerView.setAdapter(adapter);

        //<------------------------------------------->
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void chat(View v) {
        Intent intent = new Intent(this, CHAT.class);
        startActivity(intent);
    }

    public void sell(View v) {
        Intent intent = new Intent(this, SELL.class);
        startActivity(intent);
    }

    public void ads(View v) {
        Intent intent = new Intent(this, MyAds.class);
        startActivity(intent);
    }

    public void profile(View v) {
        Intent intent = new Intent(this, PROFILE.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView seatchview = (SearchView)item.getActionView();

        seatchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
    private void txtSearch(String str)
    {
        FirebaseRecyclerOptions<FeaturedItem> options =
                new FirebaseRecyclerOptions.Builder<FeaturedItem>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ad")
                                .orderByChild("Title").startAt(str).endAt(str+"~"), FeaturedItem.class)

                        .build();


        adapter.updateOptions(options);
        adapter.startListening();
        featuredItemsRecyclerView.setAdapter(adapter);
    }
}
