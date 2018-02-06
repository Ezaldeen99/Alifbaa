package com.example.android.alifbaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
//sulaiman
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //home button
        final ImageView home_button = findViewById(R.id.float_button_home);
        // random order
        final Switch switch1 = (Switch) findViewById(R.id.random_order);
        // Lowercase letters

        // Show hints
        final Switch switch4 = (Switch) findViewById(R.id.Show_hints);
        // teacher mode
        final Switch switch5 = (Switch) findViewById(R.id.teacher_mode);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.contains("HINTS")) {
            String displayHints = preferences.getString("HINTS", "ON");
            if (displayHints.equals("ON"))
                switch4.setChecked(true);
            else
                switch4.setChecked(false);
        } else
            switch4.setChecked(true);

        if (preferences.contains("RANDOM")) {
            String randomOrder = preferences.getString("RANDOM", "ON");
            if (randomOrder.equals("ON"))
                switch1.setChecked(true);
            else
                switch1.setChecked(false);
        } else
            switch1.setChecked(true);
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
                if (home_button.isClickable()) {
                    Toast.makeText(SettingsActivity.this, "home button activiated", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, " home button deactiviated", Toast.LENGTH_SHORT).show();
            }
        });
        //  i used the setonCheckedChangeListner instead of the setOnclickListner
        // setOnCheckedListner inherits compoundbutton attributes
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // ischecked switch1 ?
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                SharedPreferences.Editor editor = preferences.edit();

                if (switch1.isChecked()) {
                    editor.putString("RANDOM", "ON");
                    Log.v("RANDOM","Are NOW ON");
                }
                else {
                    editor.putString("RANDOM", "OFF");
                    Log.v("RANDOM","Are NOW OFF");
                }
                editor.apply();
            }
        });

        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
                SharedPreferences.Editor editor = preferences.edit();

                if (switch4.isChecked()) {
                    editor.putString("HINTS", "ON");
                    Log.v("HINTS","Are NOW ON");
                }
                else {
                    editor.putString("HINTS", "OFF");
                    Log.v("HINTS","Are NOW OFF");

                }
                editor.apply();
            }
        });
        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switch5.isChecked()) {
                    Toast.makeText(SettingsActivity.this, "teacher mode is on", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "teacher mode is off", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
