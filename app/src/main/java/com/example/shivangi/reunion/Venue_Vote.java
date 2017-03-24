package com.example.shivangi.reunion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/*import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;*/

public class Venue_Vote extends AppCompatActivity implements View.OnClickListener {

    private Button upvote;
    private DatabaseHelper databaseHelper;
    private long _id;
    private DBManager dbManager;
    //private DatabaseReference ref;
    //ref =  FirebaseDatabase.getInstance().getReference();
    //firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue__vote);

        setTitle("Upvote");
        Intent intent = getIntent();
        dbManager = new DBManager(this);
        dbManager.open();
        databaseHelper = new DatabaseHelper(this);
        upvote=(Button) findViewById (R.id.Votebutton);

        //ref =  FirebaseDatabase.getInstance().getReference();
        //firebaseAuth = FirebaseAuth.getInstance();
        //set onclicklistener for your button
        //Toast.makeText(getApplicationContext(), "AboveOnClickListener",
          //      Toast.LENGTH_LONG).show();
        upvote.setOnClickListener(this); //this);

                /*new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();
                        TextView Vote = (TextView) v; //findViewById(R.id.votes);
                        Vote.setText(Integer.parseInt(Vote.getText().toString()) + 1);


                    }
                });*/
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(), "OnButtonClick!",
          //      Toast.LENGTH_LONG).show();
        switch (v.getId()) {
            case R.id.Votebutton:
                //Intent main = new Intent(Venue_Vote.this, ViewVenue.class)
                //      .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                TextView Vote = (TextView)findViewById(R.id.noOfVotes);
                //Vote.setText((Integer.parseInt(Vote.getText().toString()) + 1).toString());

                String s= Vote.getText().toString();
                //Toast.makeText(getApplicationContext(), s,
                  //      Toast.LENGTH_LONG).show();
                int number = 0;
                for (int i = 0; i < s.length(); i++)
                {
                    number = number * 10 + s.charAt(i) - '0';
                }
                //int v1 = Integer.parseInt(s);
                number++;
                //Toast.makeText(getApplicationContext(), number,
                //      Toast.LENGTH_LONG).show();
                Vote.setText(String.valueOf(number));
                //startActivity(main);
                break;
        }

    /*public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ViewVenue.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);*/
    }
    /*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Votebutton:

                TextView Vote = (TextView) findViewById(R.id.votes);
                Vote.setText(Integer.parseInt(Vote.getText().toString())+1);


        }
    }
    void Vote(View v) {
        Toast.makeText(getApplicationContext(), "This is my Toast message!",
                Toast.LENGTH_LONG).show();
        TextView Vote = (TextView)v; //findViewById(R.id.votes);
        Vote.setText(Integer.parseInt(Vote.getText().toString())+1);

    }*/
}
