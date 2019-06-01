package com.software.tkouleris.coinflipper;

import android.content.Context;
import android.content.res.Configuration;


public class Coin implements CoinInterface {

    private Context context;
    private int screenSize = 0;
    public static final int HEAD = 1;
    public static final int TAILS = 2;

    public Coin(Context current){

        this.context = current;


        screenSize = getScreenSize();
    }

    public int getScreenSize(){
        int screenSize = context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        return screenSize;
    }

    public int get_HeadImageSizeResource(){
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

    public int get_TailsImageSizeResource(){
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
}
