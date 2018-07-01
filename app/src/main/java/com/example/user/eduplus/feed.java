package com.example.user.eduplus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class feed extends AppCompatActivity {
    ImageView feed,write;
    DatabaseHelper mDataHelper;
    ListView mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mylist = (ListView)findViewById(R.id.listjournal);
        mDataHelper = new DatabaseHelper(this);
        populatelistView();

        feed=(ImageView)findViewById(R.id.feed);
        write=(ImageView)findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(feed.this,write.class);
                startActivity(intent);
            }
        });


    }

    private void populatelistView() {
        Cursor data = mDataHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mylist.setAdapter(adapter);

    }


}
