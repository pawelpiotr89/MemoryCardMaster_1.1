package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import nf.co.projektyjava.memorymaster_v11.data.ScoreContract;
import nf.co.projektyjava.memorymaster_v11.data.ScoreDbHelper;

public class CheckScoreActivity extends AppCompatActivity {

    TextView namePosition1;
    TextView scorePosition1;
    TextView timePosition1;
    TextView attemptsPosition1;


    TextView namePosition2;
    TextView scorePosition2;
    TextView timePosition2;
    TextView attemptsPosition2;


    TextView namePosition3;
    TextView scorePosition3;
    TextView timePosition3;
    TextView attemptsPosition3;


    TextView namePosition4;
    TextView scorePosition4;
    TextView timePosition4;
    TextView attemptsPosition4;


    TextView namePosition5;
    TextView scorePosition5;
    TextView timePosition5;
    TextView attemptsPosition5;

    TextView namePosition6;
    TextView scorePosition6;
    TextView timePosition6;
    TextView attemptsPosition6;

    TextView namePosition7;
    TextView scorePosition7;
    TextView timePosition7;
    TextView attemptsPosition7;

    TextView namePosition8;
    TextView scorePosition8;
    TextView timePosition8;
    TextView attemptsPosition8;

    TextView namePosition9;
    TextView scorePosition9;
    TextView timePosition9;
    TextView attemptsPosition9;

    TextView namePosition10;
    TextView scorePosition10;
    TextView timePosition10;
    TextView attemptsPosition10;


    Cursor cursor;

    ScoreDbHelper mDbHelper;
    SQLiteDatabase db;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        namePosition1 = (TextView) findViewById(R.id.text_view_1_row_1);
        scorePosition1 = (TextView) findViewById(R.id.text_view_2_row_1);
        timePosition1 = (TextView) findViewById(R.id.text_view_3_row_1);
        attemptsPosition1 = (TextView) findViewById(R.id.text_view_4_row_1);


        namePosition2 = (TextView) findViewById(R.id.text_view_1_row_2);
        scorePosition2 = (TextView) findViewById(R.id.text_view_2_row_2);
        timePosition2 = (TextView) findViewById(R.id.text_view_3_row_2);
        attemptsPosition2 = (TextView) findViewById(R.id.text_view_4_row_2);


        namePosition3 = (TextView) findViewById(R.id.text_view_1_row_3);
        scorePosition3 = (TextView) findViewById(R.id.text_view_2_row_3);
        timePosition3 = (TextView) findViewById(R.id.text_view_3_row_3);
        attemptsPosition3 = (TextView) findViewById(R.id.text_view_4_row_3);


        namePosition4 = (TextView) findViewById(R.id.text_view_1_row_4);
        scorePosition4 = (TextView) findViewById(R.id.text_view_2_row_4);
        timePosition4 = (TextView) findViewById(R.id.text_view_3_row_4);
        attemptsPosition4 = (TextView) findViewById(R.id.text_view_4_row_4);


        namePosition5 = (TextView) findViewById(R.id.text_view_1_row_5);
        scorePosition5 = (TextView) findViewById(R.id.text_view_2_row_5);
        timePosition5 = (TextView) findViewById(R.id.text_view_3_row_5);
        attemptsPosition5 = (TextView) findViewById(R.id.text_view_4_row_5);

        namePosition6 = (TextView) findViewById(R.id.text_view_1_row_6);
        scorePosition6 = (TextView) findViewById(R.id.text_view_2_row_6);
        timePosition6 = (TextView) findViewById(R.id.text_view_3_row_6);
        attemptsPosition6 = (TextView) findViewById(R.id.text_view_4_row_6);

        namePosition7 = (TextView) findViewById(R.id.text_view_1_row_7);
        scorePosition7 = (TextView) findViewById(R.id.text_view_2_row_7);
        timePosition7 = (TextView) findViewById(R.id.text_view_3_row_7);
        attemptsPosition7 = (TextView) findViewById(R.id.text_view_4_row_7);

        namePosition8 = (TextView) findViewById(R.id.text_view_1_row_8);
        scorePosition8 = (TextView) findViewById(R.id.text_view_2_row_8);
        timePosition8 = (TextView) findViewById(R.id.text_view_3_row_8);
        attemptsPosition8 = (TextView) findViewById(R.id.text_view_4_row_8);

        namePosition9 = (TextView) findViewById(R.id.text_view_1_row_9);
        scorePosition9 = (TextView) findViewById(R.id.text_view_2_row_9);
        timePosition9 = (TextView) findViewById(R.id.text_view_3_row_9);
        attemptsPosition9 = (TextView) findViewById(R.id.text_view_4_row_9);

