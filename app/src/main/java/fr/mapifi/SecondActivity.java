package fr.mapifi;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by user on 22/06/2016.
 */
public class SecondActivity extends  MainActivity{
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        imgView = (ImageView) findViewById(R.id.img);

    }
}
