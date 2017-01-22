package nf.co.projektyjava.memorymaster_v11.data;

import android.provider.BaseColumns;

/**
 * Created by Roxven on 2017-01-15.
 */

public class ScoreContract implements BaseColumns {

    private ScoreContract() {
    }

    public static final class ScoreEntry implements BaseColumns {

        public final static String TABLE_NAME = "score";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NICK_NAME = "nick_name";
        public final static String COLUMN_SCORE = "score";
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_ATTEMPTS = "attempts";
        public final static String COLUMN_STREAK = "streak";
    }
}

