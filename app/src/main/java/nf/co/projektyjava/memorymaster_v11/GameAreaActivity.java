package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

////////////////////////////////////////////////////////////////////////////////////////////////////
public class GameAreaActivity extends AppCompatActivity {

    public static int attemptsNumber = 0;
    public static String scoreString = "";
    public static String czas = "";
    public static int streakCount = 0;
    public static double score = 0;
    LinearLayout linearLayout;
    TableLayout tableLayout;
    TableRow tableRow1;
    TableRow tableRow2;
    TableRow tableRow3;
    TableRow tableRow4;
    TableRow tableRow5;
    TableRow tableRow6;
    TableRow tableRow7;
    TableRow tableRow8;
    TableRow tableRow9;
    TableRow.LayoutParams params;
    CardButton cardButton01;
    CardButton cardButton01Bis;
    CardButton cardButton02;
    CardButton cardButton02Bis;
    CardButton cardButton03;
    CardButton cardButton03Bis;
    CardButton cardButton04;
    CardButton cardButton04Bis;
    CardButton cardButton05;
    CardButton cardButton05Bis;
    CardButton cardButton06;
    CardButton cardButton06Bis;
    CardButton cardButton07;
    CardButton cardButton07Bis;
    CardButton cardButton08;
    CardButton cardButton08Bis;
    CardButton cardButton09;
    CardButton cardButton09Bis;
    CardButton cardButton10;
    CardButton cardButton10Bis;
    CardButton cardButton11;
    CardButton cardButton11Bis;
    CardButton cardButton12;
    CardButton cardButton12Bis;
    CardButton cardButton13;
    CardButton cardButton13Bis;
    CardButton cardButton14;
    CardButton cardButton14Bis;
    CardButton cardButton15;
    CardButton cardButton15Bis;
    CardButton cardButton16;
    CardButton cardButton16Bis;
    CardButton cardButton17;
    CardButton cardButton17Bis;
    CardButton cardButton18;
    CardButton cardButton18Bis;
    CardButton cardButton19;
    CardButton cardButton19Bis;
    CardButton cardButton20;
    CardButton cardButton20Bis;
    CardButton cardButton21;
    CardButton cardButton21Bis;
    CardButton cardButton22;
    CardButton cardButton22Bis;
    CardButton cardButton23;
    CardButton cardButton23Bis;
    CardButton cardButton24;
    CardButton cardButton24Bis;
    CardButton cardButton25;
    CardButton cardButton25Bis;
    CardButton cardButton26;
    CardButton cardButton26Bis;
    CardButton cardButton27;
    CardButton cardButton27Bis;
    Point size;
    ArrayList<CardButton> list;
    Handler handler;
    TextView czasText;
    TextView scoreText;
    TextView attempts;
    TextView streak;
    GradientDrawable drawable;
    CardButton comparableCard1;
    CardButton comparableCard2;
    boolean stanGry = false;
    long millisecondTime, startTime, timeBuff, updateTime = 0;
    int seconds, minutes, milliSeconds = 0;
    int comparableCardState = 0;
    int pairs = 0;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public Runnable runnable = new Runnable() {

        public void run() {

            millisecondTime = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecondTime;
            seconds = (int) (updateTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliSeconds = (int) (updateTime % 1000);
            czas = "" + minutes + ":" + String.format("%02d", seconds) + ":" + String.format("%03d", milliSeconds);
            czasText.setText(czas);
            countScore();
            scoreText.setText(scoreString);
            attempts.setText("" + attemptsNumber);
            streak.setText("" + streakCount);

            handler.postDelayed(this, 0);

            if (pairs == 27) {

                handler.removeCallbacks(runnable);

                Intent gameWindow = new Intent(GameAreaActivity.this, ScoreWindow.class);
                startActivity(gameWindow);
                GameAreaActivity.this.finish();
            }
        }
    };
    double leftRightMargin = 0;
    int leftRightMarginINT = 0;
    double topBottomMargin = 0;
    int topBottomMarginINT = 0;
    double buttonHeight = 0;
    int buttonHeightInt = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_area);

        linearLayout = (LinearLayout) findViewById(R.id.activity_game_area);
        tableLayout = (TableLayout) findViewById(R.id.table_layout);

        tableRow1 = (TableRow) findViewById(R.id.row1);
        tableRow2 = (TableRow) findViewById(R.id.row2);
        tableRow3 = (TableRow) findViewById(R.id.row3);
        tableRow4 = (TableRow) findViewById(R.id.row4);
        tableRow5 = (TableRow) findViewById(R.id.row5);
        tableRow6 = (TableRow) findViewById(R.id.row6);
        tableRow7 = (TableRow) findViewById(R.id.row7);
        tableRow8 = (TableRow) findViewById(R.id.row8);
        tableRow9 = (TableRow) findViewById(R.id.row9);

