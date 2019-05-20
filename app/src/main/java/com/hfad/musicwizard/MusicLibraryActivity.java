package com.hfad.musicwizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hfad.musicwizard.R.id.navigation_home;

public class MusicLibraryActivity extends AppCompatActivity {

    private TextView textViewLyrics;
    private SearchView musicSearch;
    private String apiKey = "4ab5ae9e96c6b208d9601e182c4af443";
    private int x = 0;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_musicLibrary);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case navigation_home:
                        Intent a = new Intent(MusicLibraryActivity.this, MainActivity.class);
                        startActivity(a);
                        return true;
                    case R.id.navigation_musicLibrary:
                        return true;
                    case R.id.navigation_concerts:
                        Intent b = new Intent(MusicLibraryActivity.this, ConcertActivity.class);
                        startActivity(b);
                        return true;
                }

                return false;
            }
        });

        wireWidgets();
    }

    private void wireWidgets() {
        textViewLyrics = findViewById(R.id.textView_music_lyrics);
        musicSearch = findViewById(R.id.searchbar_music_search);
    }

    private void getMusixMatch() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.musixmatch.com/ws/1.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MusixMatchService service = retrofit.create(MusixMatchService.class);

        keyword = musicSearch.getQuery().toString();
        Call<MusixMatchResponse> MusixMatchResponseCall = service.searchMusixMatch(keyword, 1);

        MusixMatchResponseCall.enqueue(new Callback<MusixMatchResponse>() {
            @Override
            public void onResponse(@NonNull Call<MusixMatchResponse> call, @NonNull Response<MusixMatchResponse> response) {
                MusixMatch musixMatch = response.body().getBody();
                List<MusixMatchResponse> musixMatchResponses = musixMatch.getMessage();
                String title = musixMatchResponses.get(x).toString();
                int startIndex = title.indexOf("title");
                int endIndex = title.indexOf("'}}");
                textViewLyrics.setText(musixMatch.toString());
                Log.d("ENQUEUE", "onResponse: " + musixMatch.toString());
            }

            @Override
            public void onFailure(@NonNull Call<MusixMatchResponse> call, @NonNull Throwable t) {
                Log.d("ENQUEUE", "onResponse: " + t.getMessage());
            }
        });





    }

    /*public String search(){
        String trackName = "Don't stop the Party";
        String artistName = "The Black Eyed Peas";

// Track Search [ Fuzzy ]
        Track track = musixMatch.getMatchingTrack(trackName, artistName);
        TrackData data = track.getTrack();

        System.out.println("AlbumID : "    + data.getAlbumId());
        System.out.println("Album Name : " + data.getAlbumName());
        System.out.println("Artist ID : "  + data.getArtistId());
        System.out.println("Album Name : " + data.getArtistName());
        System.out.println("Track ID : "   + data.getTrackId());
    }

    public String getLyrics(){
        int trackID = data.getTrackId();

        Lyrics lyrics = musixMatch.getLyrics(trackID);

        System.out.println("Lyrics ID       : "     + lyrics.getLyricsId());
        System.out.println("Lyrics Language : "     + lyrics.getLyricsLang());
        System.out.println("Lyrics Body     : "     + lyrics.getLyricsBody());
        System.out.println("Script-Tracking-URL : " + lyrics.getScriptTrackingURL());
        System.out.println("Pixel-Tracking-URL : "  + lyrics.getPixelTrackingURL());
        System.out.println("Lyrics Copyright : "    + lyrics.getLyricsCopyright());
    }**/
}