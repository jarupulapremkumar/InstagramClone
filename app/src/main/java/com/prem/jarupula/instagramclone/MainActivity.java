package com.prem.jarupula.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

private Button btnsave ;
private EditText bname;
private EditText bpunchspeed;
private EditText bpunchpower;
private EditText bkickspeed;
private EditText bkickpower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btnsave);
        bname = findViewById(R.id.edtname);
        bpunchspeed = findViewById(R.id.edtpunchspeed);
        bpunchpower = findViewById(R.id.edtpunchpower);
        bkickspeed = findViewById(R.id.edtkickspeed);
        bkickpower = findViewById(R.id.edtkickpower);

        btnsave.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        try {
            final ParseObject kick_boxer = new ParseObject("KickBoxer");
            kick_boxer.put("name", bname.getText().toString());
            kick_boxer.put("punch_speed", parseInt(bpunchspeed.getText().toString()));
            kick_boxer.put("punch_power", parseInt(bpunchpower.getText().toString()));
            kick_boxer.put("kick_speed", parseInt(bkickspeed.getText().toString()));
            kick_boxer.put("kick_power", parseInt(bkickpower.getText().toString()));
            kick_boxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(MainActivity.this, "details saved successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch(Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}

