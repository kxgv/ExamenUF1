package com.example.examen;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

                getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new MainFragment()).commit();
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
