package com.example.examen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {




    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String url_key  = this.getArguments().getString("url");
        View view = inflater.inflate(R.layout.web_view_fragment, container, false);
        final WebView webView = view.findViewById(R.id.view_fragment);

        try {

            URL url = new URL(url_key);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(String.valueOf(url));
            webView.clearCache(true);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN)
                return true;

                if (keyCode == KeyEvent.KEYCODE_BACK){
                if (webView.canGoBack()){
                    webView.goBack();
                    Log.d("KeyListener", "Can go back");
                } else {
                    Log.d("KeyListener", "Cannot go back");
                    ((MainActivity)getActivity()).onBackPressed();
                }
                return true;
                }
            return true;
            }
        });
        return view;
    }
}
