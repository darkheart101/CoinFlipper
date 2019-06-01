package com.software.tkouleris.coinflipper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        final Coin coin = new Coin(context );

        // Init everything
        initialize(coin);

        final ImageView image = findViewById(R.id.img_coin);


        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                int imageHeadResource = coin.get_HeadImageSizeResource();
                int imageTailsResource = coin.get_TailsImageSizeResource();

                double tailsOrHead = flipTheCoin();

                String msg = "";
                if( (int)tailsOrHead == coin.HEAD ) {
                    image.setImageResource(imageHeadResource);
                    msg = "Κορώνα!";
                }

                if( (int)tailsOrHead == coin.TAILS ) {
                    image.setImageResource(imageTailsResource);
                    msg = "Γράμματα!";
                }

                displayMessage(msg);
            }
        });
    }

    private void initialize(CoinInterface coin){
        int imageResource;
        displayMessage("Πατήστε το νόμισμα για να γυρίσει...");
        imageResource = coin.get_HeadImageSizeResource();

        ImageView image = findViewById(R.id.img_coin);
        image.setImageResource(imageResource);
    }

    private double flipTheCoin(){
        double tailsOrHead = 0.0;

        tailsOrHead = RandomNumberBetween(1,2);

        return tailsOrHead;
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
