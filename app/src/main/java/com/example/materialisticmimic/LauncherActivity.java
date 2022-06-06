package com.example.materialisticmimic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HashMap<String, Class<? extends Activity>> map = new HashMap<>();
        map.put("top", ListActivity.class);
        map.put("best", BestActivity.class);
        map.put("hot", PopularActivity.class);
        map.put("hot", NewActivity.class);
        map.put("hot", AskActivity.class);
        map.put("hot", ShowActivity.class);
        map.put("hot", JobsActivity.class);
        map.put("hot", FavoriteActivity.class);

        String launchScreen = Preferences.getLaunchScreen(this);

        startActivity(new Intent(this, map.containsKey(launchScreen) ?
                map.get(launchScreen) : ListActivity.class));

        finish();
    }
}