package com.example.shivangi.reunion;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class ViewVenue extends AppCompatActivity {

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.SUBJECT ,DatabaseHelper.VOTES};
    final int[] to = new int[] { R.id.id, R.id.title };
    private DBManager dbManager;
    private DatabaseHelper databaseHelper;
    private SimpleCursorAdapter adapter;
    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.emptylist);
        Intent intent = getIntent();
        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        list = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        //change

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_venue, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);



        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), Venue_Vote.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("id", id);
                startActivity(modify_intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddVenue.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
        //return true;
    }
}