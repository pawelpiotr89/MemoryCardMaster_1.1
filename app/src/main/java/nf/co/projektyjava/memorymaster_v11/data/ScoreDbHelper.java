package nf.co.projektyjava.memorymaster_v11.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nf.co.projektyjava.memorymaster_v11.data.ScoreContract.ScoreEntry;

/**
 * Created by Roxven on 2017-01-15.
 */

public class ScoreDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "score.db";
    private static final int DATABASE_VERSION = 1;

    public ScoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_SCORE_TABLE = "CREATE TABLE " + ScoreEntry.TABLE_NAME + " ("
                + ScoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ScoreEntry.COLUMN_NICK_NAME + " TEXT NOT NULL, "
                + ScoreEntry.COLUMN_SCORE + " REAL NOT NULL, "
                + ScoreEntry.COLUMN_TIME + " TEXT NOT NULL, "
                + ScoreEntry.COLUMN_ATTEMPTS + " INTEGER NOT NULL, "
                + ScoreEntry.COLUMN_STREAK + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_SCORE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
