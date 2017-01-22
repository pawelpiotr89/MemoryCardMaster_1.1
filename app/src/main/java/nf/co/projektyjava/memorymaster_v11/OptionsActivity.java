package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class OptionsActivity extends AppCompatActivity {

    public static boolean greenState = true, yellowState, orangeState, redState, purpleState = false;
    CheckBox yellow, orange, red, purple, green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        yellow = (CheckBox) findViewById(R.id.color_yellow);
        orange = (CheckBox) findViewById(R.id.color_orange);
        red = (CheckBox) findViewById(R.id.color_red);
        purple = (CheckBox) findViewById(R.id.color_purple);
        green = (CheckBox) findViewById(R.id.color_green);

        if (greenState) {
            green.setChecked(true);
            green.setEnabled(false);
        }

        if (yellowState) {
            yellow.setChecked(true);
            yellow.setEnabled(false);
        }

        if (orangeState) {
            orange.setChecked(true);
            orange.setEnabled(false);
        }
        if (redState) {
            red.setChecked(true);
            red.setEnabled(false);
        }
        if (purpleState) {
            purple.setChecked(true);
            purple.setEnabled(false);
        }

        green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (green.isChecked()) {

                    yellow.setChecked(false);
                    orange.setChecked(false);
                    red.setChecked(false);
                    purple.setChecked(false);

                    yellowState = false;
                    redState = false;
                    orangeState = false;
                    purpleState = false;
                    greenState = true;

                    green.setEnabled(false);
                    yellow.setEnabled(true);
                    orange.setEnabled(true);
                    red.setEnabled(true);
                    purple.setEnabled(true);
                }
            }
        });

        yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (yellow.isChecked()) {
                    green.setChecked(false);
                    orange.setChecked(false);
                    red.setChecked(false);
                    purple.setChecked(false);

                    greenState = false;
                    redState = false;
                    orangeState = false;
                    purpleState = false;
                    yellowState = true;

                    green.setEnabled(true);
                    yellow.setEnabled(false);
                    orange.setEnabled(true);
                    red.setEnabled(true);
                    purple.setEnabled(true);
                }
            }
        });

        orange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (orange.isChecked()) {
                    green.setChecked(false);
                    yellow.setChecked(false);
                    red.setChecked(false);
                    purple.setChecked(false);

                    greenState = false;
                    yellowState = false;
                    redState = false;
                    purpleState = false;
                    orangeState = true;

                    green.setEnabled(true);
                    yellow.setEnabled(true);
                    orange.setEnabled(false);
                    red.setEnabled(true);
                    purple.setEnabled(true);
                }
            }
        });

        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (red.isChecked()) {
                    green.setChecked(false);
                    yellow.setChecked(false);
                    orange.setChecked(false);
                    purple.setChecked(false);

                    greenState = false;
                    yellowState = false;
                    orangeState = false;
                    purpleState = false;
                    redState = true;

                    green.setEnabled(true);
                    yellow.setEnabled(true);
                    orange.setEnabled(true);
                    red.setEnabled(false);
                    purple.setEnabled(true);
                }
            }
        });

        purple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (purple.isChecked()) {
                    green.setChecked(false);
                    yellow.setChecked(false);
                    red.setChecked(false);
                    orange.setChecked(false);

                    greenState = false;
                    yellowState = false;
                    redState = false;
                    orangeState = false;
                    purpleState = true;

                    green.setEnabled(true);
                    yellow.setEnabled(true);
                    orange.setEnabled(true);
                    red.setEnabled(true);
                    purple.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent gameWindow = new Intent(OptionsActivity.this, MainActivity.class);
        startActivity(gameWindow);
        OptionsActivity.this.finish();
    }
}
