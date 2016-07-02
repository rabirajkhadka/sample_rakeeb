package com.example.rakeeb.gdg_workshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    TextInputLayout teamNameContainer;
    TextInputLayout colorNameContainer;
    TextInputLayout colorSeenContainer;

    EditText teamName;
    EditText colorName;
    EditText colorSeen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        teamNameContainer = (TextInputLayout) findViewById(R.id.name_container);
        colorNameContainer = (TextInputLayout) findViewById(R.id.color_name_container);
        colorSeenContainer = (TextInputLayout) findViewById(R.id.color_seen_container);

        teamName = (EditText) findViewById(R.id.team_name);
        colorName = (EditText) findViewById(R.id.color_name);
        colorSeen = (EditText) findViewById(R.id.color_seen);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (teamName.getText().toString().isEmpty()
                        || colorName.getText().toString().isEmpty()
                        || colorSeen.getText().toString().isEmpty()) {

                    if (teamName.getText().toString().isEmpty())
                        teamNameContainer.setError("Your team needs an awesome name, gimme gimme.");

                    if (colorName.getText().toString().isEmpty())
                        colorNameContainer.setError("How do we call the color? :(\nPlease name them.");

                    if (colorSeen.getText().toString().isEmpty())
                        colorSeenContainer.setError("Look around, so many colors :)\nPlease fill them in here.");
                } else {

                    Snackbar.make(view, "All good, form submitted", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
