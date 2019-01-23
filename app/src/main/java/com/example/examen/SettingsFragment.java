package com.example.examen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

    }

    public SettingsFragment() {
        // Required empty public constructor
    }

}
