package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        MainActivity.this.finish();
        this.finishAffinity();
    }

    public void startGame(View view) {
        Intent gameWindow = new Intent(MainActivity.this, GameAreaActivity.class);
        startActivity(gameWindow);
        MainActivity.this.finish();
    }

    public void goToOptions(View view) {
        Intent gameWindow = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(gameWindow);
        MainActivity.this.finish();
    }

    public void goToScoreList(View view) {
        Intent gameWindow = new Intent(MainActivity.this, CheckScoreActivity.class);
        startActivity(gameWindow);
        MainActivity.this.finish();

    }

    public void exitGame(View view) {
        MainActivity.this.finish();
        this.finishAffinity();
    }
}
