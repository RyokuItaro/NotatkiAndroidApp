package com.example.notatkiappstudiamobilki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class NoteActivity extends AppCompatActivity {
    public static final String notePos = "com.example.notatkiappstudiamobilki.notePos";
    private NoteInfo note;
    private Boolean creatingNewNote;
    private EditText textTitleNote;
    private EditText textContentNote;
    private int newNotePos;
    private boolean noteCancelling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readNoteValues();

        textTitleNote = findViewById(R.id.textTitleNote);
        textContentNote = findViewById(R.id.textContentNote);

        if(note != null){
            textTitleNote.setText(note.getTitle());
            textContentNote.setText(note.getText());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(noteCancelling){
            if(creatingNewNote){
                DataManager.getInstance().removeNote(newNotePos);
            }
        }
        else{
            saveNote();
        }
    }

    private void saveNote() {
        note.setTitle(textTitleNote.getText().toString());
        note.setText(textContentNote.getText().toString());
    }

    private void readNoteValues() {
        Intent intent = getIntent();
        int pos = intent.getIntExtra(notePos, -1);
        creatingNewNote = pos == -1;
        if(creatingNewNote){
            createNewNote();
        }
        else{
            note = DataManager.getInstance().getNotes().get(pos);
        }
    }

    private void createNewNote() {
        DataManager dm = DataManager.getInstance();
        newNotePos = dm.createNewNote();
        note = dm.getNotes().get(newNotePos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.actionSendEmail) {
            String title = textTitleNote.getText().toString();
            String content = textContentNote.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND).setType("message/rfc2822");
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            intent.putExtra(Intent.EXTRA_TEXT, content);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.actionCancel){
            noteCancelling = true;
            finish();
        }
        else if (id == R.id.noteDelete){
            DataManager.getInstance().removeNote(id);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}