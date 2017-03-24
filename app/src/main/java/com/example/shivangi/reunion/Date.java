package com.example.shivangi.reunion;

import android.os.Bundle;
import android.app.Activity;
//import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * Created by shivangi on 16/3/17.
 */

public class Date extends AppCompatActivity  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setTitle("Add Record");

        setContentView(R.layout.activity_date);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

}