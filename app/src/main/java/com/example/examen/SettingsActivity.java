package com.example.examen;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.RelativeLayout;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceFragmentCompat fragmentCompat = new SettingsFragment();
//        RelativeLayout layout = findViewById(R.id.activity_main);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            layout.setBackgroundColor(getColor(R.color.colorPrimaryDark));
//        }
//        storeColor(getResources().getColor(R.color.colorPrimaryDark));
//
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragmentCompat).commit();
    }

//    private int getColor(){
//
//        SharedPreferences sharedPreferences = getSharedPreferences("back_ground_color", MODE_PRIVATE);
//        int selectedColor = sharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimaryDark));
//        return selectedColor;
//    }
//
//    private void storeColor(int color){
//        SharedPreferences sharedPreferences = getSharedPreferences("back_ground_color", MODE_PRIVATE);
//        SharedPreferences.Editor myeditor = sharedPreferences.edit();
//        myeditor.putInt("color", color);
//        myeditor.apply();
//    }

}
