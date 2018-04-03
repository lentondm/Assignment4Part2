package edu.vcu.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class FindSynonym extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
        String word = getIntent().getStringExtra("word");
    }
}
