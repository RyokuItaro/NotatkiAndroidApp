package com.example.notatkiappstudiamobilki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotesActivity extends AppCompatActivity {
    private NoteRecyclerAdapter noteRecyclerAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        noteRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, NoteActivity.class));
            }
        });

        final RecyclerView notes = findViewById(R.id.listNotes);
        final LinearLayoutManager notesLM = new LinearLayoutManager(this);
        notes.setLayoutManager(notesLM);

        List<NoteInfo> listNotes = DataManager.getInstance().getNotes();
        noteRecyclerAdapter = new NoteRecyclerAdapter(this, listNotes);
        notes.setAdapter(noteRecyclerAdapter);
    }
}