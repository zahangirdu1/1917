package com.notes.iit.simplenotesmanager;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesListActivity extends AppCompatActivity {
    FloatingActionButton noteEditOpenButton;
    ListView listView;
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        initalizeViews();
        noteEditOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NotesListActivity.this, ListEditActivity.class);
                startActivity(intent);
            }
        });
        sqliteHelper=new SqliteHelper(this);
        Cursor cursor= sqliteHelper.retriveAllNotesCursor();
        CursorAdapter cursorAdapter=new NotesListAdapter(this,cursor);
        listView.setAdapter(cursorAdapter);

    }

    private void initalizeViews() {
        noteEditOpenButton=(FloatingActionButton)findViewById(R.id.fab);
        listView=(ListView)findViewById(R.id.list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.edit_user,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.editInfo:
                Intent intent = new Intent(NotesListActivity.this, EditInfo.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
