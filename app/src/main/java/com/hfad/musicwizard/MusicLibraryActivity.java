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

public class MusicLibraryActivity extends AppCompatActivity {

    private ListView musicList;
    private SearchView musicSearch;
    private String apiKey = "4ab5ae9e96c6b208d9601e182c4af443";
    private MusixMatch musixMatch = new MusixMatch(apiKey);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_musicLibrary);
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
        musicList = findViewById(R.id.listview_music_list);
        musicSearch = findViewById(R.id.searchbar_music_search);
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