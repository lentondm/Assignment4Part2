package edu.vcu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FindSynonym extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
        String word = getIntent().getStringExtra("word");
        TextView tv = (TextView)findViewById(R.id.resultString);

        String result = helper.searchWord(word);
        if (word.equals(result))
        {
            tv.setText(helper.findSynonym(result));
        }
        else
        {
            tv.setText("Word not found");
        }
    }
}
