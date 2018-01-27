package com.example.android.alifbaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    //sulaiman
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // twitter button
        final ImageView twitter = findViewById(R.id.twitter_icon);
        // email button
        final ImageView email = findViewById(R.id.email_icon);
        // facebook button
        final ImageView facebook = findViewById(R.id.facebook_icon);
        //home button
//        final FloatingActionButton home_button = findViewById(R.id.float_button_home);
        // random order
        final Switch switch1 = findViewById(R.id.random_order);
        // Lowercase letters
        final Switch switch2 = findViewById(R.id.Lowercase_letters);
        //enable swiping
        final Switch switch3 = findViewById(R.id.enable_swiping);
        // Show hints
        final Switch switch4 = findViewById(R.id.Show_hints);
        // teacher mode
        final Switch switch5 = findViewById(R.id.teacher_mode);
        // seekbar
        SeekBar seekBar = findViewById(R.id.id_seek_bar);
        // contact us
         TextView contact_text = findViewById(R.id.contact);
        contact_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact_fragment = new Intent(SettingsActivity.this, ContactUs.class);
                startActivity(contact_fragment);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // setOnClickListner for home button
        //   home_button.setOnClickListener(new View.OnClickListener() {
        //       @Override
        //     public void onClick(View view) {
        //         if (home_button.isClickable()) {
        //             Toast.makeText(SettingsActivity.this, "home button activiated", Toast.LENGTH_SHORT).show();
        //         } else
        //              Toast.makeText(SettingsActivity.this, " home button deactiviated", Toast.LENGTH_SHORT).show();
        //      }
        //   });
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
                if (switch4.isChecked()) {
                    Toast.makeText(SettingsActivity.this, "hints is on ", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(SettingsActivity.this, "hints is off", Toast.LENGTH_SHORT).show();
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
