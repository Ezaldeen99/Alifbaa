package com.example.android.alifbaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity {
    //sulaiman
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // twitter button
        final ImageView twitter = (ImageView) findViewById(R.id.twitter_icon);
        // email button
        final ImageView email = (ImageView) findViewById(R.id.email_icon);
        // facebook button
        final ImageView facebook = (ImageView) findViewById(R.id.facebook_icon);
        //home button
        final CircleImageView home_button = findViewById(R.id.float_button_home);
        // random order
        final Switch switch1 = (Switch) findViewById(R.id.random_order);
        // Lowercase letters
        final Switch switch2 = (Switch) findViewById(R.id.Lowercase_letters);
        //enable swiping
        final Switch switch3 = (Switch) findViewById(R.id.enable_swiping);
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


        // seekbar
        SeekBar seekBar = (SeekBar) findViewById(R.id.id_seek_bar);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                if (switch1.isChecked()) {
                    Toast.makeText(SettingsActivity.this, "random order on", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "random order off", Toast.LENGTH_SHORT).show();
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // ischecked switch2 ?
                if (switch2.isChecked()) {
                    Toast.makeText(SettingsActivity.this, " Lowercase letters on", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "Lowercase letters off", Toast.LENGTH_SHORT).show();
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switch3.isChecked()) {
                    Toast.makeText(SettingsActivity.this, "enable swiping is on ", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "enable swiping is off ", Toast.LENGTH_SHORT).show();
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
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(getApplicationContext(), "SeekBar progress: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar touch started: ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar touch stopped: ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
