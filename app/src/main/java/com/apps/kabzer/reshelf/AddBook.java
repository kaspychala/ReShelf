package com.apps.kabzer.reshelf;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity{
    EditText author;
    EditText title;
    Button addBook;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        author = (EditText)findViewById(R.id.EditAuthor);
        title = (EditText)findViewById(R.id.EditTitle);
        addBook = (Button)findViewById(R.id.add);
        intent = new Intent(this,ReshelfActivity.class);

        final DatabaseHandler db = new DatabaseHandler(this);

        addBook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                db.addBook(new Books(author.getText().toString(), title.getText().toString()));
                startActivity(intent);
                finish();
                }
        });

        FloatingActionButton addPhoto = (FloatingActionButton) findViewById(R.id.addPhoto);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onBackPressed() {
       finish();
    }

}
