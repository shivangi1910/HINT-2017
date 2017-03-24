package com.example.shivangi.reunion;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private DBManager dbManager;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        dbManager = new DBManager(this);
        dbManager.open();

        databaseHelper = new DatabaseHelper(this);
    }

    public void Date(View view) {
        Toast.makeText(this, "Date This is my Toast message!",
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Date.class);
        startActivity(intent);
    }

    /*public void Time(View view) {
        Intent intent = new Intent(this, Time.class);
        startActivity(intent);
    }*/

    public void Venue(View view) {
        Intent intent = new Intent(this, ViewVenue.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.sign_out) {

            auth.signOut();
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            db.execSQL("delete from VENUE");

            //Toast.makeText(getApplicationContext(),"Signout method",Toast.LENGTH_LONG).show();
            FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {
                        // user auth state is changed - user is null
                        // launch login activity
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            };
            auth.addAuthStateListener(authListener);

        }
        return super.onOptionsItemSelected(item);
    }
}