package com.example.examen;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Toolbar mytoolbar;
    Button buttonA, buttonB, buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonB);
        mytoolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Fragment web_view_fragment = new WebViewFragment();

                String url = "https://www.google.com/";
                bundle.putString("url", url);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content, web_view_fragment)
                        .addToBackStack(null)
                        .commit();

                web_view_fragment.setArguments(bundle);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment main_fragment = new MainFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content, main_fragment)
                        .commit();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_favorite:
                //do something
                return true;
            case R.id.action_settings:

                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                Log.d("TAG", "onOptionsItemSelected: " + intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
