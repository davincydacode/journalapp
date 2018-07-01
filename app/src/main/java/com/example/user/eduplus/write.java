package com.example.user.eduplus;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class write extends AppCompatActivity {
    ImageView feed,write;
    EditText journaltitle,journalmessage;
    Button save;
    DatabaseHelper mDatabaseHelper;
    SharedPreferences myPreferences
            = PreferenceManager.getDefaultSharedPreferences(write.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        feed=(ImageView)findViewById(R.id.feed);
        write=(ImageView)findViewById(R.id.write);
        journalmessage = (EditText)findViewById(R.id.journalmessage);
        journaltitle = (EditText)findViewById(R.id.title);
        save = (Button)findViewById(R.id.save);
        mDatabaseHelper = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = journaltitle.getText().toString();
                String message = journalmessage.getText().toString();
                String email = myPreferences.getString("NAME", "unknown");
                addEntry(title,message,email);

            }
        });






    }

    public void addEntry(String title,String message,String email){
        boolean insertData = mDatabaseHelper.AddData(title,message,email);
        if(insertData){
            Toast.makeText(getBaseContext(),"Journal Successfully Saved",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(write.this,feed.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_LONG).show();
        }
    }


}

