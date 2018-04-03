package edu.vcu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);
    }

    public void onSubmitClick(View v){
        EditText first = (EditText)findViewById(R.id.firstWord);
        EditText second = (EditText)findViewById(R.id.secondWord);

        Contact c = new Contact();
        c.setFirst(first.toString());
        c.setSecond(second.toString());
        helper.insertContact(c);

        Intent i = new Intent(EnterValues.this, MainActivity.class);
        startActivity(i);
    }
}