        namePosition10 = (TextView) findViewById(R.id.text_view_1_row_10);
        scorePosition10 = (TextView) findViewById(R.id.text_view_2_row_10);
        timePosition10 = (TextView) findViewById(R.id.text_view_3_row_10);
        attemptsPosition10 = (TextView) findViewById(R.id.text_view_4_row_10);

        mDbHelper = new ScoreDbHelper(this);
        db = mDbHelper.getReadableDatabase();

        displayData();

    }

    public void displayData() {

        counter = 0;

        try {
            String[] project = {
                    ScoreContract.ScoreEntry._ID,
                    ScoreContract.ScoreEntry.COLUMN_NICK_NAME,
                    ScoreContract.ScoreEntry.COLUMN_SCORE,
                    ScoreContract.ScoreEntry.COLUMN_TIME,
                    ScoreContract.ScoreEntry.COLUMN_ATTEMPTS,
                    ScoreContract.ScoreEntry.COLUMN_STREAK

            };

            cursor = db.query(
                    ScoreContract.ScoreEntry.TABLE_NAME,
                    project,
                    null,
                    null,
                    null,
                    null,
                    ScoreContract.ScoreEntry.COLUMN_SCORE + " ASC, " + ScoreContract.ScoreEntry.COLUMN_ATTEMPTS + " ASC, " + ScoreContract.ScoreEntry.COLUMN_TIME + " ASC");

            int idColumnIndex = cursor.getColumnIndex(ScoreContract.ScoreEntry._ID);
            int idNickName = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_NICK_NAME);
            int idScore = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE);
            int idTime = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_TIME);
            int idAttempts = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_ATTEMPTS);
            int idStreak = cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_STREAK);

            while (cursor.moveToNext()) {

                int columnIndex = cursor.getInt(idColumnIndex);
                String nickName = cursor.getString(idNickName);
                String score = cursor.getString(idScore);
                String time = cursor.getString(idTime);
                String attempts = cursor.getString(idAttempts);
                String streak = cursor.getString(idStreak);

                switch (counter) {

                    case 0:
                        namePosition1.setText(nickName);
                        scorePosition1.setText(score);
                        timePosition1.setText(time);
                        attemptsPosition1.setText(attempts);
                        break;

                    case 1:
                        namePosition2.setText(nickName);
                        scorePosition2.setText(score);
                        timePosition2.setText(time);
                        attemptsPosition2.setText(attempts);
                        break;

                    case 2:
                        namePosition3.setText(nickName);
                        scorePosition3.setText(score);
                        timePosition3.setText(time);
                        attemptsPosition3.setText(attempts);
                        break;

                    case 3:
                        namePosition4.setText(nickName);
                        scorePosition4.setText(score);
                        timePosition4.setText(time);
                        attemptsPosition4.setText(attempts);
                        break;

                    case 4:
                        namePosition5.setText(nickName);
                        scorePosition5.setText(score);
                        timePosition5.setText(time);
                        attemptsPosition5.setText(attempts);
                        break;

                    case 5:
                        namePosition6.setText(nickName);
                        scorePosition6.setText(score);
                        timePosition6.setText(time);
                        attemptsPosition6.setText(attempts);
                        break;

                    case 6:
                        namePosition7.setText(nickName);
                        scorePosition7.setText(score);
                        timePosition7.setText(time);
                        attemptsPosition7.setText(attempts);
                        break;

                    case 7:
                        namePosition8.setText(nickName);
                        scorePosition8.setText(score);
                        timePosition8.setText(time);
                        attemptsPosition8.setText(attempts);
                        break;

                    case 8:
                        namePosition9.setText(nickName);
                        scorePosition9.setText(score);
                        timePosition9.setText(time);
                        attemptsPosition9.setText(attempts);
                        break;

                    case 9:
                        namePosition10.setText(nickName);
                        scorePosition10.setText(score);
                        timePosition10.setText(time);
                        attemptsPosition10.setText(attempts);
                        break;

                    case 10:
                        int idNumber = columnIndex;
                        db.delete(ScoreContract.ScoreEntry.TABLE_NAME, ScoreContract.ScoreEntry._ID + " = " + idNumber, null);
                        break;

                }

                counter++;

            }

        } finally {
            cursor.close();
            db.close();
        }
    }

    @Override
    public void onBackPressed() {
        Intent gameWindow = new Intent(CheckScoreActivity.this, MainActivity.class);
        startActivity(gameWindow);
        CheckScoreActivity.this.finish();
    }
}
