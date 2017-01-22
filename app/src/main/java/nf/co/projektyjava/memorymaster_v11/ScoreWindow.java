package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nf.co.projektyjava.memorymaster_v11.data.ScoreContract.ScoreEntry;
import nf.co.projektyjava.memorymaster_v11.data.ScoreDbHelper;

import static nf.co.projektyjava.memorymaster_v11.GameAreaActivity.attemptsNumber;
import static nf.co.projektyjava.memorymaster_v11.GameAreaActivity.czas;
import static nf.co.projektyjava.memorymaster_v11.GameAreaActivity.score;
import static nf.co.projektyjava.memorymaster_v11.GameAreaActivity.scoreString;
import static nf.co.projektyjava.memorymaster_v11.GameAreaActivity.streakCount;

public class ScoreWindow extends AppCompatActivity {

    EditText nickNameText;
    TextView finalScoreText;
    TextView finalTimeText;
    TextView finalAttemptsText;
    TextView finalStreakText;
    Button submit;
    ScoreDbHelper mDbHelper;
    SQLiteDatabase db;
    ContentValues values;

    private String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_window);

        nickNameText = (EditText) findViewById(R.id.set_nick_name);
        finalScoreText = (TextView) findViewById(R.id.final_score_text_view);
        finalTimeText = (TextView) findViewById(R.id.final_time_text_view);
        finalAttemptsText = (TextView) findViewById(R.id.final_attempts_text_view);
        finalStreakText = (TextView) findViewById(R.id.final_streak_text_view);
        submit = (Button) findViewById(R.id.submit_button);

        finalScoreText.setText("SCORE: " + scoreString);
        finalTimeText.setText("TIME: " + czas);
        finalAttemptsText.setText("ATTEMPTS: " + attemptsNumber);
        finalStreakText.setText("FINAL STREAK: " + streakCount);

        mDbHelper = new ScoreDbHelper(this);
        db = mDbHelper.getReadableDatabase();
        values = new ContentValues();

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                nickName = nickNameText.getText().toString().trim();

                if (nickName.length() == 0 || nickName.equals("") || nickName == null) {

                } else {

                    db = mDbHelper.getReadableDatabase();
                    values.put(ScoreEntry.COLUMN_NICK_NAME, nickName);
                    values.put(ScoreEntry.COLUMN_SCORE, score);
                    values.put(ScoreEntry.COLUMN_TIME, czas);
                    values.put(ScoreEntry.COLUMN_ATTEMPTS, attemptsNumber);
                    values.put(ScoreEntry.COLUMN_STREAK, streakCount);

                    db.insert(ScoreEntry.TABLE_NAME, null, values);
                    db.close();

                    backToMenu();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        backToMenu();
    }

    public void backToMenu() {
        Intent gameWindow = new Intent(ScoreWindow.this, MainActivity.class);
        startActivity(gameWindow);
        ScoreWindow.this.finish();
    }
}
