package com.software.tkouleris.coinflipper;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init everything
        initialize();

        final ImageView image = findViewById(R.id.img_coin);

        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                flipTheCoin(image);
            }
        });
    }

    private void initialize(){
        int screenSize = 0;
        int imageResource;
        displayMessage("Πατήστε το νόμισμα για να γυρίσει...");
        screenSize = getScreenSize();
        imageResource = get_HeadImageSizeResource(screenSize);

        ImageView image = findViewById(R.id.img_coin);
        image.setImageResource(imageResource);
    }

    private int get_HeadImageSizeResource(int screenSize){
        int imageResource;

        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                imageResource = R.drawable.head_normal;
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                imageResource = R.drawable.head_small;
                break;
            default:
                imageResource = R.drawable.head_normal;
        }

        return imageResource;
    }

    private int get_TailsImageSizeResource(int screenSize){
        int imageResource;

        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                imageResource = R.drawable.tails_normal;
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                imageResource = R.drawable.tails_small;
                break;
            default:
                imageResource = R.drawable.tails_normal;
        }

        return imageResource;
    }

    private int getScreenSize(){
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        return screenSize;
    }

    private void flipTheCoin(ImageView image){
        double tailsOrHead = 0.0;
        int screenSize = 0;
        int imageHeadResource = 0;
        int imageTailsResource = 0;
        String msg = "";

        screenSize = getScreenSize();
        imageHeadResource = get_HeadImageSizeResource(screenSize);
        imageTailsResource = get_TailsImageSizeResource(screenSize);

        tailsOrHead = RandomNumberBetween(1,2);

        if( (int)tailsOrHead == CoinSide.HEAD ) {
            image.setImageResource(imageHeadResource);
            msg = "Κορώνα!";
        }

        if( (int)tailsOrHead == CoinSide.TAILS ) {
            image.setImageResource(imageTailsResource);
            msg = "Γράμματα!";
        }

        displayMessage(msg);
    }

    private double RandomNumberBetween(int min, int max){
        double x = (Math.random()*((max-min)+1))+min;

        return x;
    }

    private void displayMessage(String msgToDisplay){

        Toast toast = Toast.makeText(getApplicationContext(),
                msgToDisplay,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 100);

        View view = toast.getView();
        view.setBackgroundColor(Color.BLACK);

        TextView txtMsg = toast.getView().findViewById(android.R.id.message);
        txtMsg.setTextColor(Color.WHITE);

        toast.show();

    }
}