        cardButton01 = new CardButton(this, 1, "1");
        cardButton01Bis = new CardButton(this, 1, "1");
        cardButton02 = new CardButton(this, 2, "2");
        cardButton02Bis = new CardButton(this, 2, "2");
        cardButton03 = new CardButton(this, 3, "3");
        cardButton03Bis = new CardButton(this, 3, "3");
        cardButton04 = new CardButton(this, 4, "4");
        cardButton04Bis = new CardButton(this, 4, "4");
        cardButton05 = new CardButton(this, 5, "5");
        cardButton05Bis = new CardButton(this, 5, "5");
        cardButton06 = new CardButton(this, 6, "6");
        cardButton06Bis = new CardButton(this, 6, "6");
        cardButton07 = new CardButton(this, 7, "7");
        cardButton07Bis = new CardButton(this, 7, "7");
        cardButton08 = new CardButton(this, 8, "8");
        cardButton08Bis = new CardButton(this, 8, "8");
        cardButton09 = new CardButton(this, 9, "9");
        cardButton09Bis = new CardButton(this, 9, "9");
        cardButton10 = new CardButton(this, 10, "10");
        cardButton10Bis = new CardButton(this, 10, "10");
        cardButton11 = new CardButton(this, 11, "11");
        cardButton11Bis = new CardButton(this, 11, "11");
        cardButton12 = new CardButton(this, 12, "12");
        cardButton12Bis = new CardButton(this, 12, "12");
        cardButton13 = new CardButton(this, 13, "13");
        cardButton13Bis = new CardButton(this, 13, "13");
        cardButton14 = new CardButton(this, 14, "14");
        cardButton14Bis = new CardButton(this, 14, "14");
        cardButton15 = new CardButton(this, 15, "15");
        cardButton15Bis = new CardButton(this, 15, "15");
        cardButton16 = new CardButton(this, 16, "16");
        cardButton16Bis = new CardButton(this, 16, "16");
        cardButton17 = new CardButton(this, 17, "17");
        cardButton17Bis = new CardButton(this, 17, "17");
        cardButton18 = new CardButton(this, 18, "18");
        cardButton18Bis = new CardButton(this, 18, "18");
        cardButton19 = new CardButton(this, 19, "19");
        cardButton19Bis = new CardButton(this, 19, "19");
        cardButton20 = new CardButton(this, 20, "20");
        cardButton20Bis = new CardButton(this, 20, "20");
        cardButton21 = new CardButton(this, 21, "21");
        cardButton21Bis = new CardButton(this, 21, "21");
        cardButton22 = new CardButton(this, 22, "22");
        cardButton22Bis = new CardButton(this, 22, "22");
        cardButton23 = new CardButton(this, 23, "23");
        cardButton23Bis = new CardButton(this, 23, "23");
        cardButton24 = new CardButton(this, 24, "24");
        cardButton24Bis = new CardButton(this, 24, "24");
        cardButton25 = new CardButton(this, 25, "25");
        cardButton25Bis = new CardButton(this, 25, "25");
        cardButton26 = new CardButton(this, 26, "26");
        cardButton26Bis = new CardButton(this, 26, "26");
        cardButton27 = new CardButton(this, 27, "27");
        cardButton27Bis = new CardButton(this, 27, "27");

        list = new ArrayList<>(54);

        list.add(cardButton01);
        list.add(cardButton01Bis);
        list.add(cardButton02);
        list.add(cardButton02Bis);
        list.add(cardButton03);
        list.add(cardButton03Bis);
        list.add(cardButton04);
        list.add(cardButton04Bis);
        list.add(cardButton05);
        list.add(cardButton05Bis);
        list.add(cardButton06);
        list.add(cardButton06Bis);
        list.add(cardButton07);
        list.add(cardButton07Bis);
        list.add(cardButton08);
        list.add(cardButton08Bis);
        list.add(cardButton09);
        list.add(cardButton09Bis);
        list.add(cardButton10);
        list.add(cardButton10Bis);
        list.add(cardButton11);
        list.add(cardButton11Bis);
        list.add(cardButton12);
        list.add(cardButton12Bis);
        list.add(cardButton13);
        list.add(cardButton13Bis);
        list.add(cardButton14);
        list.add(cardButton14Bis);
        list.add(cardButton15);
        list.add(cardButton15Bis);
        list.add(cardButton16);
        list.add(cardButton16Bis);
        list.add(cardButton17);
        list.add(cardButton17Bis);
        list.add(cardButton18);
        list.add(cardButton18Bis);
        list.add(cardButton19);
        list.add(cardButton19Bis);
        list.add(cardButton20);
        list.add(cardButton20Bis);
        list.add(cardButton21);
        list.add(cardButton21Bis);
        list.add(cardButton22);
        list.add(cardButton22Bis);
        list.add(cardButton23);
        list.add(cardButton23Bis);
        list.add(cardButton24);
        list.add(cardButton24Bis);
        list.add(cardButton25);
        list.add(cardButton25Bis);
        list.add(cardButton26);
        list.add(cardButton26Bis);
        list.add(cardButton27);
        list.add(cardButton27Bis);

