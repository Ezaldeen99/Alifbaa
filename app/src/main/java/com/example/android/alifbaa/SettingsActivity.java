package com.example.android.alifbaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //home button
        final ImageView home_button = findViewById(R.id.float_button_home);
        // random order
        final Switch randomOrderSwitch = (Switch) findViewById(R.id.random_order);
        //enable scoring
        final Switch enableScoringSwitch = (Switch) findViewById(R.id.enable_scoring);
        // Show hints
        final Switch displayHintsSwitch = (Switch) findViewById(R.id.Show_hints);
        // teacher mode
        final Switch teacherModeSwitch = (Switch) findViewById(R.id.teacher_mode);

        // checking the sheared preferences if it has Display Hints option enabled ot not.
        // if it is enabled so checked the switch otherwise unchecked it.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.contains("HINTS")) {
            String displayHints = preferences.getString("HINTS", "ON");
            if (displayHints.equals("ON"))
                displayHintsSwitch.setChecked(true);
            else
                displayHintsSwitch.setChecked(false);
        } else
            displayHintsSwitch.setChecked(true);

        // checking the sheared preferences if it has Random Order option enabled ot not.
        // if it is enabled so checked the switch otherwise unchecked it.
        if (preferences.contains("RANDOM")) {
            String randomOrder = preferences.getString("RANDOM", "OFF");
            if (randomOrder.equals("ON"))
                randomOrderSwitch.setChecked(true);
            else
                randomOrderSwitch.setChecked(false);
        } else
            randomOrderSwitch.setChecked(false);

        // checking the sheared preferences if it has Enable Scoring option enabled ot not.
        // if it is enabled so checked the switch otherwise unchecked it.
        if (preferences.contains("SCORING")) {
            String enableScoring = preferences.getString("SCORING", "ON");
            if (enableScoring.equals("ON"))
                randomOrderSwitch.setChecked(true);
            else
                randomOrderSwitch.setChecked(false);
        } else
            randomOrderSwitch.setChecked(true);

        // contact us
        TextView contact_text = findViewById(R.id.contact);
        contact_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact_fragment = new Intent(SettingsActivity.this, ContactUs.class);
                startActivity(contact_fragment);
            }
        });
        // setOnClickListner for home button
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //  i used the setonCheckedChangeListner instead of the setOnclickListner
        // setOnCheckedListner inherits compoundbutton attributes
        randomOrderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Here the SharedPreferences will edit the value of Random Order Option value according to
                // the switch if it is checked or not.
                // Checked -> ON
                // UnChecked -> OFF
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                if (randomOrderSwitch.isChecked()) {
                    editor.putString("RANDOM", "ON");
                } else {
                    editor.putString("RANDOM", "OFF");
                }
                editor.apply();
            }
        });

        enableScoringSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                // Here the SharedPreferences will edit the value of Enable Scoring Option value according to
                // the switch if it is checked or not.
                // Checked -> ON
                // UnChecked -> OFF
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                SharedPreferences.Editor editor = preferences.edit();

                if (enableScoringSwitch.isChecked()) {
                    editor.putString("SCORING", "ON");
                } else {
                    editor.putString("SCORING", "OFF");
                }
                editor.apply();
            }
        });
        displayHintsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                // Here the SharedPreferences will edit the value of Display Hints Option value according to
                // the switch if it is checked or not.
                // Checked -> ON
                // UnChecked -> OFF
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                SharedPreferences.Editor editor = preferences.edit();

                if (displayHintsSwitch.isChecked()) {
                    editor.putString("HINTS", "ON");
                } else {
                    editor.putString("HINTS", "OFF");

                }
                editor.apply();
            }
        });
        teacherModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (teacherModeSwitch.isChecked()) {
                    Toast.makeText(SettingsActivity.this, "teacher mode is on", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "teacher mode is off", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
