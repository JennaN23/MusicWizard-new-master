package com.hfad.musicwizard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import static com.hfad.musicwizard.R.id.navigation_home;

public class ConcertActivity extends AppCompatActivity {

    private ListView concertList;
    private SearchView concertSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_concerts);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case navigation_home:
                        Intent a = new Intent(ConcertActivity.this, MainActivity.class);
                        startActivity(a);
                        return true;
                    case R.id.navigation_musicLibrary:
                        Intent b = new Intent(ConcertActivity.this, MusicLibraryActivity.class);
                        startActivity(b);
                        return true;
                    case R.id.navigation_concerts:
                        return true;
                }

                return false;
            }
        });

        wireWidgets();
    }

    private void wireWidgets() {
        concertList = findViewById(R.id.listview_concert_list);
        concertSearch = findViewById(R.id.searchbar_concert_search);
    }
}