        size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        final int screenWidth = size.x;
        final int screenHeight = size.y;
        leftRightMargin = (screenWidth / 180);
        leftRightMarginINT = (int) leftRightMargin;
        topBottomMargin = ((screenHeight * 0.8) / 256);
        topBottomMarginINT = (int) topBottomMargin;
        buttonHeight = (screenHeight / 13);
        buttonHeightInt = (int) buttonHeight;

        params = new TableRow.LayoutParams();
        params.weight = 1;
        params.height = buttonHeightInt;
        params.gravity = Gravity.CENTER;
        params.setMargins(leftRightMarginINT, topBottomMarginINT, leftRightMarginINT, topBottomMarginINT);

        czasText = (TextView) findViewById(R.id.count_time);
        scoreText = (TextView) findViewById(R.id.count_score);
        attempts = (TextView) findViewById(R.id.count_attempt);
        streak = (TextView) findViewById(R.id.count_streak);

        handler = new Handler();

        drawable = new GradientDrawable();
        drawable.setStroke(leftRightMarginINT * 2, this.getResources().getColor(R.color.clickedColorCard, null));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void start(View view) {
        if (!stanGry) {

            timeBuff = 0;
            startTime = 0;
            attemptsNumber = 0;
            pairs = 0;
            score = 0;
            czas = "";
            scoreString = "";
            streakCount = 0;
            Collections.shuffle(list);
            addingCardButtons();
            addCardListeners();

            stanGry = true;
            startTime = SystemClock.uptimeMillis();
            handler.postDelayed(runnable, 0);

            updateButtons();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onBackPressed() {

        handler.removeCallbacks(runnable);
        Intent gameWindow = new Intent(GameAreaActivity.this, MainActivity.class);
        startActivity(gameWindow);
        GameAreaActivity.this.finish();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void addingCardButtons() {

        for (int i = 0; i < list.size(); i++) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    tableRow1.addView(list.get(i), params);
                    break;

                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    tableRow2.addView(list.get(i), params);
                    break;

                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    tableRow3.addView(list.get(i), params);
                    break;

                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    tableRow4.addView(list.get(i), params);
                    break;

                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    tableRow5.addView(list.get(i), params);
                    break;

                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                    tableRow6.addView(list.get(i), params);
                    break;

                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                    tableRow7.addView(list.get(i), params);
                    break;

                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                    tableRow8.addView(list.get(i), params);
                    break;

                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                    tableRow9.addView(list.get(i), params);
                    break;
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void addCardListeners() {

        for (int i = 0; i < list.size(); i++) {

            final int finalI = i;
            list.get(i).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    switch (comparableCardState) {
                        case 0:
                            comparableCard1 = list.get(finalI);
                            comparableCard1.setTextColor(Color.BLACK);
                            comparableCard1.setClickable(false);
                            comparableCardState = 1;
                            break;
                        case 1:
                            comparableCard2 = list.get(finalI);
                            comparableCard2.setTextColor(Color.BLACK);
                            comparableCard2.setClickable(false);

                            if (comparableCard1.orderNumber == comparableCard2.orderNumber) {
                                comparableCard1.setTextColor(getResources().getColor(R.color.clickedColorCard, null));
                                comparableCard2.setTextColor(getResources().getColor(R.color.clickedColorCard, null));
                                comparableCard1 = null;
                                comparableCard2 = null;
                                comparableCardState = 0;
                                pairs++;
                                attemptsNumber++;
                                streakCount++;
                            } else {
                                comparableCard1.setTextColor(Color.RED);
                                comparableCard2.setTextColor(Color.RED);
                                comparableCardState = 2;
                                attemptsNumber++;
                                streakCount = 0;
                            }
                            break;
                        case 2:
                            comparableCard1.setCardButtonsDefault();
                            comparableCard2.setCardButtonsDefault();
                            comparableCard1.setClickable(true);
                            comparableCard2.setClickable(true);
                            comparableCard1 = null;
                            comparableCard2 = null;
                            comparableCard1 = list.get(finalI);
                            comparableCard1.setTextColor(Color.BLACK);
                            comparableCard1.setClickable(false);

                            comparableCardState = 1;
                            break;
                    }

                    if (Objects.equals(v, list.get(finalI))) {
                        list.get(finalI).setBackground(drawable);
                        list.get(finalI).setText(list.get(finalI).nameNumber);
                    }
                }
            });
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void countScore() {
        score = (updateTime * 0.001) + ((updateTime * 0.0001) * (attemptsNumber)) + (attemptsNumber * 0.01);
        score = score * 100;
        score = Math.round(score);
        score = score / 100;
        scoreString = String.format("%.3f", score);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public void updateButtons() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setClickable(true);
        }
    }
}