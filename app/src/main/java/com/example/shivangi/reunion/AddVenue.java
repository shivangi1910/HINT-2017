package com.example.shivangi.reunion;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shivangi on 16/3/17.
 */

public class AddVenue extends AppCompatActivity implements OnClickListener {

    StringBuilder sb;
    Cursor cursor;
    private Button addTodoBtn;
    private EditText subjectEditText;
    private com.example.shivangi.reunion.DBManager dbManager;
    private com.example.shivangi.reunion.DatabaseHelper databaseHelper;
    private List<String> list;
    final static int REQ_CODE = 1;

    private final int RESULT_OK = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setTitle("Add Record");

        setContentView(R.layout.activity_add_venue);

        subjectEditText = (EditText) findViewById(R.id.subject_edittext);

        list = new ArrayList<String>();
        sb = new StringBuilder();
        addTodoBtn = (Button) findViewById(R.id.add_record);
        dbManager = new com.example.shivangi.reunion.DBManager(this);
        databaseHelper = new com.example.shivangi.reunion.DatabaseHelper(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();

                dbManager.insert(name);
                cursor = dbManager.fetch();

                if (cursor.moveToFirst()) {
                    do {
                        String data = cursor.getString(cursor.getColumnIndex("subject"));
                        list.add(data);

                    } while (cursor.moveToNext());
                }
                // User u = new User(username , list);
                cursor.close();
                //String username = "";
                // Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

                Intent main = new Intent(AddVenue.this, com.example.shivangi.reunion.ViewVenue.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    String string = data.getStringExtra("term");
                    subjectEditText.setText(string);
                }
                break;
            }

        }
    }

}