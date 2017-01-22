package nf.co.projektyjava.memorymaster_v11;

/**
 * Created by Roxven on 2017-01-12.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Button;

import static nf.co.projektyjava.memorymaster_v11.OptionsActivity.greenState;
import static nf.co.projektyjava.memorymaster_v11.OptionsActivity.orangeState;
import static nf.co.projektyjava.memorymaster_v11.OptionsActivity.purpleState;
import static nf.co.projektyjava.memorymaster_v11.OptionsActivity.redState;
import static nf.co.projektyjava.memorymaster_v11.OptionsActivity.yellowState;

/**
 * Created by Roxven on 2017-01-08.
 */

public class CardButton extends Button {

    int orderNumber = 0;
    String nameNumber = "0";

    public CardButton(Context context, int orderNumber, String nameNumber) {

        super(context);
        this.orderNumber = orderNumber;
        this.nameNumber = nameNumber;
        setCardButtonsDefault();
    }

    public void setCardButtonsDefault() {
        this.setTextColor(Color.WHITE);
        this.setText("?");

        if (greenState) {
            this.setBackgroundColor(this.getResources().getColor(R.color.green, null));
        }

        if (yellowState) {
            this.setBackgroundColor(this.getResources().getColor(R.color.yellow, null));
        }

        if (orangeState) {
            this.setBackgroundColor(this.getResources().getColor(R.color.orange, null));
        }

        if (redState) {
            this.setBackgroundColor(this.getResources().getColor(R.color.red, null));
        }

        if (purpleState) {
            this.setBackgroundColor(this.getResources().getColor(R.color.purple, null));
        }

        this.setAllCaps(true);
        this.setClickable(false);
        this.setTypeface(null, Typeface.BOLD);
        this.setTextSize(8 * getResources().getDisplayMetrics().density);
    }
}
