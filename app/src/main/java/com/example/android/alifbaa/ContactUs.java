package com.example.android.alifbaa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sulaiman on 26/1/2018.
 */
public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        ((Button) findViewById(R.id.send)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText message = ((EditText) findViewById(R.id.context));
                EditText your_email = ((EditText) findViewById(R.id.email));
                EditText your_name = ((EditText) findViewById(R.id.name));
                EditText phone_number = ((EditText) findViewById(R.id.telephone));
                String name = your_name.getText().toString();
                String phone = phone_number.getText().toString();
                String email = your_email.getText().toString();
                String mess = message.getText().toString();


                if (TextUtils.isEmpty(name)) {
                    your_name.setError("Enter Your Name");
                    your_name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    your_email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(phone)) {
                    phone_number.setError("Enter Your Telephone");
                    phone_number.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(mess)) {
                    message.setError("Enter Your Message");
                    message.requestFocus();
                    return;
                }
                Intent mail = new Intent(Intent.ACTION_SEND);
                //  alif baa email should be put here:
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"suleiman_hayek@yahoo.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, "Contact Form");
                mail.putExtra(Intent.EXTRA_TEXT, " Name: " + name + "\n Phone Number: " + phone + "\n context: \n " + mess);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Send email via:"));

            }

        });

    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    // validating email id

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
