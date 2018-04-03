package edu.vcu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onValuesButtonClick(View v){
        if (v.getId() == R.id.valuesB) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }
    }

    public void onSynonymButtonClick(View v) {
        if (v.getId() == R.id.synonymB) {
            EditText word = (EditText)findViewById(R.id.editText);
            String str = word.getText().toString();
            Intent i = new Intent(MainActivity.this, FindSynonym.class);
            i.putExtra("word", str);
            startActivity(i);
        }
    }
}
