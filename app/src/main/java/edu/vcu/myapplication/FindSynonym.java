package edu.vcu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FindSynonym extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_synonym);
        String word = getIntent().getStringExtra("word");
        final TextView textView = (TextView) findViewById(R.id.resultString);

        String result = helper.findSynonym(word);
        if (result.equals("not found"))
        {
            String str = "Word not found";
            textView.setText(str);
        }
        else
        {
            textView.setText(result);
        }
    }
}
