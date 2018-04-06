package com.example.android.meme_generator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements top_section.TopSectionInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void createMeme(String top, String bottom) {
        image_section imageFragment;
        imageFragment = (image_section) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        imageFragment.setMemeText(top,bottom);
    }

}
